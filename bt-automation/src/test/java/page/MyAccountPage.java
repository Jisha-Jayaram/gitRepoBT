package page;

 

import javax.xml.xpath.XPath;

 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 

public class MyAccountPage {
    @FindBy(xpath = "//div[@class='myaccount_accountOptionBlock__syTI0']/a[@href='/my-addresses']") private WebElement MyAddress;
    @FindBy(xpath = "//div[@class='myaccount_accountOptionBlock__syTI0']/a[@href='/my-info']") private WebElement MyInfo;
    @FindBy(xpath = "//div[@class='myaccount_accountOptionBlock__syTI0']/a[@href='/my-orders']") private WebElement MyOrders;
    @FindBy(xpath = "//div[@class='myaccount_accountOptionBlock__syTI0']/a[@href='/payment-options']") private WebElement MyPaymentOptions;
    @FindBy(xpath = "//div[@class='myaccount_accountOptionBlock__syTI0']/a[@href='/my-good-cause']") private WebElement MyGoodCause;
    @FindBy(xpath="//ul[@class='breadcums padding-top d-flex align-items-center justify-content-center']") private WebElement BreadCum;
    @FindBy(xpath = "//div[@class='Message_cupponMessage__DRXZ6 Message_warningOvercast__0KqwI ']") private WebElement addressText;

 

    public WebElement getAddressText() {
        return addressText;
    }

 


    public WebElement getBreadCum() {
        return BreadCum;
    }

 


    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

 


    public WebElement getMyAddress() {
        return MyAddress;
    }

 


    public WebElement getMyInfo() {
        return MyInfo;
    }

 


    public WebElement getMyOrders() {
        return MyOrders;
    }

 


    public WebElement getMyPaymentOptions() {
        return MyPaymentOptions;
    }

 


    public WebElement getMyGoodCause() {
        return MyGoodCause;
    }

 

    public void MyAddress() {
        MyAddress.click();
    }
    public void BreadCum() {
        String values = BreadCum.getText();
        if (values.contains("My Addresses")) {
            System.out.println("The New Customer is in MyAddress MyAccout page");
        }
        else {
            System.out.println("The New Customer is not in MyAddress MyAccout page");
        }

 

    }

 


}