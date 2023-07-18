package script;

import java.time.Duration;

import java.time.LocalTime;

import java.time.ZoneId;

import java.time.ZonedDateTime;

import java.time.format.DateTimeFormatter;

import java.util.ArrayList;

import java.util.List;

import java.util.Set;

import javax.swing.text.Element;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.WindowType;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

 

import freemarker.core.JavaScriptOutputFormat;

import generic.CommonBaseTest;

import generic.WebDriverUtility;

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

import page.ScheduleDropAuctionPage;

import page.SignInPage;

 

public class DropAutcionScheduledAndWonTheDropProduct extends CommonBaseTest {

 

    @Test(priority = 31)

    public void DropAutcionScheduledAndWonDropProduct() throws Throwable {

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

 

        

        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript("window.open();");

        Thread.sleep(2000);

        //System.out.println(driver.getWindowHandles().size());

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));

        Thread.sleep(2000);

        driver.get("https://dev.betterthat.shop/login");

        Thread.sleep(2000);

        blp.enterBackendEmail("sreeja+admin@springdigital.com.au");

        blp.enterBackendPw("Sreeja@123");

        blp.loginBtnClick();

        Thread.sleep(3000);

        bdbp.DropAuction();

        Thread.sleep(2000);

        brdp.ScheduleDrop();

        Thread.sleep(2000);

        brpp.SelectRetailerField();

        Thread.sleep(2000);

 

        //brpp.ListOfRetailers();

 

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

        System.out.println("Done");

 

        /*

            brpp.ActionsBtn();

            Thread.sleep(2000);

            brpp.ScheduleDropAuctionbtn();

            */

            Thread.sleep(2000);

            sdap.FeaturedDropAuction();

            Thread.sleep(2000);

            sdap.DropAuctionDate();

            Thread.sleep(2000);

            sdap.DateSelected ();

            Thread.sleep(2000);

            sdap.DropAuction24HrsFormat();

            Thread.sleep(2000);

 

            // Define the time zone for Sydney

            ZoneId sydneyZone = ZoneId.of("Australia/Sydney");

 

            // Get the current time in Sydney

            ZonedDateTime sydneyTime = ZonedDateTime.now(sydneyZone);

            int hours=sydneyTime.getHour();

            System.out.println(hours);

            String hrs = Integer.toString(hours);

 

            // Define the date and time format

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

 

            // Format and print the Sydney time

            String formattedTime = sydneyTime.format(formatter);

            System.out.println("Current time in Sydney: " + formattedTime);

 

            sdap.getDropAuction24hrsFormatTextField().sendKeys(hrs);

            sdap.getDropAuction24hrsFormatTextField().sendKeys(Keys.ENTER);

            Thread.sleep(2000);

 

            int minutesToAdd = 2;

 

            int minute = sydneyTime.getMinute() + minutesToAdd ;

            if (minute % 2 != 0) {

                minute++; 

            }

            String min = sydneyTime.withMinute(minute).format(formatter);

            System.out.println(min);

            JavascriptExecutor js = (JavascriptExecutor)driver;

            js.executeScript("window.scrollTo(0,100)", "");

            sdap.getDropAuctionAvailableSlotField().click();

            sdap.getDropAuctionAvailableSlotTextField().sendKeys(min);

            sdap.getDropAuctionAvailableSlotTextField().sendKeys(Keys.ENTER);

            Thread.sleep(2000);


            sdap.ScheduleAuctionBtn();

            Thread.sleep(500);

 

            String confirmation = sdap.PopUpMessage();

            if (confirmation.contains("Success")) {

                System.out.println("The Product is added to the Drop auction ");

                extentTest.log(Status.PASS, "The Product is Added to the DropAuction");

            }

            else {

                System.out.println("The Product is  not added to the Drop auction ");

                extentTest.log(Status.FAIL, "The Product is  not Added to the DropAuction");

            }

 

            bdbp.DropAuction();

            Thread.sleep(2000);


            brdp.ProducName();

            Thread.sleep(4000);

            /*

             String pdName = brdp.ProducName();

            if (pass==(pdName)) {

                System.out.println("The Product Added to The Drop Auction is Same");

 

            }

            else {

                System.out.println("The Product Added to the Drop Auction is  not Same");

            }

         */

            driver.switchTo().window(tabs.get(0));

 

            Thread.sleep(2000);

            mrp.popUpCloseButton();

            Thread.sleep(2000);

            bhp.DropAuctionBtn();

            Thread.sleep(2000);

            dap.ScrollUntilTheElement(driver);

            Thread.sleep(2000);

            dap.ProductImage();

            Thread.sleep(2000);

            //scrollBarAction(driver);

            js.executeScript("window.scrollTo(0,700)", "");

            Thread.sleep(2000);

            /*

                dapdp.AttributeSelection();

                System.out.println("Element not found proceed further");

            //Thread.sleep(4000);

            //dapdp.MaterailAtt();

            Thread.sleep(2000);

             */


            dapdp.JoinTheDrop();

 

            Thread.sleep(4000);

            cop.clickLoginBtn();

 

            String signInmail = "jisha@springdigital.com.au";

            String signInPassword ="Bt@2023";

            sip.enterSingInEmail(signInmail);

            extentTest.log(Status.INFO, "SinginEmail Entered:  "+signInmail);

            sip.enterSingInPwd(signInPassword);

            extentTest.log(Status.INFO, "Password:  "+"*******");

            sip.btnClick();

            Thread.sleep(4000);

            //scrollBarAction(driver);



            cop.addCardDetails();//Adding Card Details 

            Thread.sleep(3000);


            js.executeScript("window .scrollTo(0,-600)", "");

            Thread.sleep(3000);

            cop.DeliveryOptions();

            Thread.sleep(3000);

 

            /*

            cop.DobTextFld();

            js.executeScript("window .scrollTo(0,100)", "");

            Thread.sleep(3000);

            cop.SelectYearDrpDwn();

            Thread.sleep(3000);

            cop.DobCheckBox();

            Thread.sleep(1000);

            */

            webDriverUtility.scrollBarAction(driver);

            Thread.sleep(3000);

            cop.ChangeOfMindCheckBox();

            Thread.sleep(3000);

            cop.JoinTheDropBtn();

            Thread.sleep(5000);

 

            cop.clickBuyNow();

            Thread.sleep(5000);

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

 

 