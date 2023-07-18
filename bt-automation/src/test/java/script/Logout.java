package script;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.CommonBaseTest;
import page.BtHomepage;
import page.SignInPage;

/**
* @author Jisha Jayaram
*
*/

public class Logout extends CommonBaseTest{
	
	@Test(priority = 6)
	public void testLogout() throws InterruptedException {
		
		SignInPage signinpage2 = new SignInPage(driver);
		BtHomepage bhp2 = new BtHomepage(driver);
		
		signinpage2.signinJoinMouseOver();
		signinpage2.singInClick();
		Thread.sleep(1000);
		
		String signInmail = "jisha@springdigital.com.au";
		String signInPassword ="Bt@2023";
		signinpage2.enterSingInEmail(signInmail);
		extentTest.log(Status.INFO, "SinginEmail Entered:  "+signInmail);
		signinpage2.enterSingInPwd(signInPassword);
		extentTest.log(Status.INFO, "Password:  "+"*******");
		signinpage2.btnClick();
		Thread.sleep(5000);
		
//		boolean hometxt = bhp2.VerifyMyAccount();
//		if(hometxt) {
//			extentTest.log(Status.INFO, "User logged successfully");
//
//             }
//		else {
//		    Assert.fail("Test is Failed: Please verify the entered user credentials.  Unable to login");
//			}
		
		bhp2.myAccount_Mouseover();
		//Thread.sleep(1000);
		
		bhp2.logoutClick();
		Thread.sleep(5000);
		
		boolean logouttxt = signinpage2.VerifySignInTxt();
		if(logouttxt)
		{
			extentTest.log(Status.PASS, "User logged out successfully");
		}
		else
		{
			Assert.fail("Test is Failed: Unable to logout");
		}
		
	}

}
