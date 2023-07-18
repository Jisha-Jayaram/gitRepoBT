package script;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BTExcel;
import generic.CommonBaseTest;
import page.SignUpPage;

/**
* @author Jisha Jayaram
*
*/

public class InvalidSignUp extends CommonBaseTest {
	
 //   @Parameters({"email", "firstname", "lastname", "password"})
	
	@Test(priority = 3)
	//public void testInvalidSignUpValidationMsg(String email, String firstname, String lastname, String password) throws InterruptedException {
	public void testInvalidSignUpValidationMsg()throws InterruptedException {

		SignUpPage signuppage3 = new SignUpPage(driver);
		signuppage3.signupJoinMouseOver();
		signuppage3.joinClick();
		Thread.sleep(1000);
		
		boolean status1 = signuppage3.verifySignUpPopUpDisplay();
		if (status1) {
		extentTest.log(Status.INFO, "SingUp pop-up loaded properly");
		}
		else {
		extentTest.log(Status.INFO, "SignUp pop-up is not opening");
		}
		
        signuppage3.clickSingUpBtn(); //Without entering any input, clicking on SignUP button
		Thread.sleep(2000);
				
		extentTest.log(Status.INFO, "SECNARIO 1: When user leaves the fields as blank while sign-up process............");
		
		String[] ret_Arr = signuppage3.validagteBlankErrorMsg();//Checking the validation message
		
		int errorArryCnt2 = ret_Arr.length;
		
		for(int c=0;c<errorArryCnt2; c++) {
		extentTest.log(Status.INFO, "Validation messages Displayed :  "+ret_Arr[c]);
		}

		String email = null;
		String firstname = null;
		String lastname = null;
		String password = null;

				email = BTExcel.getCellData(INPUTXL_PATH2, "Invalid_SignUp _Data",1, 0);
				firstname = BTExcel.getCellData(INPUTXL_PATH2, "Invalid_SignUp _Data",1, 1);
				lastname = BTExcel.getCellData(INPUTXL_PATH2, "Invalid_SignUp _Data",1, 2);
				password = BTExcel.getCellData(INPUTXL_PATH2, "Invalid_SignUp _Data",1, 3);
				
	//Entering email, firstname, lastname, and password
		
				signuppage3.enterEmail(email);	
				signuppage3.enterFirstName(firstname);
				signuppage3.enterLastName(lastname);
				signuppage3.enterPassword(password);
				
    //Clicking Terms and condition checkbox
		
				signuppage3.clickTandC();
				Thread.sleep(2000);
				
	//Clicking Sign Up button
				signuppage3.clickSingUpBtn();
		
				Thread.sleep(2000);
		
				String[] ret_Arr2 =signuppage3.validateErrorMsg();
		
				int errorArryCnt1 = ret_Arr2.length;
				
				extentTest.log(Status.INFO, "SCENARO 2: When user does a numeric entry to all fields while sign-up process............");
		
				if(errorArryCnt1>0) {
		
					for(int d=0;d<errorArryCnt1; d++) {
							extentTest.log(Status.INFO, "Validation messages Displayed:  "+ret_Arr2[d]);
					}
				}
				else
				{
					extentTest.log(Status.FAIL, "The Error message is not displaying properly");
				}
	
	}
}