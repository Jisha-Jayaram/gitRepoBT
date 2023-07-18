package page;

 

import java.util.Iterator;
import java.util.List;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

 

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

 

public class AddYourShippingDetailsPage {
    @FindBy(xpath = "//div[@class='shippingModal_deliveryMethod__ZjzN8']") private List<WebElement> deliveryOptions;
    @FindBy(xpath = "//div[@class='shippingModal_deliveryMethod__ZjzN8']//h6[text()='Express Delivery']") private WebElement expressDelivery;
    @FindBy(xpath = "//div[@class='shippingModal_deliveryMethod__ZjzN8']//h6[text()='Standard Delivery - Retailer Managed']") private WebElement standardShipping;
    @FindBy(xpath = "//div[@class='datepicker_datepicker___8q5i']")private WebElement dobtextFld;
    @FindBy(xpath = "//select[@style='margin-left: 5px;']")private WebElement yearDrpDwn;
    @FindBy(xpath = "//div[@class='datepicker_calendar__day__x2XkB']") private WebElement firstDateFromCalender;
    @FindBy(xpath = "//input[@id='flexCheckDefault']") private WebElement dobCheckBox;
    @FindBy(xpath = "//button[@class='shippingModal_btnCustom__Spz4S']") private WebElement confirmShipping;




    public AddYourShippingDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    } 

    public void DeliveryOptions() {
for (WebElement options : deliveryOptions) {
    String deliveryOpt = options.getText();
    if (deliveryOpt.contains("Express Delivery")) {
        expressDelivery.click();

        break;

    }
    else if (deliveryOpt.contains("Standard Delivery - Retailer Managed")) {
        standardShipping.click();
        break;
    } 


}
    }

    public WebElement getDobtextFld() {
        return dobtextFld;
    }

    public void DobTextFld() {
        dobtextFld.click();
    }

    public void SelectYearDrpDwn() throws InterruptedException {
        Select sel = new Select(yearDrpDwn);
        sel.selectByValue("1995");
        Thread.sleep(2000);
        firstDateFromCalender.click();
    }

    public void DobCheckBox() {
        boolean isSelected = dobCheckBox.isSelected();
        //performing Click operation if element is not selected
        if (isSelected==false) {
            dobCheckBox.click();
        }
    }

    public void ConfirmShipping() {
        confirmShipping.click();
    }







}