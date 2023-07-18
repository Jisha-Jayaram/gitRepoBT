package page;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
* @author Jisha Jayaram
*
*/
public class SignInPage {
	
	@FindBy(xpath="//span[@class='Header_userNameClass__nl8jn']") 
	private WebElement SingIn_Join_Link;
	
	@FindBy(xpath="//span[text()='SIGN IN']")
	private WebElement SingIn_Link;
	
	@FindBy(xpath="//*[@id=\"sign-in\"]//input[@name=\"email\"]") 
	private WebElement SignInEmail;
	
	@FindBy(xpath="//*[@id=\"sign-in\"]//input[@name=\"password\"]")
	private WebElement SignInPwd;
	
	@FindBy(xpath="//*[@id=\"sign-in\"]//button[@class='RegisterLogin_btnCustom__Yndqo overcastBtn']")
	private WebElement LogInBtn;
	
	@FindBy(xpath="//div[@class='Message_textDanger___OSCV ']")
	private WebElement emailvalidationtxt;
	
	@FindBy(xpath="//div[@class='Message_cupponMessage__DRXZ6 Message_error__cs_Zw ']")
	private WebElement pwdvalidationtxt;	
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class = 'Message_textDanger___OSCV ']"))
    private List<WebElement> signinerrortxtlist;
	
	
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void signinJoinMouseOver() {
		SingIn_Join_Link.click();
	}
	
	public void singInClick() {
		SingIn_Link.click();
	}
	
	public void enterSingInEmail(String email2) {
		//SignInEmail.clear();
		SignInEmail.sendKeys(email2);
		}
	public void enterSingInPwd(String pwd2) {
		//SignInPwd.clear();
		SignInPwd.sendKeys(pwd2);
	}
	
	public void btnClick() {
		LogInBtn.click();
	}
	
	public String emailerrortxt;
	public boolean validateemailerror() {
		
		emailerrortxt = emailvalidationtxt.getText();

		if(emailerrortxt.equals("Enter email address in correct format, like name@example.com.")) {
			
			return true;
			
		}
		else
		{
			return false;
		}
		
	}
	    public String pwderrortxt;
        public boolean validatpwderror() {
		
		pwderrortxt = pwdvalidationtxt.getText();
		//System.out.println("Incorrect password text is : "+pwderrortxt);
		
		if(pwderrortxt.equals("Incorrect password")) {
			
			return true;
			
		}
		else
		{
			return false;
		}
		
	}
        public String emailerrortxt2;
        public String pwderrortxt2;
        public int errorlistsize;
        public boolean validateerrors() {
        	
        	String blanktxterr =null;
        	errorlistsize = signinerrortxtlist.size();
        	String[] Errortxts = new String[2];
        	for(int err=0;err<errorlistsize;err++)
    		{
    			blanktxterr = signinerrortxtlist.get(err).getText();
    			Errortxts[err]=blanktxterr;
    	
    		}
    			if(Errortxts[0].equals("Email is required.") && (Errortxts[1]).equals("Password is required."))
    			{
    				
    				System.out.println("Showing proper validation messages ................Success!!!!!!");
    		    	return true;
    		    }
    			else
    			{
    				System.out.println("The validation is not displaying properly");
    				Arrays.fill(Errortxts, null);
    				return false;
    			}
    			
        		}
    		
    	public boolean VerifySignInTxt() { 				
			
			String SignInttxt = SingIn_Join_Link.getText();
			if(SignInttxt.equals("SIGN IN / JOIN"))
			  {
			    return true;
		      }
			else
			{
				return false;
				
			}
    	}
		
	}
	
	

