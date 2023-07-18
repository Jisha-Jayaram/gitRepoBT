package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	@FindBy (xpath ="//span[contains(text(),'In-Active')]") private WebElement Statusdropdown;
	@FindBy (xpath ="//div[@class='col-sm-10']/input[@id='phoneNumber']") private WebElement Phnotxtfld;
	@FindBy (xpath ="//div[@class='form-group row']//span[text()='Select']") private WebElement GCdropdown;
	@FindBy (id = "savedata") private WebElement SaveBtn;
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public void setSaveBtn(WebElement saveBtn) {
		SaveBtn = saveBtn;
	}
	
	public void SaveBtnClick() {
		SaveBtn.click();
	}

	public EditCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getStatusdropdown() {
		return Statusdropdown;
	}

	public void setStatusdropdown(WebElement statusdropdown) {
		Statusdropdown = statusdropdown;
	}
	
	public void StatusdropdownClick() {
		Statusdropdown.click();
	}

	public WebElement getPhnotxtfld() {
		return Phnotxtfld;
	}

	public void setPhnotxtfld(String phno) {
		Phnotxtfld.clear();
		Phnotxtfld.sendKeys(phno);
		//Phnotxtfld = phnotxtfld;
	}

	public WebElement getGCdropdown() {
		return GCdropdown;
	}

	public void setGCdropdown(WebElement gCdropdown) {
		GCdropdown = gCdropdown;
	}
	
	public void GCdropdownClick() {
		
		GCdropdown.click();
	}

}
