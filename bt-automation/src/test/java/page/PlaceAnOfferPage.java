package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceAnOfferPage {


    @FindBy(xpath = "//div[@class='instantBid_header__3iuVi']//h4") private WebElement offerpageText;
    @FindBy(xpath = "//input[@placeholder='Enter price']")private WebElement enterPriceTextFld;
    @FindBy(xpath = "//button[@class='instantBid_btnCustom__t00k6']")private WebElement placeOfferBtn;
    @FindBy(xpath ="//h4[@class='modal-title']" ) private WebElement droppedMsgText;
    @FindBy(xpath = "//div[@class='instantBid_header__3iuVi']/p") private WebElement failedMsgtext;

    public PlaceAnOfferPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void VerifyPage() {
        String text = offerpageText.getText();
        if (text.contains("Try to Buy Now")) {
            System.out.println("The user is in the Place An Offer Page below the Actual Price of the product");

        }
        else {
            System.out.println("The user is not in the Place An Offer Page");
        }
    }

    public void EnterPriceTextField(String price) {
        enterPriceTextFld.click();
        enterPriceTextFld.sendKeys(price);
    }

    public void PlaceAnOfferbBtn() {
        placeOfferBtn.click();
    }


    public boolean FailedMsg() {
        String msg=droppedMsgText.getText();
        String text = failedMsgtext.getText();
    if (msg.contains("Better Luck Next Time") && text.contains("Your offer wasn't accepted")  ) {
        System.out.println("The User has to Buy the product before the Auction");
        return true;
    }
    else {
        System.out.println("The User has purchased the product");
        return false;
    }

    }
}

