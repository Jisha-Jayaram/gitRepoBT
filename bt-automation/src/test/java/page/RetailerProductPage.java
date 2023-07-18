package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RetailerProductPage {
	
	 @FindBy(id = "select2-retailer_id-container") private WebElement RetailerDropdown;
	    //@FindBy(how = How.ID, using = "foobar") WebElement foobar;
	 
	 @FindAll(@FindBy(how = How.CLASS_NAME, using = "select2-results__option"))
	    private List<WebElement> elements;
	 
	 @FindAll(@FindBy(xpath = "//tbody[@id='data']/tr[@role='row']//button[@id='dropdownMenuButton']"))	 //action button 
		private List<WebElement> allActions; // all Actions button from table column
	 
	 public RetailerProductPage(WebDriver driver) {

	        PageFactory.initElements(driver, this);
	    }
	 
	 public void RetailerDropDownClick() {
		 
		 RetailerDropdown.click();	 
	 }
	 
	 public List<WebElement> ListRetailerDispaly()
	 {

		 System.out.println("Total number of retailers" + elements.size());
		 
		 return elements;
		 
	 }
	 
	 public List<WebElement> allActionsBtns()
	 {
		 System.out.println("count of actions" + allActions.size());
		 return allActions;
	 }

}
