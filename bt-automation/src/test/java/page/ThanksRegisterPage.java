package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThanksRegisterPage {
	
	@FindBy (xpath ="//*[@id=\"join-in\"]/div/div/button[@class='close']") private WebElement CloseBtn;
	
	public ThanksRegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void CloseBtnClick() {
		CloseBtn.click();
	}

}
