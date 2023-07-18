package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
* @author Jisha Jayaram
*
*/
public class BackendLoginPage {
	
	@FindBy(how = How.ID, using = "username")
	private WebElement username;
	
	@FindBy(how = How.ID, using = "userpassword")
	private WebElement passcode;
	
	@FindBy(xpath="//*[@id=\"login-form\"]//button")
	private WebElement backLoginBtn;
	
	public BackendLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterBackendEmail(String em) {
		username.clear();
		username.sendKeys(em);
		}
	
	public void enterBackendPw(String pw) {
		passcode.clear();
		passcode.sendKeys(pw);
		}

	public void loginBtnClick() {
		backLoginBtn.click();
	}

}
