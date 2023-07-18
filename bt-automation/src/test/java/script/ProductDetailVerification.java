package script;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

/**
* @author Jisha Jayaram
*
*/

import generic.CommonBaseTest;
import generic.WebDriverUtility;
import page.AddtoBagePage;
import page.BtHomepage;
import page.CheckOutPage;
import page.MultiRetailerGridPage;
import page.SignInPage;
import page.StoreGridPage;
import page.StoreListPage;
public class ProductDetailVerification extends CommonBaseTest{
	@Test(priority=100)
	public void ProductDetailsPage() throws Throwable
	{
		SignInPage signinpage = new SignInPage(driver);
		BtHomepage bhp = new BtHomepage(driver);
		MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);
		StoreGridPage sgp = new StoreGridPage(driver);
		StoreListPage slp = new StoreListPage(driver);
		AddtoBagePage atb = new AddtoBagePage(driver);
		CheckOutPage cp = new CheckOutPage(driver);
		WebDriverUtility wdu = new WebDriverUtility();
		
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
					
		String gridproduct = mrp.getGridProduct_name();
		System.out.println("Getting the product name from grid page" + gridproduct);
        extentTest.log(Status.INFO, "The product name picked from Grid page is: "+gridproduct);
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    
        System.out.println("Scrolling done");
		Thread.sleep(5000);	
		
         WebElement pn = mrp.getFirst_Product();	
         wdu.mouseOverAnElement(driver, pn);
         System.out.println("picked the first product from list");
         
         

	}

}
