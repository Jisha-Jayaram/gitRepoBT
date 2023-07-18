package script;

import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.CommonBaseTest;
import generic.IAutoConstant;
import page.SignUpPage;

/**
* @author Jisha Jayaram
*
*/

public class SignUpPopUpDisplay extends CommonBaseTest{
	
	private static final ITestResult ITestResult = null;

	@Test(priority = 1)
	public void testSignUpPopUpDispaly() throws InterruptedException {
		
		SignUpPage signuppage2 = new SignUpPage(driver);
		boolean status3 = signuppage2.verifySignUpPopUpDisplay();
		
		if (status3) {
		extentTest.log(Status.PASS, "SingUp pop-up loaded properly");
		Thread.sleep(2000);
		signuppage2.validateClose();
		}
		else {
		extentTest.log(Status.FAIL, "SignUp pop-up is not opening");
		}
		
	}

}
