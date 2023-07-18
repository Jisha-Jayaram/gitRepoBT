package script;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BTExcel;
import generic.CommonBaseTest;
import generic.WebDriverUtility;
import net.bytebuddy.agent.builder.AgentBuilder.Identified.Extendable;
import page.BackendDashBoardPage;
import page.BackendLoginPage;
import page.BackendRetailerDropAuctionPage;
import page.BackendRetailersProductsPage;
import page.BtHomepage;
import page.CheckOutPage;
import page.CongratulaionsPage;
import page.DropAuctionPage;
import page.DropAuctionProductDetailsPage;
import page.DropAuctionRoomPage;
import page.EnterAsAGuestPage;
import page.LosingDropPage;
import page.MultiRetailerGridPage;
import page.ScheduleDropAuctionPage;
import page.SignInPage;
public class DropAuctionForGuestUser extends CommonBaseTest {
	@Test(priority = 33)
    public void DropAuctionForGuestUserAndloseDrop() throws Throwable {
    BtHomepage bhp = new BtHomepage(driver);
BackendLoginPage blp = new BackendLoginPage(driver);
    BackendDashBoardPage bdbp = new BackendDashBoardPage(driver);
    BackendRetailerDropAuctionPage brdp = new BackendRetailerDropAuctionPage(driver);

    BackendRetailersProductsPage brpp = new BackendRetailersProductsPage(driver);

    ScheduleDropAuctionPage sdap = new ScheduleDropAuctionPage(driver);

    MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);

    DropAuctionPage dap = new DropAuctionPage(driver);

    DropAuctionProductDetailsPage dapdp = new DropAuctionProductDetailsPage(driver);

    CheckOutPage cop = new CheckOutPage(driver);

    SignInPage sip = new SignInPage(driver);

    DropAuctionRoomPage darp = new DropAuctionRoomPage(driver);

    WebDriverUtility webDriverUtility = new WebDriverUtility();

    CongratulaionsPage cp = new CongratulaionsPage(driver);

    EnterAsAGuestPage eagp = new EnterAsAGuestPage(driver);
LosingDropPage ldp = new LosingDropPage(driver);

    Thread.sleep(2000);

    ((JavascriptExecutor) driver).executeScript("window.open();"); //Create a new Tab

    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

    driver.switchTo().window(tabs.get(1)); //Switch to New Tab

    Thread.sleep(2000);


    driver.get("https://dev.betterthat.shop/login"); //Pass the URL in the New tab

    Thread.sleep(2000);


    String backendSignInmail = BTExcel.getCellData(INPUTXL_PATH, "BTBackend", 1,0); //Fetch the UserName from ExcelSheet

    String backendSignInPassword=BTExcel.getCellData(INPUTXL_PATH, "BTBackend", 1,1); //Fetch the Password from ExcelSheet 

    blp.enterBackendEmail(backendSignInmail); //Pass the Username from the excel sheet

    blp.enterBackendPw(backendSignInPassword); //Pass the Password from the ExcelSheet


    blp.loginBtnClick(); //Click on Login Button

    extentTest.log(Status.INFO, "The User is in the BT BAckend Page");

    Thread.sleep(3000);


    bdbp.DropAuction(); //Click on Drop Auction Button

    Thread.sleep(2000); 


    brdp.ScheduleDrop(); //Click on Schedule Drop Button

    Thread.sleep(2000); 


    brpp.SelectRetailerField(); // Click on Select Retailer Button

    Thread.sleep(2000);


 

    String retailerName = BTExcel.getCellData(INPUTXL_PATH, "RetailerAndProducts", 1,0); //Fetch the Retailer Name from ExcelSheet

    String productName=BTExcel.getCellData(INPUTXL_PATH, "RetailerAndProducts", 1,1); //Fetch the Product Name from ExcelSheet 


    brpp.InputRetaileFld(retailerName); //Passing the Store Name

    Thread.sleep(2000);


     String enteredproducname=brpp.ProductNameTextFld(productName); //passing the product name

    Thread.sleep(3000);


    brpp.ActionsBtn(); //Click on the Action Button

    Thread.sleep(3000);


    brpp.ScheduleDropAuctionbtn(); //Click on the Schedule drop button

    Thread.sleep(2000);


    sdap.FeaturedDropAuction(); //Click on Featured Check Box on page

    Thread.sleep(2000);


    sdap.DropAuctionDate(); //Click on Date Text Field

    Thread.sleep(2000);


    sdap.DateSelected (); //Select the date from the Calender

    Thread.sleep(2000);


    sdap.DropAuction24HrsFormat(); //Click on the DropAuction24HrsFormat field

    Thread.sleep(2000);


    ZoneId sydneyZone = ZoneId.of("Australia/Sydney"); // Define the time zone for Sydney

 

    // Get the current time in Sydney

    ZonedDateTime sydneyTime = ZonedDateTime.now(sydneyZone);

    int hours=sydneyTime.getHour();

    System.out.println(hours);

    String hrs = Integer.toString(hours);

 

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); // Define the date and time format

 

    // Format and print the Sydney time

    String formattedTime = sydneyTime.format(formatter);

    System.out.println("Current time in Sydney: " + formattedTime);

 

    sdap.getDropAuction24hrsFormatTextField().sendKeys(hrs);

    sdap.getDropAuction24hrsFormatTextField().sendKeys(Keys.ENTER);

    Thread.sleep(2000);

 

    int minutesToAdd = 2; //Adding 2 minutes extra for scheduling the drop

 

    int minute = sydneyTime.getMinute() + minutesToAdd ;

    if (minute % 2 != 0) {

        minute++; 

    }


    String min = sydneyTime.withMinute(minute).format(formatter);

    System.out.println(min);


    JavascriptExecutor js = (JavascriptExecutor)driver;

    js.executeScript("window.scrollTo(0,100)", "");


    sdap.getDropAuctionAvailableSlotField().click();

    sdap.getDropAuctionAvailableSlotTextField().sendKeys(min); //Passing the minutes in the Minutes Text Field.

    sdap.getDropAuctionAvailableSlotTextField().sendKeys(Keys.ENTER); //Press an Enter after Passing the minutes

    Thread.sleep(2000);


    sdap.ScheduleAuctionBtn(); //Click on Schedule Drop Button

    Thread.sleep(500);


    //Validation Whether the Drop Auction is Scheduled or Not

    String confirmation = sdap.PopUpMessage();

    if (confirmation.contains("Success")) {

        System.out.println("The Product is added to the Drop auction ");

        extentTest.log(Status.PASS, "The Product is Added to the DropAuction");

    }

    else {

        System.out.println("The Product is  not added to the Drop auction ");

        extentTest.log(Status.FAIL, "The Product is  not Added to the DropAuction");

    }

 

    bdbp.DropAuction(); //Click on the Drop Auction button from the DashBoard

    Thread.sleep(2000);

    /*

    //Validating for the product Name 

     String productNameAfterPlacingDrop=brdp.ProducName();

    Thread.sleep(4000);

    if (productNameAfterPlacingDrop.contains(enteredproducname)) {

        System.out.println("The Product is Same");    

        extentTest.log(Status.INFO, "The product Entered and the Product Placed for Drop are Same");

    }

    else {

        System.out.println("The Product is Different");

        extentTest.log(Status.INFO, "The product Entered and the Product Placed for Drop are Different");

    }

    */

    driver.switchTo().window(tabs.get(0)); //Switch Back to previous Ta

    Thread.sleep(2000);


    mrp.popUpCloseButton(); //Closing the Pop up

    Thread.sleep(2000);


    bhp.DropAuctionBtn(); //Clicking on the DropAutcion Button from the page

    Thread.sleep(2000);


    dap.ScrollUntilTheElement(driver); //ScrollUntil the Element found

    Thread.sleep(2000);


    dap.ProductImage(); //Click on the drop auction image

    Thread.sleep(2000);


    js.executeScript("window.scrollTo(0,700)", "");

    Thread.sleep(2000);


    dapdp.AttributeSelection(); //Select the Attribute of the Product

    Thread.sleep(2000);


    dapdp.JoinTheDrop(); //click on join the drop button

    Thread.sleep(2000);


    cop.EnterAsAGuestButton();  //Click on Enter As A Guest Button

    Thread.sleep(2000);


    eagp.GuestUserName(); //Enter the GuestUserMail and Name

    Thread.sleep(2000);


    eagp.SelectTheCountry(); //Select the Country  and Pass the Address and select the shipping details

    Thread.sleep(2000);


    eagp.CardDetails(); //Enter the Card details

    Thread.sleep(2000);


    eagp.Datefield();

    Thread.sleep(3000);


    eagp.EnterGuestBtn();

    Thread.sleep(6000);

    boolean confirm=ldp.LosePage();
    if (confirm) {
        extentTest.log(Status.PASS, "The User has lost the Drop Auction Product");
   }


    }

}

 