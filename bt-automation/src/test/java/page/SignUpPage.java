package page;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import generic.CommonBaseTest;

/**
* @author Jisha Jayaram
*
*/
public class SignUpPage {
	
	@FindBy(xpath="//span[@class='Header_userNameClass__nl8jn']") 
	private WebElement Singup_Join_Link;
	
	@FindBy(xpath="//span[text()='JOIN']")
	private WebElement Join_Link;
	
	@FindBy(xpath="//div[@class='RegisterLogin_joinPopRight__Tcr0T']/h2[text()='Sign up']")
	private WebElement Singup_Text;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement Email_Address;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement First_Name;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement Last_Name;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement Password;
	
	@FindBy(xpath="//label[@class='custom-check']/span[@class='checkmark']")
	private WebElement TandC_CB;
	
	@FindBy(xpath="//form//button[@class='RegisterLogin_btnCustom__Yndqo']")
	private WebElement SingMeUpBtn;
	
	@FindBy(xpath="//div/h2[contains(text(),'Thanks for registering!')]")
	private WebElement activationtxt;
	String emailtxt;
	
	@FindBy(xpath="//div[@class='modal-content RegisterLogin_removePadding__jhYc2 RegisterLogin_modalContent__72Mzt']/button")
	private WebElement CloseBtn;
	
	@FindBy(xpath="//form//div[@class='Message_textDanger___OSCV ']")
	private WebElement Errorlist;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//form//div[@class='Message_textDanger___OSCV ']"))
    private List<WebElement> elements;
	
	@FindBy(xpath = "//div[@class='Message_textDanger___OSCV ']") 
	private WebElement TCMsg;
	
	@FindBy(xpath = "//div[@class='Message_textDanger___OSCV ']") 
	private  WebElement EmailTextFieldMsg;
	
	@FindBy(xpath = "//span[@class='RegisterLogin_loginHref__OXevz link_type_4']") 
	private WebElement LoginBtn;
	
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String[] validagteBlankErrorMsg() {
		//System.out.println("First error list size: "+elements.size());
		String blanktxterr =null;
		String[] strAr = new String[4];
		for(int j=0;j<elements.size();j++)
		{
			blanktxterr = elements.get(j).getText();
			strAr[j]=blanktxterr;
		//	System.out.println("list of error messages: "+blanktxterr);
		}
		
		if(strAr[0].equals("Email field is required") && (strAr[1]).equals("First name field is required"))
		{
			
			System.out.println("All Validation messages are displaying as expected.");
	    	
	    }
		else
		{
			System.out.println("The validation is not displaying properly");
			Arrays.fill(strAr, null);
		}
		return strAr;
	}
	
	public String[] validateErrorMsg()
	{
		String errortxt = null;
		String[] strAr3= new String[3];
		for(int i=0;i<elements.size();i++) {
			
			errortxt = elements.get(i).getText();
			strAr3[i] = errortxt;
		  //  System.out.println("list of error messages: "+i+"="+errortxt);
		    
		}
		
		if(strAr3[0].equals("Email address must be a valid email") && (strAr3[1]).equals("First name field may only contain alphabetic characters"))
		{
			
			System.out.println("All Validation messages are displaying as expected.");
	    	
	    }
		else
		{
			System.out.println("The validation is not displaying properly");
			Arrays.fill(strAr3, null);
		}
		return strAr3;
	}
	
	public void validateClose() {
		
		CloseBtn.click();
	}
	
    public void LoginBtn() {
        LoginBtn.click();

    }
	
	public WebElement getTCMsg() {
        return TCMsg;
    }
	
	public void signupJoinMouseOver() {
		Singup_Join_Link.click();
//		Actions action = new Actions(driver);
//		action.moveToElement(Singup_Join_Link).perform();
//		action.click().perform();
	}
	
	public void joinClick() {
		Join_Link.click();
//		Actions action = new Actions(driver);
//		action.moveToElement(Join_Link).click();
//		action.click();
	}
	
	public boolean verifySignUpPopUpDisplay() {
		String Singuptxt;
		try
		{
			Singuptxt = Singup_Text.getText();
			return true;
		}
		catch (Exception e) 
		{
			System.err.println("Sign-UP Pop up not opened");
			return false;
		}
	}
	
	public void enterEmail(String email) {
		Email_Address.sendKeys(email);
	}
	
	public void enterFirstName(String firstname) {
		First_Name.sendKeys(firstname);
	}
	
	public WebElement getEmailTextFieldMsg() {
        return EmailTextFieldMsg;
    }
    public void enterLastName(String lastname) {
    	Last_Name.sendKeys(lastname);
    }
    public void enterPassword(String password) {
    	Password.sendKeys(password);
    }
    public void clickTandC() {
    	TandC_CB.click();
    }
    public void clickSingUpBtn() {
    	SingMeUpBtn.click();
    	//System.out.println("Button clicked: "+SingMeUpBtn.getText());
    }
    public boolean verifyActivationEmail() {
    	try {
    		emailtxt = activationtxt.getText();
     		if(emailtxt.equals("Thanks for registering! Please check your email and click on the activation link.")) {
    			//System.out.println("Passed");
    			return true;
    		}
    		else {
 
    			return false;
    		}
    	}
    	catch(Exception e) {

    		return false;
    	}
    }
}
