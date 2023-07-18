package page;

 

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.IFactoryAnnotation;

 

public class CongratulaionsPage {

    @FindBy(xpath = "//div[@class='congratulation_user__tjqAV']//h1")private WebElement  pageText;

    @FindBy(xpath = "//div[@class='congratulation_bidSecLt__8oS5e']/p/strong") private WebElement productName;



    public CongratulaionsPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

 

    

    public void CongratesText() {

        String text = pageText.getText();


        if (text.contains("Congratulations!")  ) {

            System.out.println("The User has Purchased the product before the Drop by placing a Bid");

        }

        else {

            System.out.println("The User has not placed an Order before the Drop");

        }

    }

 



    public WebElement getPageText() {

        return pageText;

    }

 



    public WebElement getProductName() {

        return productName;

    }


}
