package script;

import java.util.Random;

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

import page.CheckOutPage;

import page.MultiRetailerGridPage;

import page.MyAccountPage;

import page.SignInPage;

import page.SignUpPage;

import page.StoresNamePage;

/***
 * 
 * 
 * 
 * @author shaik
 *
 * 
 * 
 */

public class NewCustomerCheckOutAndValidationForAddress extends CommonBaseTest {

	@Test(priority = 22)

	public void NewCustomerCheckOutWithAddressValidation() throws Throwable {

		SignUpPage signuppage = new SignUpPage(driver);

		SignInPage signinpage = new SignInPage(driver);

		BtHomepage bhp = new BtHomepage(driver);

		StoresNamePage snp = new StoresNamePage(driver);

		MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);

		AddtoBagePage atb = new AddtoBagePage(driver);

		CheckOutPage cop = new CheckOutPage(driver);

		MyAccountPage map = new MyAccountPage(driver);

		WebDriverUtility wdu = new WebDriverUtility();

		signuppage.signupJoinMouseOver(); // Mouse Hover on the SignIn button

		signuppage.joinClick(); // Click on Join button

		Thread.sleep(1000);

		boolean status1 = signuppage.verifySignUpPopUpDisplay();

		if (status1) {

			extentTest.log(Status.INFO, "SingUp pop-up loaded properly");

		}

		else {

			extentTest.log(Status.INFO, "SignUp pop-up is not opening");

		}

		String email = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp", 2, 0);

		String firstname = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp", 2, 1);

		String lastname = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp", 2, 2);

		String password = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp", 2, 3);

		signuppage.enterEmail(email);

		extentTest.log(Status.INFO, "Email:  " + email);

		signuppage.enterFirstName(firstname);

		extentTest.log(Status.INFO, "FirstName:  " + firstname);

		signuppage.enterLastName(lastname);

		extentTest.log(Status.INFO, "LastName:  " + lastname);

		signuppage.enterPassword(password);

		extentTest.log(Status.INFO, "Password:  " + password);

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

		extentTest.log(Status.INFO, "SinginEmail Entered:  " + email);

		signinpage.enterSingInPwd(password);

		extentTest.log(Status.INFO, "Password:  " + "*******");

		signinpage.btnClick();

		Thread.sleep(5000);

		boolean hometxt = bhp.VerifyMyAccount();

		if (hometxt) {

			extentTest.log(Status.INFO, "User logged successfully");

			extentTest.log(Status.INFO, "Test is passed. Home page displayed successfully.");

		}

		else {

			Assert.fail("Test is Failed: Please verify the entered user credentials.  Unable to login");

		}

		// Navigate to Store page

		bhp.StrsBtn(); // Click on the Stores Button

		Thread.sleep(2000);

		snp.RetaileStr(); // Click on the First Retailer

		Thread.sleep(2000);

		// Validation for the Page

		String breadcum = mrp.getBreadCrum().getText();

		if (breadcum.contains("All Stores")) {

			System.out.println("Store Grid Page");

			extentTest.log(Status.PASS, "We have Successfully Navigated to Store Grid Page");

		}

		wdu.scrollBarAction(driver);

		Thread.sleep(3000);

		WebElement ele = mrp.getFirst_Product();

		wait.until(ExpectedConditions.visibilityOf(ele));

		wdu.mouseOverAnElement(driver, ele); // Mouse Hover on the First Product

		Thread.sleep(3000);

		String productNameOnGridPage = mrp.getGridProduct_name();

		Thread.sleep(2000);

		mrp.clickAddtoBagBtn();

		Thread.sleep(1000);

		atb.clickATBPopUpBtn();

		System.out.println("Item added to cart successfully");

		Thread.sleep(2000);

		extentTest.log(Status.PASS, "Test pass: Item added to cart successfully");

		boolean cartCount = bhp.getCartImgNum();

		if (cartCount) {

			extentTest.log(Status.INFO, "Test Pass: Bag icon count on top is one");

		}

		else

		{

			extentTest.log(Status.FAIL, "Test Fail: There is a mismatch observed in the bagicon number");

		}

		bhp.clickCartImg(); // Click on the Cart Image

		bhp.CheckOutBtn(); // Click on the Checkout Button

		Thread.sleep(3000);

		// To verify the Customer is New or Existing Customer

		String name = cop.getAddAddressButton().getText();

		if (name.contains("Add Address")) {

			System.out.println("The user is new Customer and not added the Shipping/Delivery Address ");

			extentTest.log(Status.PASS, "The user is new Customer and not added the Shipping/Delivery Address ");

		}

		else {

			System.out.println("The user is Existing Customer and already added the Shipping/Delivery Address");

			extentTest.log(Status.FAIL,
					"The user is Existing Customer and already added the Shipping/Delivery Address");

		}

		WebElement ele1 = driver.findElement(By.xpath("//span[@class='Header_userNameClass__nl8jn']"));

		Actions action = new Actions(driver);

		action.moveToElement(ele1).perform();

		bhp.MyAccount();

		Thread.sleep(2000);

		map.MyAddress();

		Thread.sleep(2000);

		map.BreadCum();

		Thread.sleep(2000);

		String text = map.getAddressText().getText();

		if (text.contains("No address found!")) {

			System.out.println("The User is new Customer and he has not added the address ");

			extentTest.log(Status.PASS, "The user is new Customer and he needs to add the address");

		}

		else {

			System.out.println("The User is Existing customer and he has added the address");

			extentTest.log(Status.FAIL, "The user is Existing Customer and he already added the address");

		}

		bhp.CheckOutBtn();

		Thread.sleep(2000);

		cop.RemoveBtn();

		bhp.BetterThatImg();

		Thread.sleep(2000);

	}

}
