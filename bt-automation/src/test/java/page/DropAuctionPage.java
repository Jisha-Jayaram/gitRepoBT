package page;

import javax.xml.xpath.XPath;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

 

public class DropAuctionPage {
    @FindBy(xpath = "//div[@class='dropAuctionLive_globalHeading__qPEDQ']") private WebElement upComingAuctionText;
    @FindBy(xpath = "//div[@class='dropAuctionLive_image__UdeGp']")private WebElement productImage;

    public DropAuctionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

 

 


    public WebElement getUpComingAuctionText() {
        return upComingAuctionText;
    }

 

    
    public void ScrollUntilTheElement(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", upComingAuctionText);
        //js.executeScript("window.scrollTo(0,-100)", "");
    }

    public void ProductImage() {
        productImage.click();
    }
}