
package script;

import java.util.List;


import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.CommonBaseTest;

import generic.WebDriverUtility;

import page.AddtoBagePage;

import page.BtHomepage;

import page.CategoryPopUpPage;

import page.CheckOutGuestPage;

import page.CheckOutPage;

import page.MultiRetailerGridPage;

import page.StoresNamePage;

import page.ThankYouPage;

import page.WhislistPage;

 

public class CompleteCheckOutThroughStoreForGuestUser extends CommonBaseTest {

 

    @Test(priority = 28)

    public void CompleteCheckOutFromStoreViaGuestUser() throws Throwable {

        BtHomepage bhp = new BtHomepage(driver);

        MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);

        WhislistPage wlp = new WhislistPage(driver);

        CategoryPopUpPage cpp = new CategoryPopUpPage(driver);

        StoresNamePage snp = new StoresNamePage(driver);

        AddtoBagePage atb = new AddtoBagePage(driver);

        CheckOutPage cop = new CheckOutPage(driver);

        CheckOutGuestPage cogp = new CheckOutGuestPage(driver);

        ThankYouPage typ = new ThankYouPage(driver);

        WebDriverUtility webDriverUtility = new WebDriverUtility();

 

        String title = driver.getTitle();

        System.out.println(title);

        mrp.popUpCloseButton();//Handling The popup

        bhp.StrsBtn();//Clicking on the Stores Name from the Category

        Thread.sleep(2000);

        snp.RetaileStr(); //Click on the First Retailers from the Stores Name

        Thread.sleep(4000);


        //Validating for the StoreGrid Page

        String breadcum = mrp.getBreadCrum().getText();

        if (breadcum.contains("ABC")) {

            System.out.println("Store Grid Page");

            extentTest.log(Status.PASS, "We have Successfully Navigated to Store Grid Page");

        }

 

        JavascriptExecutor js = (JavascriptExecutor) driver;

        webDriverUtility.scrollBarAction(driver); //Scroll the page

        Thread.sleep(3000);

 

        WebElement element = driver.findElement(By.xpath("//div[@class='listing_productImage__dR7Sj']/span/img"));

        Actions action = new Actions(driver);

        action.moveToElement(element).perform();

        String productNameOnGridPage=mrp.getGridProduct_name();

 

        mrp.clickAddtoBagBtn(); // Click on the Add to Bag Button

        Thread.sleep(1000);


        atb.clickATBPopUpBtn(); //Click on Add to Bag from the PopUp

        System.out.println("Item added to cart successfully");

        Thread.sleep(3000);

        extentTest.log(Status.PASS, "Test pass: Item added to cart successfully");

 

        //Validating the Cart Count

        boolean cartCount = bhp.getCartImgNum();

        if(cartCount) {

            extentTest.log(Status.INFO, "Test Pass: Bag icon count on top is one");

        }

        else

        {

            extentTest.log(Status.FAIL, "Test Fail: There is a mismatch observed in the bagicon number");

        }

 

        bhp.clickCartImg();

        String cpn = cop.getCheckoutProdName();

        extentTest.log(Status.INFO, "The product added to cart is: "+cpn);


        bhp.CheckOutBtn(); //Click on the CheckOut Button from the page

        Thread.sleep(3000);

 

        String productName = cop.ProdutcNameOnCheckout();

        String productPrice = cop.productPriceonCheckOut();

 

        //Validating the User is Guest User or Logged In user

        String text = driver.findElement(By.xpath("//div[@class='notlogin_checkoutLogged__Vc9O8']")).getText();

        if (text.contains("Continue as a guest")) {

            System.out.println("The User is GusetUser to buy the product Click on Continue as a guest button");

            extentTest.log(Status.PASS, "The User is GuestUser...");

        }

        else {

            extentTest.log(Status.FAIL, "The User is Logged In User...");

        }

 

        cop.ContinueGuestBtn(); //Click on Continue as Guest Button


        cogp.FillTheDetails(); //Adding all the details of the Guest user

        //cogp.ProceedcheckOutBtn();

        Thread.sleep(2000);

        //js.executeScript("window.scrollBy(0,600)");


        //cogp.CheckBox();

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@class='custom-check checkout_checkBox__cEq8q']//span"))).click();

        //wait.until(ExpectedConditions.elementToBeClickable(cogp.getCheckBox())).click();

 

        //cogp.ProceedcheckOutBtn();

 

        String deliverymessage=driver.findElement(By.xpath("//p[@class='checkout_messageBelow__mnju7']")).getText();

        System.out.println(deliverymessage);

        if (deliverymessage.contains("Delivery options will be displayed once you add an address below.")) {

            System.out.println("The GuestUser need to Add the Address for the Checkout");

            extentTest.log(Status.PASS, "The Guestuser need to Add the Address for the Checkout");

        }

        else {

            extentTest.log(Status.FAIL, "The User is not an GuestUser");

        }

 

        //Verifying the ProductName both on Grid page and Checkout Page

        if (productNameOnGridPage.contains(productName)) {

            System.out.println("The product is correct in the checkoutpage");

            extentTest.log(Status.PASS, "The name of the product is same on both the pages");

        }

        else {

            extentTest.log(Status.FAIL, "The product are different");

        }


        //Thread.sleep(3000);

        cop.GCDropDown();

        Thread.sleep(3000);

 

        js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(3000);

        cop.AddAddressBtn();

 

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='order_groupPosition___wsch'])[2]"))).click();

        cop.AddressTextField();

 

        Thread.sleep(2000);

        String location = "albert";

        cop.EnterAddress(location);

        Thread.sleep(2000);

 

        cop.AddressForGuestUser();

        js.executeScript("window.scrollBy(0,300)");

        Thread.sleep(3000);

 

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='order_deliverFormBlock__mqo_q']/button"))).click();

        //cop.SaveBtnAdrsGU();

        Thread.sleep(2000);

 

        js.executeScript("window.scrollTo(0,-300)","");

        cop.addCardDetails();

        Thread.sleep(3000);

 

        js.executeScript("window.scrollBy(0,-800)");

        String gcAmount = cop.GCAmtOnCkOt();

        Thread.sleep(5000);

        //Verifying the Delivery options are there or not

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='checkout_deliveryOption__BBwkU'] //span[@class='checkout_radioHd__fXp1h']"));

        System.out.println(list.size());

        if (list.size()!=0) {

            System.out.println("The Delivery Options Are Present");    

        }

        else {

            System.out.println("The Delivery Options Are Not Present");

        }

        //driver.navigate().refresh();

        //Thread.sleep(2000);

        //Clicking on the Delivery options that are present

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

        js.executeScript("window.scrollBy(0,1000)","");

        Thread.sleep(2000);

 

        //js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

 

        cop.PlaceOrderBtn();//Click on the Place Order button

        //wait.until(ExpectedConditions.elementToBeClickable(cop.getPlaceOrderBtn())).click();

 

        Thread.sleep(4000);

 

        //Validating for the Thank you page

        String thankpageurl = driver.getCurrentUrl();

        if (thankpageurl.contains("thankyou")) {

            System.out.println("The User has purchased the item Successfully");

            extentTest.log(Status.PASS, "The User purchased the item Successfully");

        }

        else {

            System.out.println("The user is not purchased the item");

            extentTest.log(Status.FAIL, "The user is not purchased the item");    

        }

        typ.VerifyPage();

 

        js.executeScript("window.scrollBy(0,400)");

 

        //Validating the Product Name for both in Checkout page and in the thankyou page

        String thankpageProductName = typ.ProductName();

        if (productName.contains(thankpageProductName) ) {

            System.out.println("The product in the ThankYou Page is Same as the product in the CheckoutPage");

            extentTest.log(Status.PASS, productName +"  -:The productName in the ThankYou Page is Same as the productName in the CheckoutPage:-  "+ thankpageProductName);

        }

        else {

            extentTest.log(Status.FAIL, "The ProductName is different in Thankyou Page ");

        }

 

        //Validating the Product Price for both in Checkout page and in the thankyou page

        String thankpageProductPrice = typ.ProductPrice();

        if (productPrice.contains(thankpageProductPrice) ) {

            System.out.println("The productPrice in the ThankYou Page is Same as the productPrice in the CheckoutPage");

            extentTest.log(Status.PASS, productPrice +"  -:The productPrice in the ThankYou Page is Same as the productPrice in the CheckoutPage:-  "+ thankpageProductPrice);

        }

        else {

            extentTest.log(Status.FAIL, "The ProductPrice is different in Thankyou Page ");

        }

        js.executeScript("window.scrollBy(0,800)");

 

        //Validating the GC amount for both in Checkout page and in the thankyou page

        String thankpageGcamount = typ.GCAmount();

        if (gcAmount.contains(thankpageGcamount) ) {

            System.out.println("The GCAmount in the ThankYou Page is Same as the GCAmount in the CheckoutPage");

            extentTest.log(Status.PASS, gcAmount +"  -:The GCAmount in the ThankYou Page is Same as the GCAmount in the CheckoutPage:-  "+ thankpageGcamount);

        }

        else {

            extentTest.log(Status.FAIL, "The GCAmount is different in Thankyou Page ");

        }

    }

}
