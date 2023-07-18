package script;
import java.time.LocalDateTime;

import java.time.LocalTime;

import java.time.ZoneId;

import java.time.ZonedDateTime;

import java.time.format.DateTimeFormatter;

import java.util.ArrayList;

import java.util.List;

import java.util.Set;

 

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.testng.annotations.Test;

 

import com.aventstack.extentreports.Status;

 

import generic.BTExcel;

import generic.CommonBaseTest;

import generic.WebDriverUtility;

import page.AddYourShippingDetailsPage;

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

import page.MultiRetailerGridPage;

import page.PlaceAnOfferPage;

import page.ProductDetailsPage;

import page.ScheduleDropAuctionPage;

import page.SignInPage;

 

public class BuyBeforeDropAuctionProduct  extends CommonBaseTest{

 

//In this Script the user has purchased the product before the Drop

    @Test(priority = 30)

    public void BuyBeforeDrop() throws Throwable {

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

        ProductDetailsPage pdp = new ProductDetailsPage(driver);

        AddYourShippingDetailsPage aysdp = new AddYourShippingDetailsPage(driver);

        PlaceAnOfferPage paop = new PlaceAnOfferPage(driver);

        CongratulaionsPage cp = new CongratulaionsPage(driver);

        WebDriverUtility webDriverUtility = new WebDriverUtility();



        mrp.popUpCloseButton();

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bhp.getLastElementOfPage());

        Thread.sleep(3000);

        bhp.SelectTheCountry();

        Thread.sleep(2000);

        bhp.BetterThatImg();

        Thread.sleep(2000);

 

        //Open BT FrontEnd

        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript("window.open();");//Opening the New tab

        Thread.sleep(2000);

        Set<String> windows = driver.getWindowHandles();

        ArrayList<String> tabs = new ArrayList<String>(windows);

        driver.switchTo().window(tabs.get(1));//Naivigating to New Tab

        Thread.sleep(2000);

        driver.get("https://dev.betterthat.shop/login");

        Thread.sleep(2000);

 

        String signInMail = BTExcel.getCellData(INPUTXL_PATH, "BTBackend",1, 0);//Fetching the UserName from the ExcelSheet

        String signInpassword = BTExcel.getCellData(INPUTXL_PATH, "BTBackend",1, 1);//Fetching the User Password from the ExcelSheet

        blp.enterBackendEmail(signInMail);//Passing the values in the Text Fields

        blp.enterBackendPw(signInpassword);

        blp.loginBtnClick();

        Thread.sleep(2000);

 

        bdbp.DropAuction(); //Click on Drop Auction Button

        Thread.sleep(2000);

        brdp.ScheduleDrop(); //Click on the Schedule Drop Auction Button

        Thread.sleep(2000);

        brpp.SelectRetailerField(); //click on Select Retailer Field

        Thread.sleep(2000);


        brpp.FirstRetailer();

        Thread.sleep(4000);


        int i;

        List<WebElement> productLists = driver.findElements(By.

                xpath("//tr[@role='row'and @class='odd' or @class='even']"));

        System.out.println(productLists.size());

        label:

        for (i = 1; i <= productLists.size(); i++) {

            System.out.println(i+"th row");

            //brpp.getActionsBtn().click();

            driver.findElement(By.xpath("(//tr[@role='row'and @class='odd' or @class='even']/td/div[@class='dropdown custom'])["+i+"]")).click();

            Thread.sleep(2000);

            driver.findElement(By.xpath("(//a[contains(@href,'retailerProductbyID')])["+i+"]")).click();

            Thread.sleep(2000);

            String text = sdap.getBtProductStatusTextField().getAttribute("value");

            System.out.println(text);

            if (text.equals("Inactive")) {

                driver.navigate().back();

                Thread.sleep(3000);

                continue label;

            }

            break;

        }

        String activeProductRowNo = Integer.toString(i);

        driver.navigate().back();

        Thread.sleep(3000);

        driver.findElement(By.xpath("(//tr[@role='row'and @class='odd' or @class='even']/td/div[@class='dropdown custom'])["+activeProductRowNo+"]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("(//a[contains(@href,'/auction/create/')])["+activeProductRowNo+"]")).click();

        Thread.sleep(2000);

        String activeproductName=driver.findElement(By.xpath("(//td[@class='item-name']//div[@class='product'])")).getText();

        System.out.println(activeproductName);

        System.out.println("Done");


        sdap.FeaturedDropAuction(); //Click on Featured checkBox

        Thread.sleep(2000);

        sdap.DropAuctionDate(); //Click on Date Text Field

        Thread.sleep(2000);

        sdap.DateSelected (); //click on the Date from the Calender

        Thread.sleep(2000);

        sdap.DropAuction24HrsFormat(); // click on the 24 hrs format field

        Thread.sleep(2000);

 

        // Get the current time in Sydney

        LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("Australia/Sydney"));

 

        // Add 1 hour to the current time

        LocalDateTime updatedDateTime = currentDateTime.plusHours(1);

 

        int hour = updatedDateTime.getHour();

 

        String hrs=Integer.toString(hour);

        System.out.println(hrs);

        // Format the updated time

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        String formattedDateTime = updatedDateTime.format(formatter);

 

        // Print the updated Sydney time

        System.out.println("Updated Sydney Time: " + formattedDateTime);

 

        sdap.getDropAuction24hrsFormatTextField().sendKeys(hrs);

        sdap.getDropAuction24hrsFormatTextField().sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        //int minutesToAdd = 2;

 

        int minute = updatedDateTime.getMinute();

        if (minute % 2 != 0) {

            minute++; 

        }

        System.out.println(minute);

 

        String min = updatedDateTime.withMinute(minute).format(formatter);

        System.out.println(min);

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("window.scrollTo(0,100)", "");

        sdap.getDropAuctionAvailableSlotField().click();

        sdap.getDropAuctionAvailableSlotTextField().sendKeys(min);

        sdap.getDropAuctionAvailableSlotTextField().sendKeys(Keys.ENTER);

        Thread.sleep(2000);

 



        webDriverUtility.scrollBarAction(driver);

        //sdap.StartingPriceField();

        Thread.sleep(1000);

        //    sdap.BuyBeforePrice();

        //sdap.RowsData();

        //sdap.data();

        Thread.sleep(3000);

        List<WebElement> rows = driver.findElements(By.xpath("//tbody[@id='auctionInventory']//tr"));

 

        System.out.println(rows.size());

 

        for (int j = 1; j <=rows.size(); j++) {

            System.out.println(j+"th row");

            String startingprice = driver.findElement(By.xpath("(//tbody[@id='auctionInventory']/tr/td[3]//input)["+j+"]")).getAttribute("value");

            System.out.println(startingprice);

            Thread.sleep(2000);

            String buybeforeprice = driver.findElement(By.xpath("(//tbody[@id='auctionInventory']//td[5]//input[@type='number'])["+j+"]")).getAttribute("value");

            System.out.println(buybeforeprice);

            Thread.sleep(2000);

            double dbt = Double.parseDouble(buybeforeprice);

            System.out.println("This is Double value = "+dbt);

            double ded = (dbt-(dbt*.21));

            String pass = Double.toString(ded);

            System.out.println(pass);

            //int sct=(int)dbt;

            //int bba = (int) (sct-(sct*.21));

            //String pass = Integer.toString(bba);

            //System.out.println(bba);

            //System.out.println(pass);

            WebElement updatedprice = driver.findElement(By.xpath("(//tbody[@id='auctionInventory']//td[5]//input[@type='number'])["+j+"]"));

            updatedprice.clear();

            updatedprice.sendKeys(pass);

            System.out.println("In the Buy Before Auction Field "+ updatedprice.getAttribute("value"));

            Thread.sleep(2000);

        }

 



        sdap.ScheduleAuctionBtn();

        Thread.sleep(1000);

 

        sdap.YesButtonOnPopUp();

        Thread.sleep(2000);

 

        String confirmation = sdap.PopUpMessage();

        if (confirmation.contains("Success")) {

            System.out.println("The Product is added to the Drop auction ");

            extentTest.log(Status.PASS, "The Product is Added to the DropAuction");

        }

        else {

            System.out.println("The Product is  not added to the Drop auction ");

            extentTest.log(Status.FAIL, "The Product is  not Added to the DropAuction");

        }


        Thread.sleep(3000);

        bdbp.DropAuction();

        Thread.sleep(3000);

        //String name = brdp.ProducName();

        String productnameinbackend=brdp.ProducName();

        Thread.sleep(3000);


        if (activeproductName.equals(productnameinbackend)) {

            System.out.println("The product are same");

            extentTest.log(Status.INFO, "The product which scheduled for the drop auction are same");

        }

        else {

            System.out.println("The product are different");

            extentTest.log(Status.INFO, "The product which scheduled for the drop auction are different");

        }

 

        driver.switchTo().window(tabs.get(0));

        System.out.println("The user navigates to the FrontEnd from the Backend ");

        extentTest.log(Status.INFO, "The user havs navigates to the FrontEnd");

        Thread.sleep(2000);

        //mrp.popUpCloseButton();

        //Thread.sleep(2000);

        bhp.DropAuctionBtn();

        Thread.sleep(2000);

        dap.ScrollUntilTheElement(driver);

        Thread.sleep(2000);

        dap.ProductImage();

        Thread.sleep(2000);

        //scrollBarAction(driver);

        js.executeScript("window.scrollTo(0,700)", "");

        Thread.sleep(2000);


    //    dapdp.AttributeSelection();

    //    Thread.sleep(2000);

        if (dapdp.PlaceAnOfferButtonText().contains("Place an Offer Now")) {

            System.out.println("The user is going to Buy the product before the Drop");

            extentTest.log(Status.INFO, "The user is going to Buy the product before the Drop");

        }

        dapdp.PlaceAnOffer();

        Thread.sleep(2000);

 

        String signUpName = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",4, 0);//Fetching the UserName from the ExcelSheet

        String signUpPassword= BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",4, 3);//Fetching the User Password from the ExcelSheet

 

        sip.enterSingInEmail(signUpName);

        extentTest.log(Status.INFO, "SinginEmail Entered:  "+signUpName);

        sip.enterSingInPwd(signUpPassword);

        extentTest.log(Status.INFO, "Password:  "+"*******");

        sip.btnClick();

        Thread.sleep(4000);

        //scrollBarAction(driver);

        js.executeScript("window.scrollTo(0,600)", " ");

        Thread.sleep(3000);

        //navigated to Product Details page

 



        Thread.sleep(2000);

        //dapdp.AttributeSelection();

        //Thread.sleep(3000);

        //String priceofProduct = dapdp.ProductPrice();

        //System.out.println(priceofProduct);

        Thread.sleep(2000);


        String priceofProduct = dapdp.ProductPrice();

        String productName = dapdp.ProductName();


        if (productnameinbackend.equals(productName)) {

            System.out.println("The products are same in both Backend and FrontEnd");

        extentTest.log(Status.INFO , "The products are same in both Backend and FrontEnd")    ;

        }


        else {

            System.out.println("The product are Different in front end and Backend");

            extentTest.log(Status.INFO , "The products are different in both Backend and FrontEnd")    ;

        }


        dapdp.PlaceAnOffer();

        Thread.sleep(4000);

 

        //This below needs to explore


        if (pdp.getAddCardPopUp().isDisplayed()) {

            pdp.AddCardPopUp();

            Thread.sleep(2000);

            driver.switchTo().frame(pdp.cardPaymentFrameText);

            Thread.sleep(1000);

            pdp.CardNoTextField("4242 4242 4242 4242","12/67","124");

            Thread.sleep(1000);

            driver.switchTo().defaultContent();

            Thread.sleep(2000);

            pdp.AddCardBtn();

            Thread.sleep(5000);    

        }


        aysdp.DeliveryOptions();

        Thread.sleep(2000);


        /*

        aysdp.DobTextFld();

        js.executeScript("window.scrollTo(0,100)", " ");

        Thread.sleep(2000);

 

        aysdp.SelectYearDrpDwn();

        Thread.sleep(3000);

 

        aysdp.DobCheckBox();

        Thread.sleep(1000);

        */

        aysdp.ConfirmShipping();

        Thread.sleep(3000);

 

        int dis=10;

        double noDbl = Double.parseDouble(priceofProduct); //String to integer

        int numInt = (int)noDbl;

        System.out.println(numInt);

 

        //int act =(int)Integer.parseInt(priceofProduct);//String to integer

        //System.out.println(act);

        //String sub = Integer.toString(dis);//Interger to String

        int passvalue = numInt - dis;

        //System.out.println(passvalue);

        String assumedvalue = Integer.toString(passvalue);

        System.out.println(assumedvalue);

        paop.EnterPriceTextField(assumedvalue);

        Thread.sleep(1000);

        paop.PlaceAnOfferbBtn();

        Thread.sleep(5000);

        Boolean msg = paop.FailedMsg();

        if (msg) {

            System.out.println("The User has lost the Buy Before Auction Product ");

            extentTest.log(Status.PASS, "The User has lost the Buy Before Auction Product ");

        }

        else {

            System.out.println("The User has purchased the Buy Before Auction Product ");

            extentTest.log(Status.FAIL, "The User has purchased the Buy Before Auction Product ");

        }

        Thread.sleep(4000);

 

        cp.CongratesText();

        String proName = cp.getProductName().getText();

        System.out.println(proName);

        /*

        if (proName.contains(name)) {

            System.out.println("The Product purchase is same");

        }

        else {

            System.out.println("The product is Different");

        }*/

        Thread.sleep(4000);

 

    }

}
