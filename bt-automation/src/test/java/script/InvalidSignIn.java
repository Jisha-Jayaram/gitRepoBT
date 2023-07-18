package script;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.Status;
import generic.CommonBaseTest;
import page.SignInPage;

/**
* @author Jisha Jayaram
*
*/

public class InvalidSignIn extends CommonBaseTest {
	
	@Test(priority = 5, dataProvider ="credentials")
	public void testInvalidSignIn(String scenario, String emails, String passwords) throws InterruptedException {
		
		SignInPage signinpage2 = new SignInPage(driver);
		signinpage2.signinJoinMouseOver();
		signinpage2.singInClick();
		Thread.sleep(2000);
		
		signinpage2.enterSingInEmail(emails);
		signinpage2.enterSingInPwd(passwords);
		signinpage2.btnClick();
		Thread.sleep(2000);
		
		if(scenario.equals("wrongemail"))
		{
			boolean emailtxt = signinpage2.validateemailerror();
			String validationmsg1 = signinpage2.emailerrortxt;
			
			if(emailtxt) {
				
     			extentTest.log(Status.PASS, "SCENARIO 1: Test is pass: Incorrect email error message is getting displayed as below.");
     			System.out.println("SCENARIO1:Please enter a valid email");
     	//		Assert.assertEquals(emailtxt, "Error message not displayed as expected");
				extentTest.log(Status.INFO, validationmsg1);
			}
			 else
		     	{
					
					extentTest.log(Status.FAIL, validationmsg1);
					Assert.fail("SCENARIO 1: Test is Failed: The expected message is getting displayed as above");
			    }
		}
		else if(scenario.equals("Wrongpwd")) {
			
			boolean pwdtxt = signinpage2.validatpwderror();
			String validationmsg2 = signinpage2.pwderrortxt;
			if(pwdtxt ) {
				
				extentTest.log(Status.PASS, "SCENARIO 2: Test is pass: Incorrect password error message is getting displayed as expected.");
				System.out.println("SCENARIO2: Incorrect password");
				extentTest.log(Status.INFO, validationmsg2);
		    }
		    else
	     	{
				
				extentTest.log(Status.FAIL, validationmsg2);
				Assert.fail("SCENARIO 2: Test is Failed: The expected message is getting displayed as above");
		    }
		}
		else if (scenario.equals("bothworng"))
		{
			boolean Errstatus = signinpage2.validateerrors();
			if(Errstatus)
			{
			    extentTest.log(Status.PASS, "SCENARIO 3 Executed and Validation messages dispalaying as expected");
			    System.out.println("SCENARIO3: Success!!!!!!!!!!");
			}
			else
			{
				Assert.fail("SCENARIO 3: Test is Failed: The expected message is not getting displayed properly");
			}
		}
					
	}

	@DataProvider (name="credentials")
	
	public Object[][] getData()
	{
		return new Object[][] {
			{"wrongemail","jisj","Bt@2023"},
			{"Wrongpwd","jisha@springdigital.com.au","abcdefg"},
			{"bothworng","",""}
		};	
	}

}
