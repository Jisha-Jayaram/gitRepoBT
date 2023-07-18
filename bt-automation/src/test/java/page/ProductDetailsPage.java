package page;

 

import java.util.List;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 

public class ProductDetailsPage {
@FindBy(xpath = "//div[@class='multi_buyNowBlock__FeHjx']/button/span") private WebElement addToBagBtn;
@FindBy(xpath = "//div[@class='accordion accordionCustom']//h2") private List<WebElement> listofOptions;
@FindBy(xpath = "//div[@class='modal-content']//h5")private WebElement addCardPopUp;
@FindBy(xpath = "//div[@class='form-group CardModal_formGroup__wcEF5']") private WebElement addCardBtn;
@FindBy(xpath = "//input[@class='InputElement is-empty Input Input--empty'and @placeholder='Card number']") private WebElement cardNoTextField;
@FindBy(xpath = "//input[@name='exp-date']") private WebElement expiredateField;
@FindBy(xpath = "//span[@class='CardField-cvc CardField-child']") private WebElement cvcField;
@FindBy(xpath = "//iframe[@title='Secure card payment input frame']")

    public WebElement cardPaymentFrameText;

    public ProductDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public String AddToBag() {
        String text = addToBagBtn.getText();
        System.out.println(text);
        return text;
    }
    
    public void CardNoTextField(String cardNumber,String expdate,String cvcno ) {

        //cardNoTextField.click();
        cardNoTextField.sendKeys(cardNumber);
        expiredateField.sendKeys(expdate);
        cvcField.sendKeys(cvcno);
    }

    public String Details() {
        for (WebElement options : listofOptions) {
            String value = options.getText();
            System.out.println(value);
            return value;
        }
        return null;
    }
    public WebElement getAddToBagBtn() {
        return addToBagBtn;
    }
    public List<WebElement> getListofOptions() {
        return listofOptions;
    }

    public WebElement getAddCardPopUp() {

        return addCardPopUp;

    }

    public void AddCardPopUp() {
        try {
            String headerName=addCardPopUp.getText();
            if (headerName.contains("Add payment method to make an offer")) {
                System.out.println("The user has not added the card for the Shipping");
            }
            else {
                System.out.println("The user has added the card for Shipping");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
public void AddCardBtn() {

        addCardBtn.click();

}

public void CardNoTextField(String cardNumber) {

        cardNoTextField.click();
        cardNoTextField.sendKeys(cardNumber);


}

 

public void ExpireDateTextField(String expdate) {

        expiredateField.sendKeys(expdate);


 

}
public void CVCField(String cvcno) {

        cvcField.sendKeys(cvcno);

}

 

}

