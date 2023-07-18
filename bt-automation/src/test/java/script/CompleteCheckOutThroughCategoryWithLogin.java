package script;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

 

import generic.BTExcel;

import generic.CommonBaseTest;

import generic.WebDriverUtility;

import page.AddtoBagePage;

import page.BtHomepage;

import page.CategoryPopUpPage;

import page.CheckOutPage;

import page.MultiRetailerGridPage;

import page.SignInPage;

import page.StoresNamePage;

import page.ThankYouPage;

import page.WhislistPage;

 

public class CompleteCheckOutThroughCategoryWithLogin  extends CommonBaseTest{

    @Test(priority = 27)

    public void CheckoutThroughCategory() throws Throwable {

        BtHomepage bhp = new BtHomepage(driver);

        SignInPage signinpage = new SignInPage(driver);

        MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);

        StoresNamePage snp = new StoresNamePage(driver);

        CategoryPopUpPage cpp = new CategoryPopUpPage(driver);

        WhislistPage wlp = new WhislistPage(driver);

        CheckOutPage cop = new CheckOutPage(driver);

        AddtoBagePage atb = new AddtoBagePage(driver);

        ThankYouPage typ = new ThankYouPage(driver);

        WebDriverUtility webDriverUtility = new WebDriverUtility();

 

        bhp.myAccount_Mouseover(); //Mouse Hover on the My Account

        Thread.sleep(1000);

        signinpage.singInClick(); //Click on the Sign In Button

        Thread.sleep(2000);

        String signInmail = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",4,0);//Fetching the email Id from the excel sheet

        String signInPassword =BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",4,3);//Fetching the password from the Excel sheet

        signinpage.enterSingInEmail(signInmail); //Passing the user name

        extentTest.log(Status.INFO, "SinginEmail Entered:  "+signInmail); //Passing the password

        signinpage.enterSingInPwd(signInPassword); extentTest.log(Status.INFO,"Password:  "+"*******");

        signinpage.btnClick();//clicking on login button

        extentTest.log(Status.PASS, "The User Logged In Successfully");

        Thread.sleep(3000);

 

        bhp.CategoryBtn(); //Click on the Category from the Home Page

        Thread.sleep(2000);

        cpp.ViewAllBtn(); //Click on View All Button

        Thread.sleep(3000);

 

        String breadcum = mrp.getBreadCrum().getText();

        System.out.println(breadcum);

        extentTest.log(Status.PASS, "The User is on the Categories Page");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        webDriverUtility.scrollBarAction(driver); //Scroll the page

        Thread.sleep(3000);

        //Mouse Hover On the product on Grid page

        WebElement element = driver.findElement(By.xpath("//div[@class='listing_productImage__dR7Sj']/span/img"));

        Actions action = new Actions(driver);

        action.moveToElement(element).perform();

 

        mrp.clickAddtoBagBtn(); // Click on the Add to Bag Button

        Thread.sleep(1000);

 

        atb.clickATBPopUpBtn(); //Click on Add to Bag from the PopUp

        System.out.println("Item added to cart successfully");

        Thread.sleep(2000);

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

 

        //bhp.clickCartImg();

        //String cpn = cop.getCheckoutProdName();

        //extentTest.log(Status.INFO, "The product added to cart is: "+cpn);

 

        bhp.CheckOutBtn(); //Click on the CheckOut Button from the page

        Thread.sleep(3000);

 

        String productName = cop.ProdutcNameOnCheckout();

 

        String productPrice = cop.productPriceonCheckOut();

 

        //Validating for the CheckOut Page

        String checkouturl = driver.getCurrentUrl();

        System.out.println(checkouturl);

        if (checkouturl.contains("checkout")) {

            System.out.println("The user is in the CheckOut page");

            extentTest.log(Status.PASS, "The User is in the CheckOut Page ");

        }

        else {

            System.out.println("The user is not in the Checkout page");

            extentTest.log(Status.FAIL, "The User is not in the Checkout Page");

        }

 

        //Validating/checking whether the delivery options are present or not

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='checkout_deliveryOption__BBwkU'] //span[@class='checkout_radioHd__fXp1h']"));

        System.out.println(list.size());

        if (list.size()!=0) {

            System.out.println("The Delivery Options Are Present");    

        }

        else {

            System.out.println("The Delivery Options Are Not Present");

        }

 

        //Clicking on the Delivery options present on the Checkout page

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

 

        cop.ChangeGoodCauseBtn(); //Click on the Change GC Btn

        Thread.sleep(2000);

 

        cop.GCDropDown(); //Select the First GC from The DropDown

        Thread.sleep(2000);

 

        cop.addCardDetails(); //Adding the Card details in the Text fields

        Thread.sleep(3000);

 

        String gcAmount = cop.GCAmtOnCkOt(); //GC amount on the Checkout page

        js.executeScript("window.scrollBy(0,800)", "");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOf(cop.getPlaceOrderBtn()));

        cop.PlaceOrderBtn(); //Clicking on the Place Order Button

        Thread.sleep(2000);

 

        //Validating for the ThankYou page

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

            extentTest.log(Status.PASS, productName +"The productName in the ThankYou Page is Same as the productName in the CheckoutPage"+ thankpageProductName);

        }

        else {

            extentTest.log(Status.FAIL, "The Product is different in Thankyou Page ");

        }

 

        //Validating the Product Price for both in Checkout page and in the thankyou page

        String thankpageProductPrice = typ.ProductPrice();

        if (productPrice.contains(thankpageProductPrice) ) {

            System.out.println("The productPrice in the ThankYou Page is Same as the productPrice in the CheckoutPage");

            extentTest.log(Status.PASS, productPrice +"The productPrice in the ThankYou Page is Same as the productPrice in the CheckoutPage"+ thankpageProductPrice);

        }

        else {

            extentTest.log(Status.FAIL, "The Product is different in Thankyou Page ");

        }

 

        js.executeScript("window.scrollBy(0,700)");

        //Validating the GC amount for both in Checkout page and in the thankyou page

        String thankpageGcamount = typ.GCAmount();

        if (gcAmount.contains(thankpageGcamount) ) {

            System.out.println("The GCAmount in the ThankYou Page is Same as the GCAmount in the CheckoutPage");

            extentTest.log(Status.PASS, gcAmount +"The GCAmount in the ThankYou Page is Same as the GCAmount in the CheckoutPage"+ thankpageGcamount);

        }

        else {

            extentTest.log(Status.FAIL, "The GCAmount is different in Thankyou Page ");

        }

    }

}
