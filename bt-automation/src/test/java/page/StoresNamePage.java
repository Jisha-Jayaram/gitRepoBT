package page;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

 

public class StoresNamePage {
    @FindBy(xpath = "//input[@placeholder='Search Stores']") private WebElement SearchTextField;
    @FindBy(xpath = "//div[@class='StoreList_postcodeSearch__hzPdk']//input[@class='form-control']") private WebElement PostCodeSearchTextField;
    @FindBy(xpath = "//a[text()='J']")private WebElement JLtrBtn;
    @FindBy(xpath = "//div[@class='Letter_desktopLetterSection__TE3aJ']//a[text()='B']") private WebElement BLtrBtn;
    //@FindBy(xpath = "//div[@class='col-md-12'] /following-sibling::div[@class='col-md-4 StoreList_text__d7rcY']") private WebElement RetaileStr;
    @FindBy(xpath = "//div[@class='row StoreList_itemPosition__Zn6kN']/div[contains(@class,'StoreList_text')]/span") private WebElement RetaileStr;

    public StoresNamePage(WebDriver driver) {
        PageFactory.initElements(driver, this);    
    }

    public WebElement getRetaileStr() {
        return RetaileStr;
    }

 

    public WebElement getPostCodeSearchTextField() {
        return PostCodeSearchTextField;
    }

    public WebElement getSearchTextField() {
        return SearchTextField;
    }
    public WebElement getJLtrBtn() {
        return JLtrBtn;
    }
    public WebElement getBLtrBtn() {
        return BLtrBtn;
    }
    public void RetaileStr() {
        RetaileStr.click();
    }
    public void StoreName() {
        //SearchTextField.click();
       SearchTextField.sendKeys("jstore");
    }
    public void JLtrBtn() {
        JLtrBtn.click();
    }
}