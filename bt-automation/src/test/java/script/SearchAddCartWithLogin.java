package script;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.CommonBaseTest;
import generic.WebDriverUtility;
import page.AddtoBagePage;
import page.BtHomepage;
import page.CheckOutPage;
import page.MultiRetailerGridPage;
import page.SignInPage;

/***
 * 
 * @author Jisha
 *
 */
public class SearchAddCartWithLogin extends CommonBaseTest {

	@Test(priority = 8)
	public void AddProducttocartwithLoginBySearch() throws Throwable {

		BtHomepage bhp = new BtHomepage(driver);
		MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);
		AddtoBagePage atb = new AddtoBagePage(driver);
		CheckOutPage cp = new CheckOutPage(driver);
		SignInPage signinpage = new SignInPage(driver);
		WebDriverUtility wdu = new WebDriverUtility();

		Thread.sleep(5000);
		mrp.popUpCloseButton();

		bhp.PassValue();

		WebElement pn = mrp.getFirst_Product();
		wdu.mouseOverAnElement(driver, pn);

		mrp.clickAddtoBagBtn();

		String prod_name_added = atb.getATBPopUpProd_Name();
		extentTest.log(Status.INFO, "The product name picked from Add to Bag page is: " + prod_name_added);

		atb.clickATBPopUpBtn();
		Thread.sleep(3000);
		bhp.clickCartImg();
		Thread.sleep(1000);
		String cpn = cp.getCheckoutProdName();
		extentTest.log(Status.INFO, "The product added to cart is: " + cpn);

		if (prod_name_added.equals(cpn)) {

			String cpLogintxt = cp.getLoginBtn();

			if (cpLogintxt.equals("Login")) {
				cp.clickLoginBtn();
				Thread.sleep(1000);
				String signInmail = "jisha@springdigital.com.au";
				String signInPassword = "Bt@2023";
				signinpage.enterSingInEmail(signInmail);
				extentTest.log(Status.INFO, "SinginEmail Entered:  " + signInmail);
				signinpage.enterSingInPwd(signInPassword);
				extentTest.log(Status.INFO, "Password:  " + "*******");
				signinpage.btnClick();
				Thread.sleep(10000);
				// extentTest.log(Status.INFO, "User logged in successfully");
				String delopttxt = cp.getDelveryOption();
				String yourGCtxt = cp.getYourGC();
				System.out.println(delopttxt);
				System.out.println(yourGCtxt);

				if (delopttxt.equals("Delivery Options") && yourGCtxt.equals("Deliver to")) {
					extentTest.log(Status.PASS,
							"User is logged in and product added to cart successfully good to make a purchase");
				} else {
					extentTest.log(Status.FAIL, "There is some issue observed while logging from checkout");
				}
			} else {
				extentTest.log(Status.FAIL,
						"Login buggon is not displaying in the checkout page.  User is unable to login from checkout page");
			}
		} else {
			extentTest.log(Status.FAIL, "The product selected by the user is not showing in the checkout page");
		}
		
        cp.RemoveBtn();

        Thread.sleep(1000);
		
	}

}
