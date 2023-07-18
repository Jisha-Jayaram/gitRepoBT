package script;

 

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

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

import page.MultiRetailerGridPage;

import page.WhislistPage;

/***

* 

* @author shaik

*

*/

public class VerifyingTheProductNameandPriceOnCheckOut extends CommonBaseTest {

    @Test(priority = 21)

    public void ValiadtePricaAndNameOnCheckout() throws Throwable {

        BtHomepage bhp = new BtHomepage(driver);

        CategoryPopUpPage cpp = new CategoryPopUpPage(driver);

        MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);

        AddtoBagePage atb = new AddtoBagePage(driver);

        CheckOutGuestPage cogp = new CheckOutGuestPage(driver);

        WebDriverUtility webDriverUtility = new WebDriverUtility();

 

        Thread.sleep(4000);

        mrp.popUpCloseButton(); // Close the popup


        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bhp.getLastElementOfPage());

        Thread.sleep(2000);

        bhp.SelectTheCountry(); //Select the country

        Thread.sleep(1000);


        bhp.BetterThatImg(); //Click on Better that Image

        Thread.sleep(1000);


        bhp.CategoryBtn(); //Click on the Category

        Thread.sleep(1000);


        cpp.ViewAllBtn(); //Click on View All Button

        Thread.sleep(2000);

 

        mrp.BreadCum();//naviagted to MultiReatiler Grid page through Category

        webDriverUtility.scrollBarAction(driver); //Scrolling the page

        String productNameOnGridPage = mrp.getGridProduct_name();

        String productPriceOnGridPage = mrp.getGridProduct_Price();


        WebElement ele = mrp.getFirst_Product();

        wait.until(ExpectedConditions.visibilityOf(ele));

        webDriverUtility.mouseOverAnElement(driver, ele); //Mouse Hover on the First Product

        Thread.sleep(3000);

 

        mrp.clickAddtoBagBtn(); //Click on Add to Bag button on product

        Thread.sleep(2000);

 

        atb.clickATBPopUpBtn();

        extentTest.log(Status.PASS, "Test pass: Item added to cart successfully");

        Thread.sleep(3000);


        bhp.CheckOutBtn(); //click on CheckOut Button

        Thread.sleep(4000);

 

        //Validation on Checkout for the price and product name

        String productNameOnCheckoputPage = cogp.ProductNameOnCheckoutasGuest();

        if (productNameOnCheckoputPage.contains(productNameOnGridPage)) {

            System.out.println("The Product Name is same on both GridPage and Checkout Page");

            extentTest.log(Status.PASS , "The Product name is Same on Both The Pages");

        }

        else {

            System.out.println("The Product Name is different on both GridPage and Checkout Page");

            extentTest.log(Status.PASS , "The Product name is different on Both The Pages");

        }

 

        String produtcPriceOnCheckoutPage = cogp.productPriceOnCheckoutasGuest();

        if (produtcPriceOnCheckoutPage.equals(productPriceOnGridPage)) {

            System.out.println("The Product Price is same on both GridPage and Checkout Page");

            extentTest.log(Status.PASS , "The Product price is Same on Both The Pages");

        }

        else {

            System.out.println("The Product Price is different on both GridPage and Checkout Page");

            extentTest.log(Status.PASS , "The Product price is different on Both The Pages");

        }


    }

}
