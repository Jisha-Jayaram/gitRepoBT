package page;

 

import java.time.Duration;

 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 

import generic.CommonBaseTest;

 

public class DropAuctionRoomPage   {

    
    @FindBy(xpath = "//span[contains(@class,'dropAuctionProduct_bidBtnSm')]") private WebElement buyNowBtn;
@FindBy(xpath = "(//div[@class='dropAuctionProduct_bidAuctionTitle__X_R2u'])[1]") private WebElement productName;
    //Initilization
        public DropAuctionRoomPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        public void BuyNowBtn() {
            buyNowBtn.click();
        }

 

        public WebElement getBuyNowBtn() {
            return buyNowBtn;
        }

    public String ProductName() {
        String name=productName.getText();
        System.out.println(name);
        return name;
    }



    /*
    public void WaitAndClick() {

         // Define the minimum and maximum timeout values in seconds
      //  int minTimeoutSeconds = 30;
        int maxTimeoutSeconds = 120;
        // Create WebDriverWait instance with a dynamic timeout
      //  WebDriverWait wait = new WebDriverWait(driver, minTimeoutSeconds);

 

        // WebElement to store the found element
        WebElement element = null;

 

        // Set the start time
        long startTime = System.currentTimeMillis();
     // Loop until the element is found or the timeout is reached
        while (element == null && (System.currentTimeMillis() - startTime) < maxTimeoutSeconds * 1000) {
            try {
                // Check if the element is visible
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//span[contains(@class,'dropAuctionProduct_bidBtnSm')]")));
            } catch (Exception e) {
                // Element not found yet, wait for a second and try again
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

 

        // If the element is found, click on it
        if (element != null) {
            element.click();
        } else {
            System.out.println("Element not found within the specified timeout.");
        }
    }

    */

}