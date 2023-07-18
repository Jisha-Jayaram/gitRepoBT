package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ScheduleDropAuctionPage {
    @FindBy(xpath = "//input[@id='action_date']")private WebElement dropAuctionDateField;
    @FindBy(xpath = "//span[@id='select2-action_hour-container']")private WebElement dropAuction24hrsFormatField;
    @FindBy(xpath = "//span[@id='select2-action_slot-container']")private WebElement dropAuctionAvailableSlotField;
    @FindBy(xpath = "//button[@id='schedule_auction_btn']")private WebElement scheduleActionBtn;
    @FindBy(xpath = "//a[@class='btn options-btn mb-2 close-icon']") private WebElement closeBtn;
    @FindBy(xpath = "(//div[@class='datepicker-days']//td[@class='day'])[1]") private WebElement dateSelected;
    @FindBy(xpath = "//label[contains(text(),'Featured Drop Auction')]") private WebElement featuredDropAuctionBtn;
    @FindBy(xpath = "//input[@class='select2-search__field']") private WebElement dropAuction24hrsFormatTextField;
    @FindBy(xpath = "//input[@class='select2-search__field']") private WebElement dropAuctionAvailableSlotTextField;
    @FindBy(xpath = "//button[text()='Yes']")private WebElement yesBtnAfterScheduling;
    @FindBy(xpath = "//button[text()='No']")private WebElement noBtnAfterScheduling;
    @FindBy(xpath = "//div[@class='jq-toast-single jq-has-icon jq-icon-success']//h2")private WebElement popMessage;
    @FindBy(xpath = "//tbody[@id='auctionInventory']//td[5]//input[@type='number']")private List<WebElement> buyBeforeField;
    @FindBy(xpath = "//tbody[@id='auctionInventory']/tr/td[3]//input")private List<WebElement> startingPriceField;
    @FindBy(xpath = "//input[@id='rp_status']")private WebElement btProductStatusTextField;
    @FindBy(xpath = "//button[text()='Yes']") private WebElement yesButtonOnPopUp;
    @FindBy(xpath = "//button[text()='No']") private WebElement noButtonOnPopUp;
 

    public ScheduleDropAuctionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void YesButtonOnPopUp() {
        yesButtonOnPopUp.click();
    }
    
    

    public WebElement getDropAuctionDateField() {
        return dropAuctionDateField;
    }
    public WebElement getCloseBtn() {
        return closeBtn;
    }

 
    public WebElement getBtProductStatusTextField() {
        return btProductStatusTextField;
    }

    public WebElement getDropAuctionAvailableSlotTextField() {
        return dropAuctionAvailableSlotTextField;
    }

 

    public WebElement getDateSelected() {
        return dateSelected;
    }

 

    public WebElement getFeaturedDropAuctionBtn() {
        return featuredDropAuctionBtn;
    }

 

    public WebElement getDropAuction24hrsFormatTextField() {
        return dropAuction24hrsFormatTextField;
    }

 

    public WebElement getDropAuction24hrsFormatField() {
        return dropAuction24hrsFormatField;
    }

 

    public WebElement getDropAuctionAvailableSlotField() {
        return dropAuctionAvailableSlotField;
    }

 

    public WebElement getScheduleActionBtn() {
        return scheduleActionBtn;
    }

 

    public void CloseBtn() {
        closeBtn.click();
    }
    public void DropAuctionDate() {
        dropAuctionDateField.click();
    }
    public void DateSelected () {
        dateSelected.click();
    }
    public void FeaturedDropAuction() {
        featuredDropAuctionBtn.click();
    }
    public void DropAuction24HrsFormat() {
        dropAuction24hrsFormatField.click();
    }
    public void ScheduleAuctionBtn() {
        scheduleActionBtn.click();
    }
    public void ClickOnYesAfterSchedule() {
        yesBtnAfterScheduling.click();
    }
    public String PopUpMessage() {
        String text = popMessage.getText();
        System.out.println(text);
        return text;
    }
/*
    public void StartingPriceField() {
        String price = startingPriceField.getAttribute("value");
        System.out.println(price);
    }
    */

    public void BuyBeforePrice() throws Throwable {
        for (WebElement StaritngPrice : startingPriceField) {
            System.out.println(StaritngPrice.getAttribute("value"));



        for (WebElement productsPrice : buyBeforeField) {
        String actprice = productsPrice.getAttribute("value");
        System.out.println(actprice);
        System.out.println("--------------------------");
        break;

        /*
        double dbt = Double.parseDouble(actprice);
        int sct=(int)dbt;
        int bba = (int) (sct-(sct*.21));
        String pass = Integer.toString(bba);
        System.out.println(bba);

        productsPrice.click();
        productsPrice.sendKeys(pass);

            */
            //break;

        }

        }
        //String beforePrice = buyBeforeField.getAttribute("value");
        //System.out.println(beforePrice);
        //buyBeforeField.clear();
        //buyBeforeField.sendKeys("100");
    //    String added = buyBeforeField.getAttribute("value");
        //System.out.println(added);
    }


}