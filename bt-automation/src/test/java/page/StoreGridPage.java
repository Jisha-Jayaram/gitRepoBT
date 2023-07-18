package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
* @author Jisha Jayaram
*
*/
//testing git hub 
public class StoreGridPage {
	
	@FindBy(xpath="//div[@class='container']//a[text()='All Stores']") 
	private WebElement AllstoreElement;
	
	@FindBy(xpath ="//div[@class='container']/ul/li[3]/span")
	private WebElement retailername;
	
	public StoreGridPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}

	public String getAllstoreElement() {
		String Allstoretxt = AllstoreElement.getText();
		return Allstoretxt;
	}
		
	public String getRetailerName() {
		String retailernametxt = retailername.getText();
		return retailernametxt;
	}

}
