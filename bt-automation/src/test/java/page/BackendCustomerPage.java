package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
* @author Jisha Jayaram
*
*/
public class BackendCustomerPage {
	
	@FindBy(xpath ="//html/body/div/div[2]/div[1]/div[1]/div[1]/ul/li[4]/a/span")
	private WebElement custLink;
	
	@FindBy (xpath = "//tr[@class='child']//li//button[contains(text(),'Actions')]")
	private WebElement ActionsBtn;
	
	@FindBy (xpath = "//div[@class ='dropdown-menu show']/a[contains(text(),'Delete')]")
	private WebElement DeleteBtn;
	
	@FindBy (xpath = "//div[@class ='dropdown-menu show']/a[contains(text(),'Edit User')]")
	private WebElement EditBtn;
	
	@FindBy (xpath = "//button[text()='Yes, delete it!']")
	private WebElement DeleteconfirmBtn;
	
	@FindBy (xpath ="//*[@id=\"admin-user-tbl\"]/tbody/tr/td[text()='Jis']")
	private WebElement ExpandAction;
	
	public BackendCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickCustomer() {
		custLink.click();
		}

	public WebElement getDeleteconfirmBtn() {
		return DeleteconfirmBtn;
	}

	public void setDeleteconfirmBtn(WebElement deleteconfirmBtn) {
		DeleteconfirmBtn = deleteconfirmBtn;
	}
	
	public WebElement getCustLink() {
		return custLink;
	}

	public WebElement getActionsBtn() {
		return ActionsBtn;
	}

	public WebElement getExpandAction() {
		return ExpandAction;
	}
	
	public void ClickExpandActionElement() {
		ExpandAction.click();
	}

	public void DeleteConfirmBtnClick() {
		DeleteconfirmBtn.click();
	}

	public WebElement getActions() {
		return ActionsBtn;
	}

	public void setActions(WebElement actions) {
		ActionsBtn = actions;
	}
	
	public void ActionBtnClick() {
		ActionsBtn.click();
	}

	public WebElement getDeleteBtn() {
		return DeleteBtn;
	}

	public void setDeleteBtn(WebElement deleteBtn) {
		DeleteBtn = deleteBtn;
	}
	
	public void DeleteBtnClick() {
		DeleteBtn.click();
	}

	public WebElement getEditBtn() {
		return EditBtn;
	}

	public void setEditBtn(WebElement editBtn) {
		EditBtn = editBtn;
	}

	public void EditBtnClick()
	{
		EditBtn.click();
	}
}
