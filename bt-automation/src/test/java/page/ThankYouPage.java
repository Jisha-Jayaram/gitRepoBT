package page;

 

import static org.testng.Assert.assertEquals;

 

import org.bouncycastle.jce.exception.ExtCertificateEncodingException;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

 

import com.aventstack.extentreports.ExtentTest;

 

public class ThankYouPage {

    JavascriptExecutor driver;

    @FindBy(xpath = "//div[@class='thankyou_productName__8wWbO']") private WebElement productName;

    @FindBy(xpath = "//div[@class='thankyou_itemPriceBox__Oy2Lf']//strong") private WebElement ItemPrice;

    @FindBy(xpath = "//p//b[1]") private WebElement GCAmt;

    @FindBy(xpath = "//div[@class='thankyou_confirmationContainer__q5_zU']")  private WebElement ThankPage;

 

    public ThankYouPage(WebDriver driver) {

        PageFactory.initElements(driver, this);    

    }

 

    public WebElement getProductName() {

        return productName;

    }

 

    public WebElement getItemPrice() {

        return ItemPrice;

    }

 

    public WebElement getGCAmt() {

        return GCAmt;

    }

 

    public WebElement getThankPage() {

        return ThankPage;

    }

 

    public String ProductName() {

        String pName = productName.getText();

        System.out.println(pName);

        return pName;

    }

 

    public String ProductPrice() {

        String pPrice = ItemPrice.getText();

        System.out.println(pPrice);

        return pPrice;

    }

 

    public String GCAmount() {

        String gcAmount = GCAmt.getText().replace("AUD", "");

        //gcAmount.replace("AUD", "");

        System.out.println(gcAmount);

        return gcAmount;

    }

 

    public boolean VerifyPage() {

        String page = ThankPage.getText();

        if (page.contains("Thanks for your purchase")) {

            System.out.println("The user has Successfully purchased the product");

            return true;

        }

        else {

            System.out.println("The user has Not purchased the product");

            return false;

        }

 

    }


    public void scrollUntilElementVisible() {


        JavascriptExecutor je = (JavascriptExecutor)driver;

        je.executeScript("arguments[0].scrollIntoView(true);",GCAmt);

    }

 

    

 

}
