package page;

 

import java.time.Duration;

import java.util.Iterator;

 

import javax.xml.xpath.XPath;

import java.util.List;

 

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.FindBys;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.model.Report;

 

import generic.CommonBaseTest;

import generic.WebDriverUtility;

import io.reactivex.rxjava3.functions.Action;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

 

public class CheckOutPage extends CommonBaseTest

{

 



//    public WebDriver driver = getDriver();

 

    public WebDriver driver;

    //Initilization


        public CheckOutPage(WebDriver driver) 

        {

            this.driver=driver;

            PageFactory.initElements(driver, this);    

        }


    WebDriverUtility webDriverUtility = new WebDriverUtility();


    @FindBy(xpath = "//div[@class='col-md-12 col-lg-6']//div[@class='checkout_deliveryOptions__Ph6YT']")

    private WebElement DeliveryOptions;


    @FindBy(xpath = "//span[@class='checkout_radioHd__fXp1h']") 

    private WebElement DeliveryMethods;


    @FindBy(xpath = "//input[@name='name']") 

    private WebElement NameTxtFldInCardDls;


    //@FindBy(By.xpath("//iframe[@name='__privateStripeFrame8496']")) private WebElement 1t


    @FindBy(xpath = "//span[text()='Standard Delivery - Retailer Managed']")

    private WebElement Option;


    @FindBy(xpath="//div[@class = 'checkout_bagsItemInfo__QjBWR']//span[@class='checkout_bagsItemTitle__edkbz']") 

    private WebElement checkoutProdName;


    @FindBy(xpath="//button[.='Login']")

    private WebElement LoginBtn;


    @FindBy(xpath="//div[@class='checkout_destinationHd__o_KXr']/h2")

    private WebElement DelveryOption;


    @FindBy(xpath="//div[@class = 'order_destinationHd__px6A8']/h2")

    private WebElement YourGC;


    @FindBy(xpath = "//div[@class='order_causeText__Lkxua']/span[text()='Change your Good Cause']")

    private WebElement ChangeGoodCauseBtn;


    @FindBy(xpath = "//div[@class='select__control css-1s2u09g-control']") 

    private WebElement GCDrpDwn;


    //@FindBy(xpath = "//div[@class='select__indicator select__dropdown-indicator css-tlfecz-indicatorContainer']") 

    //private WebElement GCDrpDwn;


    @FindBy(xpath = "//input[@name='cardnumber'and @placeholder='Card Number']") 

    private WebElement CardNoTextFld;


    @FindBy(xpath = "//input[@name='exp-date'and @placeholder='Exp MM/YY']") 

    private WebElement ExpDateTextFld;

 

    @FindBy(xpath = "//input[@name='cvc'and @placeholder='CVV']") 

    private WebElement CVVTextFld;


    @FindBy(xpath = "//iframe[@title='Secure card number input frame']") 

    private WebElement CardNoFrameText;


    @FindBy(xpath = "//iframe[@title='Secure expiration date input frame']")

    private WebElement ExpFrameText;

    @FindBy(xpath = "//button[text()='Enter as a guest']")
    private WebElement enterAsaGuestBtn;
    
    @FindBy(xpath ="//iframe[@title='Secure CVC input frame']") 

    private WebElement CVVFrameText;


    @FindBy(xpath = "//span[text()='Add Payment Method']/..") 

    private WebElement AddPaymentMethodBtn;


    @FindBy(xpath ="//button[@class='btnCustom checkout_placeOrder__tdU3o']") 

    private WebElement PlaceOrderBtn;


    @FindBy(xpath = "//button[text()='Continue as a guest']") 

    private WebElement ContinueAsaGuestButton;


    @FindBy(xpath = "//input[@class='form-control'and @placeholder='Please provide a shipping address']") 

    private WebElement ShippingAddressFld;


    @FindBy(xpath = "//button[@class='order_btnCustom__oLAF1']") 

    private WebElement AddAddressButton;


    @FindBy(xpath = "(//div[@class='order_groupPosition___wsch'])[2]") 

    private WebElement AddressTxtFld;


    @FindBy(xpath = "//div[@class='AddressModal_customSelectOption__c7wS2']//li") 

    private WebElement AddressSuggestions;


    @FindBy(xpath = "//div[@class='select__control css-1s2u09g-control']") 

    private WebElement GoodCauseTxtFld;


    @FindBy(xpath = "//div[@id='react-select-2-option-0']") 

    private WebElement FirstGoodCause;


    @FindBy(xpath = "//span[@class='checkout_bagsItemTitle__edkbz']") 

    private WebElement ProductNameOnCheckOut;


    @FindBy(xpath = "//span[@class='checkout_bagsItemPrice__5t5dZ']") 

    private WebElement ProductPriceOnCheckOut;


    @FindBy(xpath = "//div[@class='order_causeText__Lkxua']//b[1]") 

    private WebElement GoodCauseAmountOnCkOt;


    @FindBy(xpath = "//div[@class='AddressModal_customSelectOption__c7wS2']//li") 

    private WebElement FirstAddressForGuestUser;


    @FindBy(xpath = "//button[@class='order_btnCustom__oLAF1']") 

    private WebElement SaveBtnForAdrsOfGU;


    @FindBy(xpath = "//div[@class='checkout_yourCauseBlock__cLIro']//button[@class='btnCustom checkout_placeOrderGray__4INF_']") 

    private WebElement UnabledPaceOrderBtn;


    @FindBy(xpath = "//a[contains(text(),'Remove')]") 

    private WebElement RemoveBtn;


    @FindBy(xpath = "(//div[@class='order_groupPosition___wsch'])[2]//input[@type='text']")

    private WebElement EnterAddressTxtFld;


    @FindBy(xpath = "//button[@class='order_btnCustom__oLAF1']") 

    private WebElement SaveBtnForAdrs;


    @FindBy(xpath = "//input[@class='CountryInput_phoneNumber__aEEFK form-control ']")

    private WebElement mblNoTextFld;


    @FindBy(xpath = "//div[@class='order_addressBlock__EqimZ']") 

    private WebElement shippingAddress;


    @FindBy(xpath = "//span[text()='Add New Address']") 

    private WebElement addNewAddressBtn;


    @FindBy(xpath = "(//div[@class='order_groupPosition___wsch'])[2]") 

    private WebElement address1;


    @FindBy(xpath = "//span[@class='checkout_checkmark__2sDPc']") 

    private WebElement deliveryOptionsCheckBox;


    @FindBy(xpath = "//div[@class='Message_cupponMessage__DRXZ6 Message_error__cs_Zw ']") 

    private WebElement placeOrderMsg;


    @FindBy(xpath = "//div[contains(@class,'StripeElement--invalid')]/following-sibling::div[@class='Message_textDanger___OSCV ']") 

    private WebElement emptyCardNoMessage;


    @FindBy(xpath ="//input[@name='name']/following-sibling::div[@class='Message_textDanger___OSCV ']" )

    private WebElement emptyCardNameMsg;


    @FindBy(xpath = "//span[contains(text(),'Place Order')]") 

    private WebElement unPlaceorderBtn;


    @FindBy(xpath = "//div[@class='datepicker_datepicker___8q5i']")

    private WebElement dobtextFld;


    @FindBy(xpath = "//input[@id='flexCheckDefault']")

    private WebElement dobCheckBox;


    @FindBy(xpath = "//select[@style='margin-left: 5px;']")

    private WebElement yearDrpDwn;


    @FindBy(xpath = "//button[@class='btnCustom ']")

    private WebElement joinTheDropBtn;


    @FindBy(xpath = "//div[@class='datepicker_calendar__day__x2XkB']")

    private WebElement firstDateFromCalender;


    @FindBy(xpath = "//label[contains(text(),'Change of mind')]//span[@class='checkout_checkmark__2sDPc checkmark']")

    private WebElement changeOfMindCheckBox;


    @FindBy(xpath = "//div[@class='checkout_deliveryOption__BBwkU']") 

    private List<WebElement> deliveryOptions;


    @FindBy(xpath = "//div[@class='checkout_deliveryOption__BBwkU'] //span[@class='checkout_radioHd__fXp1h' and text()='Standard Delivery - Retailer Managed']") 

    private WebElement standardDelivery;


    @FindBy(xpath = "//div[@class='checkout_deliveryOption__BBwkU'] //span[@class='checkout_radioHd__fXp1h' and text()='Express Delivery']") 

    private WebElement expressDelivery;

 

    @FindBy(xpath = "//span[text()='Buy Now']")

    public WebElement buyNow;


    public WebElement getUnabledPaceOrderBtn() {

        return UnabledPaceOrderBtn;

    }

 

    public WebElement getSaveBtnForAdrs() {

        return SaveBtnForAdrs;

    }

 



    public WebElement getMblNoTextFld() {

        return mblNoTextFld;

    }

 



    public WebElement getShippingAddress() {

        return shippingAddress;

    }

 



    public WebElement getAddNewAddressBtn() {

        return addNewAddressBtn;

    }

 



    public WebElement getAddress1() {

        return address1;

    }

 



    public WebElement getDeliveryOptionsCheckBox() {

        return deliveryOptionsCheckBox;

    }

 



    public WebElement getPlaceOrderMsg() {

        return placeOrderMsg;

    }

 



    public WebElement getEmptyCardNoMessage() {

        return emptyCardNoMessage;

    }

 



    public WebElement getEmptyCardNameMsg() {

        return emptyCardNameMsg;

    }

 



    public WebElement getDobtextFld() {

        return dobtextFld;

    }

 



    public WebElement getDobCheckBox() {

        return dobCheckBox;

    }

 



    public WebElement getYearDrpDwn() {

        return yearDrpDwn;

    }

 



    public WebElement getJoinTheDropBtn() {

        return joinTheDropBtn;

    }

 



    public WebElement getFirstDateFromCalender() {

        return firstDateFromCalender;

    }

 



    public WebElement getChangeOfMindCheckBox() {

        return changeOfMindCheckBox;

    }

 



    //public void getDelivery() {

    //    return Delivery;

//    }

 




 

    public WebElement getUnPlaceorderBtn() {

        return unPlaceorderBtn;

    }

 

    //@FindBy(xpath = "//div[@id='react-select-2-placeholder']")



 

    public WebElement getContinueAsaGuestButton() {

        return ContinueAsaGuestButton;

    }

 

    public WebElement getShippingAddressFld() {

        return ShippingAddressFld;

    }

 

    public WebElement getAddAddressButton() {

        return AddAddressButton;

    }

 

    public WebElement getAddressTxtFld() {

        return AddressTxtFld;

    }

 

    public WebElement getAddressSuggestions() {

        return AddressSuggestions;

    }

 

    public WebElement getGoodCauseTxtFld() {

        return GoodCauseTxtFld;

    }

 

    public WebElement getFirstGoodCause() {

        return FirstGoodCause;

    }

 

    public WebElement getProductNameOnCheckOut() {

        return ProductNameOnCheckOut;

    }

 

    public WebElement getProductPriceOnCheckOut() {

        return ProductPriceOnCheckOut;

    }

 

    public WebElement getGoodCauseAmountOnCkOt() {

        return GoodCauseAmountOnCkOt;

    }

 

    public WebElement getFirstAddressForGuestUser() {

        return FirstAddressForGuestUser;

    }

 

    public WebElement getSaveBtnForAdrsOfGU() {

        return SaveBtnForAdrsOfGU;

    }

 

    public WebElement getEnterAddressTxtFld() {

        return EnterAddressTxtFld;

    }

 

    public WebElement getPlaceOrderBtn() {

        return PlaceOrderBtn;

    }

 

    public WebElement getAddPaymentMethodBtn() {

        return AddPaymentMethodBtn;

    }

 

    public WebElement getCVVFrameText() {

        return CVVFrameText;

    }

 

    public WebElement getExpFrameText() {

        return ExpFrameText;

    }

 

    public void ContinueGuestBtn() {

        ContinueAsaGuestButton.click();    

    }

 

    public WebElement getGCDrpDwn() {

        return GCDrpDwn;

    }

 

    public WebElement getChangeGoodCauseBtn() {

        return ChangeGoodCauseBtn;

    }

 

    public WebElement getDeliveryMethods() {

        return DeliveryMethods;

    }

 

    public WebElement getNameTxtFldInCardDls() {

        return NameTxtFldInCardDls;

    }

 



    public WebElement getOption() {

        return Option;

    }

    public WebElement getRemoveBtn() {

        return RemoveBtn;

    }

 

    public void Delivery() {

        String options = DeliveryOptions.getText();

        System.out.println(options);

    }

 

    public WebElement getDeliveryOptions() {

        return DeliveryOptions;

    }

 

    public boolean placeOrderEnable() {

        boolean chck = PlaceOrderBtn.isEnabled();

        System.out.println(chck);

        return chck;

    }

 

    public boolean CardNoTextFldMsg() {

        String msg = emptyCardNoMessage.getText();

        //System.out.println(msg);

        if (msg.contains("Your card number is incomplete.")) {

            System.out.println("The New Customer has Not Entered The Card Number In the Card Number Text Field");

            return true;

        }

        else {

            System.out.println("The New Customer has Enetered the Card number In the Text Field");

            return false;

        }

    }

 

    public void SelectYearDrpDwn() throws InterruptedException {

        Select sel = new Select(yearDrpDwn);

        sel.selectByValue("1995");

        Thread.sleep(2000);

        firstDateFromCalender.click();

    }

    public boolean CardNameTextFldMsg() {

        String msg = emptyCardNameMsg.getText();

        //System.out.println(msg);

        if (msg.contains("Enter name.")) {

            System.out.println("The New Customer has Not Entered The Card Name In the Card Name Text Field");

            return true;

        }

        else {

            System.out.println("The New Customer has Enetered the Card Name In the Text Field");

            return false;

        }

 

    }

 

    public void Deliverymethods() {

        String list = DeliveryMethods.getText();

        System.out.println(list);

    }

 

    public void NameInCard() {

        NameTxtFldInCardDls.sendKeys("Spring");

    }

 

    public void RemoveBtn() {

        RemoveBtn.click();

    }

    public void SaveBtnAdrsGU() {

        SaveBtnForAdrsOfGU.click();

    }

    public void DobTextFld() {

        dobtextFld.click();

    }

    public void DobCheckBox() {

        boolean isSelected = dobCheckBox.isSelected();

        //performing Click operation if element is not selected

        if (isSelected==false) {

            dobCheckBox.click();

        }

    }

 

    public boolean VerifyDeliveryOptionSelection() {

        // WebElement result = deliveryOptionsCheckBox;

        // System.out.println("The checkbox is selection state is - "+result.isSelected() );

        if (deliveryOptionsCheckBox.isSelected()) {

            System.out.println("The New Customer has selected the delivery option Return.: " +deliveryOptionsCheckBox.isSelected() );

            return false;

        }

        else {

            System.out.println("The New Customer has not selected the Delivery option Return . : " +deliveryOptionsCheckBox.isSelected() );

            return true;

        }

    }

 

    public String ShippingAddress() {

        String value=shippingAddress.getText();

        //System.out.println(value);

        return value;

 

    }

    public String getCheckoutProdName() {

        String checkout_Prod_Name = checkoutProdName.getText();

        //System.out.println("The product which is added to cart is : "+checkout_Prod_Name);

        return checkout_Prod_Name;

    }

 

    public void UnPlace() {

        unPlaceorderBtn.click();

    }

    public String getLoginBtn() {

        String Logintxt = LoginBtn.getText();

        //        System.out.println("............."+Logintxt);

        return Logintxt;}

 

    public void clickLoginBtn() {

        LoginBtn.click();

    }

 

    public String getDelveryOption() {

        String delopttxt = DelveryOption.getText();

        return delopttxt;

    }

 

    public void AddressForGuestUser() {

        AddressSuggestions.click();

    }

    public void AddressSuggestions() {

        AddressSuggestions.click();

    }

    public void AddressSaveBtn() {

        SaveBtnForAdrs.click();

    }

    public void EnterAsAGuestButton() {
        enterAsaGuestBtn.click();
    }
    public String getYourGC() {

        String yourGCtxt = YourGC.getText();

        return yourGCtxt;

    }

 

    public void JoinTheDropBtn() {

        joinTheDropBtn.click();

    }

    public String PlaceOrderBtnmsg() {

        return placeOrderMsg.getText();

    }

    public void AddNewAddressBtn() throws InterruptedException {

        addNewAddressBtn.click();

        address1.click();

        EnterAddressTxtFld.sendKeys("syndey");

        AddressSuggestions.click();

        MobileNoTextFld();

        AddressSaveBtn();

    }

    public String ProdutcNameOnCheckout() throws InterruptedException {

        Thread.sleep(2000);

        String productName = ProductNameOnCheckOut.getText();

        System.out.println(productName);

        return productName;

    }

 

    public void GCDropDown() {

        GCDrpDwn.click();

        FirstGoodCause.click();

        //String text = GCDrpDwn.getText();

        //System.out.println(text);

    }

    public void MobileNoTextFld() throws InterruptedException {

        mblNoTextFld.click();

        mblNoTextFld.clear();

        mblNoTextFld.sendKeys("987654");

        Thread.sleep(3000);

    }

 

    public void ChangeGoodCauseBtn() {

        //        WebDriver driver = null;

        //        Actions action = new Actions(driver);

        //        action.moveToElement(ChangeGoodCauseBtn).perform();

        ChangeGoodCauseBtn.click();

    }

 

    public void CardNoField() {

        CardNoTextFld.sendKeys("4242 4242 4242 4242");

    }

 

    public WebElement getCardNoTextFld() {

        return CardNoTextFld;

    }

 

    public WebElement getExpDateTextFld() {

        return ExpDateTextFld;

    }

 

    public WebElement getCVVTextFld() {

        return CVVTextFld;

    }

 

    public WebElement getCardNoFrameText() {

        return CardNoFrameText;

    }

    public void PlaceOrderBtn() {

        //    boolean ebld = PlaceOrderBtn.isEnabled();

        //    System.out.println(ebld);

        PlaceOrderBtn.click();

    }

 

    public void ExpireDateFld() {

        ExpDateTextFld.sendKeys("05/45");    

    }

    public void CVVField() {

        CVVTextFld.sendKeys("112");    

    }

    public void AddPaymentBtn() {

        AddPaymentMethodBtn.click();

    }


    public void AddPaymentBtn(WebDriver driver) {
    	webDriverUtility.scrollUntilElementFound(driver, AddPaymentMethodBtn);
        wait.until(ExpectedConditions.elementToBeClickable(AddPaymentMethodBtn)).click();
        //AddPaymentMethodBtn.click();

    }

 



	public void ChangeOfMindCheckBox() {

        changeOfMindCheckBox.click();

    }

 



    public void ShippingAddressField() {

        ShippingAddressFld.click();

    }

 

    public void AddAddressBtn() {

        AddAddressButton.click();

    }

 

    public void AddressTextField() {

        AddressTxtFld.click();

        //AddressTxtFld.sendKeys(Characters);

        //String autosuggestions = AddressSuggestions.getText();

        //System.out.println(autosuggestions);    

    }

 



    public void EnterAddress(String location) {

        EnterAddressTxtFld.sendKeys(location);

    }

    /*public void AddressTextField() {

          AddressTxtFld.sendKeys("albert");    

    }*/

    public void GoodCause() {

        GoodCauseTxtFld.click();

        //        String text = GoodCauseTxtFld.getAttribute("value");

        //        System.out.println(text);

        FirstGoodCause.click();    

    }

 

    public boolean GoodCauseText() {

        String text = GoodCauseTxtFld.getText();

        System.out.println(text);

        if (text.contains("Select Good Cause")) {

            System.out.println("The New Customer has not selected a GC");

            return true;

        }

        else {

            System.out.println("The New Customer has selected a GC");

            return false;

        }        

    }

 

    public String productPriceonCheckOut() {

        String price=ProductPriceOnCheckOut.getText();

        System.out.println(price);

        return price;

    }

 

    public String GCAmtOnCkOt() {

        String gcAmount = GoodCauseAmountOnCkOt.getText();

        System.out.println(gcAmount);

        return gcAmount;

 

    }

    public void UnabledPlaceOrder() {

        UnabledPaceOrderBtn.click();

    }

 

    public boolean CardNameTextField() {

        String textvalue = getNameTxtFldInCardDls().getAttribute("value");

        if (textvalue.isEmpty()) {

            System.out.println("The Text Field is Empty");

            //CommonBaseTest cbt = new CommonBaseTest();

            //cbt.extentTest.log(Status.PASS, "The New Customer has not added the Name in the Card Details Text field");

            return true;

        }

        else {

            System.out.println("The Text Field is Not Empty");

            //cbt.extentTest.log(Status.PASS, "The New Customer has added the Name in the Card Details Text field");

            return false;

        }

    }

 

    

    public boolean CardNoTextField() {

        try {

            String numValue = getCardNoFrameText().getAttribute("value");

            //System.out.println(numValue);

            if (numValue != null && !numValue.isEmpty()) {

                System.out.println("The number Field is not Empty");

                //cbt.extentTest.log(Status.PASS, "The Number Text Field is not Empty");

                return false;

            }

            else {

                System.out.println("The number Field is  Empty");    

                //cbt.extentTest.log(Status.PASS, "The Number Text Field is also Empty");

                return true;

            }

        }

        catch (Exception e) {

            System.out.println("An error occurred while checking the number text field: " + e.getMessage());

            return false;

        }

    }

 

    public boolean ExpiredateTextField() {

        try {

            String dateValue = getExpDateTextFld().getAttribute("value");

            //String cvvValue = getCVVTextFld().getAttribute("val");

            //System.out.println(numValue);

            if (dateValue != null && !dateValue.isEmpty()) {

                System.out.println("The ExpireDate Text Field is not Empty");

                return false;

            }

            else {

                System.out.println("The number Field is  Empty");    

                return true;

            }

        }

        catch (Exception e) {

            System.out.println("An error occurred while checking the number text field: " + e.getMessage());

            return false;

        }

    }

 

    public boolean CvvTextField() {

        try {

 

            String cvvValue = getCVVTextFld().getAttribute("value");

            //System.out.println(numValue);

            if (cvvValue != null && !cvvValue.isEmpty()) {

                System.out.println("The ExpireDate Text Field is not Empty");

                return false;

            }

            else {

                System.out.println("The number Field is  Empty");    

                return true;

            }

        }

        catch (Exception e) {

            System.out.println("An error occurred while checking the number text field: " + e.getMessage());

            return false;

        }

    }



    public void DeliveryOptions() throws Throwable {

        for (WebElement options : deliveryOptions) {

            String names = options.getText();

            //System.out.println(names);

            if (names.contains("Standard Delivery - Retailer Managed")) {

                standardDelivery.click();

                Thread.sleep(3000);

                break;


            }

            else if (names.contains("Express Delivery")) {

                expressDelivery.click();

                Thread.sleep(3000);

                break;

            }

        }

    }

 

    



        public void addCardDetails() throws InterruptedException

        {

            //scrollBarAction(driver);

            //js.executeScript("window.scrollBy(0,700)");

            if(AddPaymentMethodBtn.isDisplayed())

            {

                NameInCard();

                driver.switchTo().frame(CardNoFrameText);

                CardNoField();

                driver.switchTo().defaultContent();

                driver.switchTo().frame(getExpFrameText());

                ExpireDateFld();

                driver.switchTo().defaultContent();

                driver.switchTo().frame(getCVVFrameText());

                CVVField();

                driver.switchTo().defaultContent();

                Thread.sleep(5000);

                webDriverUtility.scrollAndClickElement(driver,AddPaymentMethodBtn);

                Thread.sleep(5000);

            }

        }

 



        public String[] getDataFromTable(String colNumber)

        {

            List<WebElement> ele = driver.findElements(By.xpath("//tbody[@id='auctionInventory']//tr"));

            int len = ele.size();

            String [] col3Value = new String [len]; 

//            String [] col5Value = new String [len];    

//            String values [][] = new String  [1][1];

//            values[0]=col3Value;

//            values[1]=col5Value;

            for(int i=1;i<=len;i++)

            {

                col3Value[i-1] = driver.findElement(By.xpath("//tbody[@id='auctionInventory']//tr["+i+"]//td["+colNumber+"]")).getAttribute("value");

//                col5Value[i-1]= driver.findElement(By.xpath("//tbody[@id='auctionInventory']//tr["+i+"]//td[5]")).getAttribute("value");

            }

            return col3Value;

        }

 



        public void clickBuyNow() throws InterruptedException

        {

            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(240));

            //WebElement element = wait2.until(ExpectedConditions.visibilityOf(buyNow));

            Thread.sleep(3000);

            //wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Buy Now']")));

            //driver.findElement(By.xpath("//span[text()='Buy Now']")).click();

//            element.click();

            webDriverUtility.scrollBarAction(driver);

            Thread.sleep(1000);

            driver.findElement(By.xpath("//span[text()='Buy Now']")).click();

        }


}
