
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

import page.ProductDetailsPage;

/***

* 

* @author shaik

*

*/

public class ViewMoreButtonFunctionality  extends CommonBaseTest{

    @Test(priority = 20)

    public void ValidateViewMorebuttonFunctionalityOnProductPage() throws Throwable {


        BtHomepage bhp = new BtHomepage(driver);

        CategoryPopUpPage cpp = new CategoryPopUpPage(driver);

        MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);

        AddtoBagePage atb = new AddtoBagePage(driver);

        CheckOutGuestPage cogp = new CheckOutGuestPage(driver);

        ProductDetailsPage pdp = new ProductDetailsPage(driver);

        WebDriverUtility webDriverUtility = new WebDriverUtility();

 

        Thread.sleep(5000);

        mrp.popUpCloseButton(); //Handling the popUp


        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bhp.getLastElementOfPage());

        Thread.sleep(3000);

        bhp.SelectTheCountry(); //Selecting the country by scrolling

        Thread.sleep(2000);


        bhp.BetterThatImg(); //Clicking on the Better That Image on Page

        Thread.sleep(2000);


        bhp.CategoryBtn(); //Navigating through the category 

        Thread.sleep(2000);


        cpp.ViewAllBtn(); //Click on View All Button

        Thread.sleep(4000);

 

        mrp.BreadCum();

        webDriverUtility.scrollBarAction(driver);

        String productNameOnGridPage = mrp.getGridProduct_name();

        String productPriceOnGridPage = mrp.getGridProduct_Price();


        String url = driver.getCurrentUrl();

        if (url.contains("products")) {

            System.out.println("The User is in the MultiRetailer Grid Page");

        }

        else {

            System.out.println("The User is not in the MultiRetailer Grid page");

        }

 

        WebElement ele = mrp.getFirst_Product();

        wait.until(ExpectedConditions.visibilityOf(ele));

        webDriverUtility.mouseOverAnElement(driver, ele); //Mouse Hover on the First Product

        Thread.sleep(3000);


        mrp.ViewMoreBtn(); //Click on View More Button

        Thread.sleep(2000);


        String cururl = driver.getCurrentUrl();

        if (cururl.contains("product")) {

            System.out.println("The User is in the Product Details page");

        }

        else {

            System.out.println("The user is not in the Product Details page");

        }


        webDriverUtility.scrollBarAction(driver);

        Thread.sleep(3000);

 

        String text = pdp.AddToBag();

        if (text.contains("Add to Bag")) {

            System.out.println("The user is the product details page");

            extentTest.log(Status.PASS, "The User is in the Product Details page");

        }

        else {

            extentTest.log(Status.FAIL , "The User is  not in the Product Details page");

        }

        //pdp.Details();

        String opt = pdp.Details();

        if (opt.contains("The Details")||opt.contains("Shipping/Delivery")||opt.contains("Returns")) {

            System.out.println("The User is in the product details Page");

        }

        else {

            System.out.println("The User is not in the Product details page");

        } 


    }

 

}
