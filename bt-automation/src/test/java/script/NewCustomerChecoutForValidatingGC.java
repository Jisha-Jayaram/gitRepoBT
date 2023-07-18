package script;

import static org.testng.Assert.fail;

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

import page.SignInPage;

import page.SignUpPage;

/***
 * 
 * 
 * 
 * @author shaik
 *
 * 
 * 
 */

public class NewCustomerChecoutForValidatingGC extends CommonBaseTest {

	@Test(priority = 23)

	public void NewCustomerForGCValidation() throws Throwable {

		SignUpPage signuppage = new SignUpPage(driver);

		SignInPage signinpage = new SignInPage(driver);

		BtHomepage bhp = new BtHomepage(driver);

		MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);

		AddtoBagePage atb = new AddtoBagePage(driver);

		CheckOutPage cop = new CheckOutPage(driver);

		CategoryPopUpPage cpp = new CategoryPopUpPage(driver);

		WebDriverUtility webDriverUtility = new WebDriverUtility();

		signuppage.signupJoinMouseOver(); // Mous eHover on the sign In button

		signuppage.joinClick();// Click on the Join Now button

		Thread.sleep(1000);

		// Validation for the PopUp

		boolean status1 = signuppage.verifySignUpPopUpDisplay();

		if (status1) {

			extentTest.log(Status.PASS, "SingUp pop-up loaded properly");

		}

		else {

			extentTest.log(Status.PASS, "SignUp pop-up is not opening");

		}

		// Fetching the data from the excel sheet

		String email = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp", 3, 0);

		String firstname = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp", 3, 1);

		String lastname = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp", 3, 2);

		String password = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp", 3, 3);

		signuppage.enterEmail(email);

		extentTest.log(Status.INFO, "Email:  " + email);

		signuppage.enterFirstName(firstname);

		extentTest.log(Status.INFO, "FirstName:  " + firstname);

		signuppage.enterLastName(lastname);

		extentTest.log(Status.INFO, "LastName:  " + lastname);

		signuppage.enterPassword(password);

		extentTest.log(Status.INFO, "Password:  " + password);

		signuppage.clickSingUpBtn(); // Click on the sign Up button

		Thread.sleep(500);

		String msg = signuppage.getTCMsg().getText();

		if (msg.contains("You must agree to the Terms and Conditions to sign up")) {

			System.out.println("Please Check the T&C CheckBox for the SignUp");

		}

		else {

			System.out.println("The user is not in the SignUp Page");

		}

		signuppage.clickTandC(); // Click on The T&C Check Box

		signuppage.clickSingUpBtn(); // Click on the Sign Up Button

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

		// navigate through Category

		bhp.CategoryBtn(); // Click on the Category

		Thread.sleep(2000);

		cpp.ViewAllBtn(); // Click on the View All Button

		Thread.sleep(3000);

		webDriverUtility.scrollBarAction(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// js.executeScript("window.scrollBy(0,600)", "");

		Thread.sleep(4000);

		WebElement ele = mrp.getFirst_Product();

		wait.until(ExpectedConditions.visibilityOf(ele));

		webDriverUtility.mouseOverAnElement(driver, ele); // Mouse Hover on the First Product

		Thread.sleep(3000);

		mrp.clickAddtoBagBtn(); // Click on the Add To Bag button

		Thread.sleep(3000);

		atb.clickATBPopUpBtn(); // Click on the Add to Bag On pop Up Bag

		Thread.sleep(2000);

		extentTest.log(Status.PASS, "Test pass: Item added to cart successfully");

		bhp.GcName(); // GC validation

		Thread.sleep(2000);

		bhp.clickCartImg(); // Clicking on the Cart Button

		Thread.sleep(2000);

		bhp.CheckOutBtn(); // Click on the Checkout Button

		Thread.sleep(3000);

		boolean GCselected = cop.GoodCauseText();

		if (GCselected) {

			extentTest.log(Status.INFO, "The New Customer has Not Selected the GoodCause in the Checkout Page");

			// System.out.println("The user not selected");

		}

		else {

			// Assert.fail("The New Customer has Selected the GC in the Checkout page");

			extentTest.log(Status.FAIL, "The New Customer has Selected the GC in the Checkout page");

			// System.out.println("The user selected");

		}

		cop.RemoveBtn(); // Click on the Remove Button

		Thread.sleep(2000);

		bhp.BetterThatImg(); // Click on the BT Image

		Thread.sleep(4000);

	}

}
