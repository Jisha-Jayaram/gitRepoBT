package page;

 

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

 

public class BackendRetailerDropAuctionPage {

    @FindBy(xpath = "//a[@class='btn btn-secondary buttons-csv buttons-html5']") private WebElement scheduleDropBtn;

@FindBy(xpath = "//button[@id='dropdownMenuButton']") private WebElement exportBtn; 

@FindBy(xpath = "//tr[@class='odd']//td[2]")private WebElement productName;



    public BackendRetailerDropAuctionPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

 



    public WebElement getScheduleDropBTn() {

        return scheduleDropBtn;

    }

 



    public WebElement getScheduleDropBtn() {

        return scheduleDropBtn;

    }

 



    public WebElement getProductName() {

        return productName;

    }

 



    public WebElement getExportBtn() {

        return exportBtn;

    }



    public void ScheduleDrop() {

        scheduleDropBtn.click();

    }


    public String ProducName() {

        String name=productName.getText();    

        System.out.println(name);

        return name;

        }

}
