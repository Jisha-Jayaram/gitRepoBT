package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
* @author Jisha Jayaram
*
*/

public class StoreListPage {
	
	@FindBy(xpath="//div[@class='col-md-4 StoreList_text__d7rcY']/span") 
	private WebElement retailerone;
	
	public StoreListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}

	public void clickRetailerone() {
		retailerone.click();
	}
	

}
