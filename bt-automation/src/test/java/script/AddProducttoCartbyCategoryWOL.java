package script;

import org.openqa.selenium.JavascriptExecutor;
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
import page.SignUpPage;
import page.StoreGridPage;
import page.StoreListPage;

public class AddProducttoCartbyCategoryWOL extends CommonBaseTest {
	

	@Test(priority=16)
	public void AddprodbycategoryWithOutLogin() throws Throwable
	{
	
		SignInPage signinpage = new SignInPage(driver);
		BtHomepage bhp = new BtHomepage(driver);
		MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);
		StoreGridPage sgp = new StoreGridPage(driver);
		StoreListPage slp = new StoreListPage(driver);
		AddtoBagePage atb = new AddtoBagePage(driver);
		CheckOutPage cp = new CheckOutPage(driver);
		SignUpPage sup = new SignUpPage(driver);
		WebDriverUtility wdu = new WebDriverUtility();
		
		Thread.sleep(5000);
		mrp.popUpCloseButton();
		
		String mastcattwo = bhp.getMastercattwo();
		Thread.sleep(1000);
	//	System.out.println("Master category selected: "+ mastcattwo);
		extentTest.log(Status.INFO, "Master category selected: "+ mastcattwo);		
		
		String parentcatonetxt = bhp.getParentcatone();
		Thread.sleep(1000);
	//	System.out.println("Parent category selected: " +parentcatonetxt);
		extentTest.log(Status.INFO, "Parent category selected: "+ parentcatonetxt);		
		
		String breadcrumbsmatertxt = mrp.getBredcrumbsmaster();
		String breadcrumbsparenttxt = mrp.getBredcrumbsparent();
	//	System.out.println("breadcrumbsmatertxt"+breadcrumbsmatertxt);
	//	System.out.println("breadcrumbsparenttxt"+breadcrumbsparenttxt);
		
		if(mastcattwo.equals(breadcrumbsmatertxt) && parentcatonetxt.equals(breadcrumbsparenttxt))
		{
			System.out.println("User entered into the category grid page successfully ");
			extentTest.log(Status.PASS, "User entered into the category grid page successfully ");	
		}
		else
		{
			extentTest.log(Status.FAIL, "Breadcrumbs are not dispalying as expected");	
		}
		
	//	Thread.sleep(3000);
	//	mrp.popUpCloseButton();
					
		String gridproduct = mrp.getGridProduct_name();
	//	System.out.println("Getting the product name from grid page" + gridproduct);
     //   extentTest.log(Status.INFO, "The product name picked from Grid page is: "+gridproduct);
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    
        System.out.println("Scrolling done");
		Thread.sleep(10000);	
		
	      
        //office code
        
       // Thread.sleep(1000);
      //  sup.validateClose();
        
        //till here
	
		WebElement pn = mrp.getFirst_Product();	
		wdu.mouseOverAnElement(driver, pn);
        System.out.println("picked the first product from list");
   
		mrp.clickAddtoBagBtn();
		Thread.sleep(1000);
		String atbprodtext = atb.getATBPopUpProd_Name();
		extentTest.log(Status.INFO, "The product name picked from Add to Bag pop-up is: "+atbprodtext);
		
		atb.getfirstattributedropdown();  //clicking first drop down box
		Thread.sleep(1000);
		atb.getsecondattributedropdown(); //clicking second drop down box
		Thread.sleep(1000);
		
		
		atb.clickATBPopUpBtn(); //Add to bag button in the add to bag pop-up
		System.out.println("Clicked Add to Bag pop-up button");			
		Thread.sleep(3000);
		
		
		bhp.clickCartImg();
		System.out.println("Cart icon clicked");
		Thread.sleep(2000);
		String cpn = cp.getCheckoutProdName();
		System.out.println("Getting product name from checkout page "+cpn);

		extentTest.log(Status.INFO, "The product added to cart is: "+cpn);
		
		if (atbprodtext.equals(cpn))
		{
			System.out.println("Strings are equal");
			extentTest.log(Status.INFO, "The Item added to cart successfully");
			
			String cpLogintxt = cp.getLoginBtn();
			
		    System.out.println("Checkout page login button txt = "+cpLogintxt);
						
			if (cpLogintxt.equals("Login"))
				{
					extentTest.log(Status.PASS, "The user is not logged in and product is added to cart");
				}
			else
				{
					extentTest.log(Status.FAIL, "Login button is missing in the checkout page");
				}
		
		}
		else 
		{
		System.out.println("Strings are NOT equal");
		extentTest.log(Status.FAIL, "The selected item is not added to cart properly");				
		}
		

        cp.RemoveBtn();

        Thread.sleep(3000);

    }
}
