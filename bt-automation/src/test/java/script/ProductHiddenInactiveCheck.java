package script;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.CommonBaseTest;
import page.BackendDashBoardPage;
import page.BackendLoginPage;
import page.RetailerProductPage;

public class ProductHiddenInactiveCheck extends CommonBaseTest{
	
	@Test(priority = 32)
	public void HiddenProductCheck() throws Throwable{
		
		BackendLoginPage blp = new BackendLoginPage(driver);
	    BackendDashBoardPage bdbp = new BackendDashBoardPage(driver);
	    RetailerProductPage rpp = new RetailerProductPage(driver);
		
		Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.open();");
        Thread.sleep(2000);
        
        //System.out.println(driver.getWindowHandles().size());
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);
        
        driver.get("https://dev.betterthat.shop/login");
        Thread.sleep(2000);
        blp.enterBackendEmail("sreeja+admin@springdigital.com.au");
        blp.enterBackendPw("Sreeja@123");
        blp.loginBtnClick();
        Thread.sleep(3000);
        
        bdbp.ProductBtnclick();
        Thread.sleep(1000);
        
        bdbp.ProductInfoBtnClick();
        Thread.sleep(1000);
        
        rpp.RetailerDropDownClick();
        Thread.sleep(2000);
        
        List<WebElement> allRetailers = rpp.ListRetailerDispaly();
        System.out.println("In scrpt: the size" + allRetailers.size());
        
        String retailer = allRetailers.get(3).getText();
        
        System.out.println("Retailer Name : "+ retailer);
        
        allRetailers.get(5).click(); 
        
        int rownum=1;
        String xp;
		try {
			
			List<WebElement> allActions = rpp.allActionsBtns();
			int countloop = allActions.size(); // Total number of Actions button
			System.out.println("Number of Products under selected retailer : " + countloop);
			
		}
        catch (Exception e) {
		System.out.println("No such element ");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}

}
