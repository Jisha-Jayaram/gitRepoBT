package script;

 

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

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

 

public class NewCustomerCkOtforShippingValidation extends CommonBaseTest {

 

    @Test(priority = 25)

    public void NewCustomerCheckOutforShippingValidation() throws Throwable {

        SignUpPage signuppage = new SignUpPage(driver);

        SignInPage signinpage = new SignInPage(driver);

        BtHomepage bhp = new BtHomepage(driver);

        StoresNamePage snp = new StoresNamePage(driver);

        MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);

        AddtoBagePage atb = new AddtoBagePage(driver);

        CheckOutPage cop = new CheckOutPage(driver);

        MyAccountPage map = new MyAccountPage(driver);

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

        extentTest.log(Status.PASS, "Test pass: Item added to cart successfully");

        Thread.sleep(3000);


        bhp.clickCartImg();

        bhp.CheckOutBtn();

        Thread.sleep(3000);

        webDriverUtility.scrollBarAction(driver);

        //js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(3000);

        String text = cop.ShippingAddress();

        if (text.contains("Australia")) {

            System.out.println("The Address is already pressnt");

        }

        else {

            cop.AddNewAddressBtn();

            Thread.sleep(4000);

            System.out.println("New address Added");

        }

        js.executeScript("window.scrollBy(0,-700)");

        Thread.sleep(2000);

        boolean validation = cop.VerifyDeliveryOptionSelection();

        if (validation) {

            extentTest.log(Status.INFO, "The New Customer has not selected the Delivery option");

        }

        else {

            Assert.fail("The New Customer has selected the Delivery Option");

            }

        js.executeScript("window.scrollBy(0,1000)");

        Thread.sleep(4000);

        cop.UnabledPlaceOrder();

        Thread.sleep(2000);


        msg=cop.PlaceOrderBtnmsg();

        if (msg.contains("Please select Delivery Options.")) {

            System.out.println("The New Customer has not selected the Delivery Option");

            extentTest.log(Status.PASS, "The New Customer has not Selected the Delivery Options");

        }

        else {

        extentTest.log(Status.FAIL, "The New Customer has Selected the Delivery Options");

        }

        Thread.sleep(3000);

        driver.navigate().refresh();


        cop.RemoveBtn();

        Thread.sleep(2000);

        bhp.BetterThatImg();

        Thread.sleep(4000);

    }

}
