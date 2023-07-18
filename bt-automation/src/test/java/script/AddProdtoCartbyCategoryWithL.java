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
import page.WhislistPage;

/**
* @author Jisha Jayaram
*
*/
public class AddProdtoCartbyCategoryWithL extends CommonBaseTest{
	@Test (priority =15)
	public void AddprodbycatWL() throws Throwable
	{
//		try {
			
			SignInPage signinpage = new SignInPage(driver);
			BtHomepage bhp = new BtHomepage(driver);
			MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);
			StoreGridPage sgp = new StoreGridPage(driver);
			StoreListPage slp = new StoreListPage(driver);
			AddtoBagePage atb = new AddtoBagePage(driver);
			CheckOutPage cp = new CheckOutPage(driver);
			WebDriverUtility wdu = new WebDriverUtility();
			
			Thread.sleep(5000);
			mrp.popUpCloseButton();
	
			signinpage.signinJoinMouseOver();
			signinpage.singInClick();
			Thread.sleep(1000);
			
			String signInmail = "jisha@springdigital.com.au";
			String signInPassword ="Bt@2023";
			signinpage.enterSingInEmail(signInmail);
			signinpage.enterSingInPwd(signInPassword);
			signinpage.btnClick();
			Thread.sleep(5000);
			
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
			System.out.println("Cat icon clicked");
			Thread.sleep(2000);
			String cpn = cp.getCheckoutProdName();
			System.out.println("Getting product name from checkout page "+cpn);

			extentTest.log(Status.INFO, "The product added to cart is: "+cpn);
			
			if (atbprodtext.equals(cpn))
			{
				System.out.println("Strings are equal");
				extentTest.log(Status.INFO, "The Item added to cart successfully");
			
			String delopttxt = cp.getDelveryOption();
			String yourGCtxt = cp.getYourGC();							
			System.out.println(delopttxt);
			System.out.println(yourGCtxt);
			
			if(delopttxt.equals("Delivery Options")&& yourGCtxt.equals("Deliver to"))
			   {
				extentTest.log(Status.PASS,"User is logged in and product added to cart successfully" );
			   }
			else
			   {
				extentTest.log(Status.FAIL,"Delivery options and Delivery to sections are missing in the checkout" );
			   }

			}
			else 
			{
			System.out.println("Strings are NOT equal");
			extentTest.log(Status.FAIL, "The selected item is not added to cart properly");				
			}
			
			Thread.sleep(1000);
			//js.executeScript("window.scrollBy(0,-500)","");

	        cp.RemoveBtn();

	        Thread.sleep(1000);
			
	

	}

}
