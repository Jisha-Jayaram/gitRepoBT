package page;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

 

import generic.BTExcel;

import generic.CommonBaseTest;

import generic.WebDriverUtility;

 

public class EnterAsAGuestPage  extends CommonBaseTest{

 

    public WebDriver driver;

 

    @FindBy(xpath = "//input[@placeholder='Enter email address']")

    private WebElement emailTextField;

 

    @FindBy(xpath = "//input[@placeholder='First name']")

    private WebElement firstnameTextField;

 

    @FindBy(xpath = "//input[@placeholder='Last name']")

    private WebElement lastNameTextField;

 

    @FindBy(xpath = "//select[@name='country']")

    private WebElement countryDrpDwn;

 

    @FindBy(xpath = "//input[@placeholder='Type the suburb or postcode']") 

    private WebElement postCodeOrSuburbtextField;

 

    @FindBy(xpath = "//input[@name='name']") 

    private WebElement cardHolderNameField;

 

    @FindBy(xpath = "//iframe[@title='Secure card number input frame']")

    private WebElement cardNoiFrame;

 

    @FindBy(xpath = "//iframe[@title='Secure expiration date input frame']")

    private WebElement expireDateiFrame;

 

    @FindBy(xpath = "//iframe[@title='Secure CVC input frame']")

    private WebElement cvviFrame;

 

    @FindBy(xpath = "//input[@placeholder='Card Number']")

    private WebElement cardNoTextFld;

 

    @FindBy(xpath = "//input[@name='exp-date']")

    private WebElement expireDateTextField;

 

    @FindBy(xpath = "//input[@name='cvc']")

    private WebElement cvvTextField;

 

    @FindBy(xpath = "//input[@name='dob']")

    private WebElement dobTextField;

 

    @FindBy(xpath = "//div[@class='row p-3']//input[@type='checkbox']")

    private WebElement dobCheckBox;

 

    @FindBy(xpath = "//form/div[3][@class='checkout_guestBtn__FwwdL']/button")
    private WebElement enterAsGuestBtn;

 

    @FindBy(xpath = "//label[contains(text(),'Change of mind')]//span[@class='checkmark']")

    private WebElement changeOfMindCheckBox;

 

    @FindBy(xpath = "//label[contains(text(),'I agree with ')]//span[@class='checkmark']")

    private WebElement iAgreeWithCheckBox;

 

    @FindBy(xpath = "(//div[@class='AddressModal_customSelectOption__c7wS2']//li)[1]")

    private WebElement firstSubAddress;

 

    @FindBy(xpath = "//select[@style='margin-left: 5px;']")

    private WebElement yearDrpDwn;


    @FindBy(xpath = "//div[@class='datepicker_calendar__day__x2XkB']")

    private WebElement firstDateFromCalender;


    @FindBy(xpath = "//div[@class='checkout_deliveryOption__BBwkU'] //span[@class='checkout_radioHd__fXp1h']")

    private List<WebElement> list;

 

    public EnterAsAGuestPage(WebDriver driver) {

        this.driver=driver;

        PageFactory.initElements(driver, this);

    }

 

    WebDriverUtility webDriverUtility = new WebDriverUtility();

 

    public void SelectTheCountry() throws InterruptedException {

    //    webDriverUtility.scrollBarAction(driver);

        webDriverUtility.selectDropDown(countryDrpDwn, 1);

 

        postCodeOrSuburbtextField.clear();

 

        //String addressfield = BTExcel.getCellData(INPUTXL_PATH,"BTSignUp",5,4);

 

        String addressfield ="albert";

        postCodeOrSuburbtextField.sendKeys(addressfield);

        Thread.sleep(1000);

        webDriverUtility.scrollAndClickElement(driver, firstSubAddress);

        //firstSubAddress.click();

        Thread.sleep(2000);

        System.out.println(list.size());

        if (list.size()!=0) {

            System.out.println("The Delivery Options Are Present");    

        }

        else {

            System.out.println("The Delivery Options Are Not Present");

        }

 

        for (WebElement Name : list) {

            String DeliveryNames = Name.getText();

            System.out.println(DeliveryNames);

            if (DeliveryNames.contains("Standard Delivery")) {

                driver.findElement(By.xpath("//div[@class='checkout_deliveryOption__BBwkU'] //span[@class='checkout_radioHd__fXp1h' and text()='Standard Delivery - Retailer Managed']")).click();

                Thread.sleep(5000);

                break;

            }

            else if (DeliveryNames.contains("Express")) {

                driver.findElement(By.xpath("//div[@class='checkout_deliveryOption__BBwkU'] //span[@class='checkout_radioHd__fXp1h' and text()='Express Delivery']")).click();

                Thread.sleep(5000);

                break;

            }    

        }

    }

 

    public void GuestUserName() throws InterruptedException {

        //String mailId = BTExcel.getCellData(INPUTXL_PATH, "BTSignUp",3,0);

        //String firstName = BTExcel.getCellData(INPUTXL_PATH, "BTSignUp",3,1);

        //String lastName = BTExcel.getCellData(INPUTXL_PATH, "BTSignUp",3,2);

 

        String mailId="sreeja@yopmail.com";

        String firstName="sreeja";

        String lastName ="spring";


        emailTextField.click();;

        emailTextField.clear();

        Thread.sleep(1000);

        emailTextField.sendKeys(mailId);

        firstnameTextField.clear();

        Thread.sleep(1000);

        firstnameTextField.sendKeys(firstName);

        lastNameTextField.clear();

        Thread.sleep(1000);

        lastNameTextField.sendKeys(lastName);

    }

 



    public void CardDetails() {

        //webDriverUtility.scrollBarAction(driver);

        cardHolderNameField.clear();

        /*

        String nameInCard = BTExcel.getCellData(INPUTXL_PATH, "CardDetails",1,0);

        String cardNumber = BTExcel.getCellData(INPUTXL_PATH, "CardDetails",1,1);

        String expireDate = BTExcel.getCellData(INPUTXL_PATH, "CardDetails",1,2);

        String cvvNo = BTExcel.getCellData(INPUTXL_PATH, "CardDetails",1,3);

         */

 

        String nameInCard ="spring";

        String cardNumber ="4242 4242 4242 4242";

        String expireDate ="12/43";

        String cvvNo ="123";

 

        cardHolderNameField.sendKeys(nameInCard);


        webDriverUtility.switchtoFrame(driver, cardNoiFrame);

        cardNoTextFld.sendKeys(cardNumber);

        webDriverUtility.switchBackToMainPage(driver);


        webDriverUtility.switchtoFrame(driver, expireDateiFrame);

        expireDateTextField.clear();

        expireDateTextField.sendKeys(expireDate);

        webDriverUtility.switchBackToMainPage(driver);


        webDriverUtility.switchtoFrame(driver, cvviFrame);

        cvvTextField.clear();

        cvvTextField.sendKeys(cvvNo);

        webDriverUtility.switchBackToMainPage(driver);

 

    }

 



    public void Datefield() throws Throwable {

        webDriverUtility.scrollAndClickElement(driver, dobTextField);

        //dobTextField.click();

            Select sel = new Select(yearDrpDwn);

            sel.selectByValue("1995");

            Thread.sleep(2000);

            firstDateFromCalender.click();

            Thread.sleep(2000);

            DobCheckBox();

            Thread.sleep(1000);

            changeOfMindCheckBox.click();

            iAgreeWithCheckBox.click();

            Thread.sleep(2000);

    }



    public void DobCheckBox() {

        boolean isSelected = dobCheckBox.isSelected();

        //performing Click operation if element is not selected

        if (isSelected==false) {

            dobCheckBox.click();

        }

    }

    public void EnterGuestBtn() {

        //wait.until(ExpectedConditions.elementToBeClickable(cardHolderNameField)).click();

        enterAsGuestBtn.click();

    }
 
}
