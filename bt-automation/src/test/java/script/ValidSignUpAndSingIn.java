package script;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BTExcel;
import generic.CommonBaseTest;
import page.BackendCustomerPage;
import page.BackendDashBoardPage;
import page.BackendLoginPage;
import page.BtHomepage;
import page.EditCustomerPage;
import page.SignInPage;
import page.SignUpPage;
import page.ThanksRegisterPage;

/**
* @author Jisha Jayaram
*
*/

public class ValidSignUpAndSingIn extends CommonBaseTest {

	@Test(priority = 2)
	public void testNewUserSignUpAndSingIn() throws InterruptedException {
		
		SignUpPage signuppage = new SignUpPage(driver);
		BackendLoginPage blp = new BackendLoginPage(driver);
		BackendDashBoardPage bdp = new BackendDashBoardPage(driver);
		BackendCustomerPage bcp = new BackendCustomerPage(driver);
		EditCustomerPage ecp = new EditCustomerPage(driver);
		ThanksRegisterPage trp = new ThanksRegisterPage(driver);
		
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
		
		String email = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",1, 0);
		String firstname = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",1, 1);
		String lastname = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",1, 2);
		String password = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",1, 3);
		
		signuppage.enterEmail(email);
		extentTest.log(Status.INFO, "Email entered:  "+email);
		
		signuppage.enterFirstName(firstname);
		extentTest.log(Status.INFO, "FirstName entered:  "+firstname);
		
		signuppage.enterLastName(lastname);
		extentTest.log(Status.INFO, "LastName entered:  "+lastname);
		
		signuppage.enterPassword(password);
		extentTest.log(Status.INFO, "Password entered:  "+password);
		
		signuppage.clickTandC();
		Thread.sleep(2000);
		signuppage.clickSingUpBtn();
    	Thread.sleep(500);
		boolean status2 = signuppage.verifyActivationEmail();
		if(status2) {
		extentTest.log(Status.INFO, "Message displayed: Please check your email and press the activation link.");
		}
		else {
	    Assert.fail("Test is Failed: Recheck the entered details on sign up page again.  Sucessful signup message is not getting displayed");
		}
		
		//Opening back end for user activation
		
        Thread.sleep(2000);
       ((JavascriptExecutor) driver).executeScript("window.open();");
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);
        driver.get("https://dev.betterthat.shop/login");
        Thread.sleep(2000);
        blp.enterBackendEmail("sreeja+admin@springdigital.com.au");
        extentTest.log(Status.INFO, "Backend:SinginEmail Entered:  sreeja+admin@springdigital.com.a");
        blp.enterBackendPw("Sreeja@123");
        extentTest.log(Status.INFO, "Backend:Password Entered:  Sreeja@123");
        blp.loginBtnClick();
        Thread.sleep(3000);
        
        bdp.CustomerBtnClick();
        Thread.sleep(2000);
        bdp.setSearchcust(email);
        Thread.sleep(3000); 
        
        bcp.ClickExpandActionElement();
        Thread.sleep(1000);
        
        bcp.ActionBtnClick();
        Thread.sleep(1000);
        
        bcp.EditBtnClick();
        Select status = new Select(driver.findElement(By.id("isActive")));
        List<WebElement> lst = status.getOptions();
        for(WebElement options: lst)
 
        status.selectByIndex(1);
        
        Thread.sleep(1000);
        status.getFirstSelectedOption().click();
        
        String phno="0";
        ecp.setPhnotxtfld(phno);
        Thread.sleep(1000);

        Select gc = new Select(driver.findElement(By.name("charity_id")));
        List<WebElement> list = gc.getOptions();

        for(WebElement options: list)

        gc.selectByIndex(2);
        gc.getFirstSelectedOption().click();
  
        Thread.sleep(1000);
        
        ecp.SaveBtnClick();
        Thread.sleep(2000);
        
        extentTest.log(Status.INFO, "Backend:Newly registered user activated from backend sucessfully");
        
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(2000);
        
        trp.CloseBtnClick();
        
        SignInPage signinpage = new SignInPage(driver);
		BtHomepage bhp = new BtHomepage(driver);
		signinpage.signinJoinMouseOver();
		signinpage.singInClick();
		Thread.sleep(1000);
		
		signinpage.enterSingInEmail(email);
		extentTest.log(Status.INFO, "Front end:Email Entered:  "+email);
		Thread.sleep(1000);
		signinpage.enterSingInPwd(password);
		extentTest.log(Status.INFO, "Front end:password Entered:  "+password);
		Thread.sleep(1000);
		signinpage.btnClick();
		Thread.sleep(3000);
		 
		 boolean hometxt = bhp.VerifyMyAccount();
			if(hometxt) {
				extentTest.log(Status.INFO, "Newly registered user logged in successfully");
				extentTest.log(Status.INFO, "Test is passed. Home page displayed successfully.");

	             }
			else {
			    Assert.fail("Test is Failed: Please verify the entered user credentials.  Unable to login");
				}
			
		driver.switchTo().window(tabs.get(1));
	    Thread.sleep(2000);
	    
	    bdp.CustomerBtnClick();
        Thread.sleep(2000);

        bdp.setSearchcust(email);
        Thread.sleep(3000);
        
        bcp.ClickExpandActionElement();
        Thread.sleep(1000);
        
        bcp.ActionBtnClick();
        Thread.sleep(1000);
			
		bcp.DeleteBtnClick();
		Thread.sleep(1000);
		bcp.DeleteConfirmBtnClick();
		Thread.sleep(2000);
		
	}
}
