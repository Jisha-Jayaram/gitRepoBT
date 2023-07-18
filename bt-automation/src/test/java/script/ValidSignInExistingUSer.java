package script;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BTExcel;
import generic.CommonBaseTest;
import page.BtHomepage;
import page.SignInPage;

/**
* @author Jisha Jayaram
*
*/

public class ValidSignInExistingUSer extends CommonBaseTest {
	
	@Test(priority = 4)
	public void testValidSignInWithExistingUser() throws InterruptedException {
		
//		try {
		
		SignInPage signinpage = new SignInPage(driver);
		BtHomepage bhp = new BtHomepage(driver);
		signinpage.signinJoinMouseOver();
		signinpage.singInClick();
		Thread.sleep(1000);
		//String singInmail = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",1, 0);
		//String signInpassword = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",1, 3);
		String signInmail = "jisha@springdigital.com.au";
		String signInPassword ="Bt@2023";
		signinpage.enterSingInEmail(signInmail);
		extentTest.log(Status.INFO, "SinginEmail Entered:  "+signInmail);
		signinpage.enterSingInPwd(signInPassword);
		extentTest.log(Status.INFO, "Password:  "+"*******");
		signinpage.btnClick();
		Thread.sleep(10000);
		boolean hometxt = bhp.VerifyMyAccount();
		if(hometxt) {
			extentTest.log(Status.INFO, "User logged successfully");
			extentTest.log(Status.INFO, "Test is passed. Home page displayed successfully.");

             }
		else {
		    Assert.fail("Test is Failed: Please verify the entered user credentials.  Unable to login");
			}
 //      }
//		catch(Exception e)
//		{
//			extentTest.log(Status.FAIL, "Caught into Error"+e.getMessage());
//		}
   }
}
