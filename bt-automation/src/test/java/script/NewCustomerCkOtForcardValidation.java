package script;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BTExcel;

import generic.CommonBaseTest;

import generic.WebDriverUtility;

import page.AddtoBagePage;

import page.BtHomepage;

import page.CategoryPopUpPage;

import page.CheckOutPage;

import page.MultiRetailerGridPage;

import page.MyAccountPage;

import page.SignInPage;

import page.SignUpPage;

import page.StoresNamePage;

 

public class NewCustomerCkOtForcardValidation extends CommonBaseTest {

    @Test(priority = 24)

    public void NewCustomerforcardValidation() throws Throwable {

        SignUpPage signuppage = new SignUpPage(driver);

        SignInPage signinpage = new SignInPage(driver);

        BtHomepage bhp = new BtHomepage(driver);

        MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);

        AddtoBagePage atb = new AddtoBagePage(driver);

        CheckOutPage cop = new CheckOutPage(driver);

        CategoryPopUpPage cpp = new CategoryPopUpPage(driver);

        WebDriverUtility webDriverUtility = new WebDriverUtility();

 

        signuppage.signupJoinMouseOver();

        signuppage.joinClick();

        Thread.sleep(1000);

        boolean status1 = signuppage.verifySignUpPopUpDisplay();

        if (status1) {

            extentTest.log(Status.INFO, "SingUp pop-up loaded properly");

        }

        else {

            extentTest.log(Status.INFO, "SignUp pop-up is not opening");

        }

 

        String email = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",3, 0);

        String firstname = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",3, 1);

        String lastname = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",3, 2);

        String password = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",3, 3);

 

        signuppage.enterEmail(email);

        extentTest.log(Status.INFO, "Email:  "+email);

        signuppage.enterFirstName(firstname);

        extentTest.log(Status.INFO, "FirstName:  "+firstname);

        signuppage.enterLastName(lastname);

        extentTest.log(Status.INFO, "LastName:  "+lastname);

        signuppage.enterPassword(password);

        extentTest.log(Status.INFO, "Password:  "+password);

        signuppage.clickSingUpBtn();

        Thread.sleep(500);

        String msg = signuppage.getTCMsg().getText();

        if (msg.contains("You must agree to the Terms and Conditions to sign up")) {

            System.out.println("Please Check the T&C CheckBox for the SignUp");

        }

        else {

            System.out.println("The user is not in the SignUp Page");

        }

 

        signuppage.clickTandC();

        signuppage.clickSingUpBtn();

 

        String errorMsg = signuppage.getEmailTextFieldMsg().getText();

        if (errorMsg.contains("Email address already in use.")) {

            signuppage.LoginBtn();

        }

        else {

            System.out.println("Please enter the Valid mailId");

        }

 

        signinpage.enterSingInEmail(email);

        extentTest.log(Status.INFO, "SinginEmail Entered:  "+ email);

 

        signinpage.enterSingInPwd(password);

        extentTest.log(Status.INFO, "Password:  "+"*******");

 

        signinpage.btnClick();

        Thread.sleep(5000);

 

        boolean hometxt = bhp.VerifyMyAccount();

        if(hometxt) {

            extentTest.log(Status.INFO, "User logged successfully");

            extentTest.log(Status.INFO, "Test is passed. Home page displayed successfully.");

 

        }

        else {

            Assert.fail("Test is Failed: Please verify the entered user credentials.  Unable to login");

        }

 

        //navigate through Category

        bhp.CategoryBtn();

        Thread.sleep(2000);

 

        cpp.ViewAllBtn();

        Thread.sleep(3000);

        webDriverUtility.scrollBarAction(driver);

        JavascriptExecutor js = (JavascriptExecutor)driver;

        //js.executeScript("window.scrollBy(0,600)", "");

        Thread.sleep(4000);

 

        WebElement ele = driver.findElement(By.xpath("//div[@class='listing_productImage__dR7Sj']/span/img"));

        Actions action = new Actions(driver);

        action.moveToElement(ele).perform();

        Thread.sleep(3000);

 

        mrp.clickAddtoBagBtn();

        Thread.sleep(3000);

 

        atb.clickATBPopUpBtn();

        Thread.sleep(3000);

        extentTest.log(Status.PASS, "Test pass: Item added to cart successfully");

        bhp.clickCartImg();

 

        bhp.CheckOutBtn();

        Thread.sleep(3000);

        webDriverUtility.scrollBarAction(driver);


        //Validating Name Text Field

        boolean nameValidate = cop.CardNameTextField();

        if (nameValidate) {

            extentTest.log(Status.PASS, "The New Customer has not added the Name in the Card Details Text field");

        }

        else {

            extentTest.log(Status.PASS, "The New Customer has  added the Name in the Card Details Text field");

        }

        Thread.sleep(2000);

        //Validating Card Number Text Field

        boolean noValidate = cop.CardNoTextField();

        if (noValidate) {

            extentTest.log(Status.PASS, "The New Customer has not added the CardNumber in the Card number field");

        }

        else {

            extentTest.log(Status.PASS, "The New Customer has  added the Name in the Card number field");

        }

        /*

        //Validate ExpDate textField

        boolean numValidate = cop.ExpiredateTextField();

        if (numValidate) {

            extentTest.log(Status.PASS, "The New Customer has not added the CardNumber in the Card number field");

        }

        else {

            extentTest.log(Status.PASS, "The New Customer has  added the Name in the Card number field");

        }

        //Validate CVV textField

        boolean cvvtextValidate = cop.CvvTextField();

        if (cvvtextValidate) {

            extentTest.log(Status.PASS, "The New Customer has not added the CardNumber in the Card number field");

        }

        else {

            extentTest.log(Status.PASS, "The New Customer has  added the Name in the Card number field");

        }

        */


       cop.AddPaymentBtn();// changes added - parameter driver added


        boolean noValidation = cop.CardNoTextFldMsg();

        if (noValidation) {

            extentTest.log(Status.PASS, "The New Customer has not added the CardNumber in the Card number field");

        }

        else {

            extentTest.log(Status.PASS, "The New Customer has  added the Number in the Card number field");

        }


        //CardNameTextFldMsg()


        boolean nameValidation = cop.CardNameTextFldMsg();

        if (nameValidation) {

            extentTest.log(Status.PASS, "The New Customer has not added the CardName in the Card Name Text field");

        }

        else {

            extentTest.log(Status.PASS, "The New Customer has  added the Name in the Card Name field");

        }


        js.executeScript("window.scrollBy(0,-800)", "");

        Thread.sleep(3000);

        cop.RemoveBtn();

        bhp.BetterThatImg();

        Thread.sleep(2000);

    }

 

}
