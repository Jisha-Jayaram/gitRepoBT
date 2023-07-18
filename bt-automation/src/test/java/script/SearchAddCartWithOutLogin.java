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

/***
 * 
 * @author Jisha
 *
 */

public class SearchAddCartWithOutLogin extends CommonBaseTest {
	@Test(priority = 7)
	public void AddProductbySearchWithoutLogin() throws Throwable {

		BtHomepage bhp = new BtHomepage(driver);
		MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);
		AddtoBagePage atb = new AddtoBagePage(driver);
		CheckOutPage cp = new CheckOutPage(driver);
		WebDriverUtility wdu = new WebDriverUtility();
		boolean cartCount;

		Thread.sleep(3000);
		mrp.popUpCloseButton();

		bhp.PassValue();

//			String CurrentPageTitle = driver.getTitle();
//			System.out.println("Page:  "+CurrentPageTitle+"   Opened");
//			String url = driver.getCurrentUrl();
//			System.out.println("The page url is : "+url);

		// String gridproduct = mrp.getGridProduct_name();
		// extentTest.log(Status.INFO, "The product name picked from Grid page is:
		// "+gridproduct);

		WebElement pn = mrp.getFirst_Product();
		wdu.mouseOverAnElement(driver, pn);

		mrp.clickAddtoBagBtn();
		Thread.sleep(1000);
		String prod_name_added = atb.getATBPopUpProd_Name();
		// System.out.println("The product name picked from Add to Bag page is:
		// "+prod_name_added);
		extentTest.log(Status.INFO, "The product name picked from Add to Bag page is: " + prod_name_added);

		atb.clickATBPopUpBtn();
		// System.out.println("Item added to cart successfully");
		Thread.sleep(3000);
		// extentTest.log(Status.PASS, "Test pass: Item added to cart successfully");

		cartCount = bhp.getCartImgNum();
		if (cartCount) {
			extentTest.log(Status.INFO, "Test Pass: Bag icon count on top is one");
		} else {
			extentTest.log(Status.FAIL, "Test Fail: There is a mismatch observed in the bagicon number");
		}
		bhp.clickCartImg();
		String cpn = cp.getCheckoutProdName();
		extentTest.log(Status.INFO, "The product added to cart is: " + cpn);

		if (prod_name_added.equals(cpn)) {
			// System.out.println("Strings are equal");
			extentTest.log(Status.INFO, "The Item added to cart successfully");

			String cpLogintxt = cp.getLoginBtn();

			if (cpLogintxt.equals("Login")) {
				extentTest.log(Status.PASS, "Checkout page without login is getting displayed as expected");
			} else {
				extentTest.log(Status.FAIL,
						"Login buggon is not displaying for a logged out user who added product into the checkoutpage");
			}
		} else {
			// System.out.println("Strings are NOT equal");
			extentTest.log(Status.FAIL, "The selected item is not added to cart properly");
		}

		// ExtentManager.getTest().log(Status.valueOf(element)
		// extentTest.log(Status.INFO, "The ")
		
        cp.RemoveBtn();

        Thread.sleep(1000);
		

	}

}
