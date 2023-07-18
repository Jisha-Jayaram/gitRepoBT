package script;

import java.awt.Robot;

import java.awt.event.InputEvent;

import java.time.Duration;

import java.util.List;

import java.util.Set;

 

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import org.testng.annotations.Test;

 

import com.aventstack.extentreports.Status;

 

import generic.CommonBaseTest;

import generic.WebDriverUtility;

import io.reactivex.rxjava3.functions.Action;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

import page.BtHomepage;

import page.MultiRetailerGridPage;

import page.WhislistPage;

 

public class AddProductToWhislistSearchWOLogin extends CommonBaseTest{

    //Adding

 

    @Test(priority = 9)

    public void AddProductBySearch() throws Throwable {

 

        try {

            BtHomepage bhp = new BtHomepage(driver);

            MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);

            WhislistPage wlp = new WhislistPage(driver);

            WebDriverUtility webDriverUtility = new WebDriverUtility();

 

            bhp.PassValue();//passing the values in the search text field

            String CurrentPageTitle = driver.getTitle();

            System.out.println(CurrentPageTitle);

            wait.until(ExpectedConditions.titleContains(CurrentPageTitle));

            extentTest.log(Status.INFO, "The user is on the Searched product page");

 

            mrp.BreadCumBySearch();//Fetching the heading from the breadCum

            Thread.sleep(2000);

 

            mrp.ClickOnWishListIcon(); //Clicking on the first Wishlist Icon of product

            extentTest.log(Status.PASS, "Name of the Product in the Grid page :- "+ mrp.getGridProduct_name());

            System.out.println("Item is added to the WishlistCart Successfully");

            Thread.sleep(2000);

            extentTest.log(Status.PASS, "Item added to WishlistCart successfully");

 

            bhp.WishList();//click on wishlist icon on page

            Thread.sleep(2000);

 

            bhp.verifyTheWslImgNo(); //Fetching the no of the products in the wishlist page

            extentTest.log(Status.PASS,"The product in the Wishlistpage is Only One");

 

            String currentUrl = driver.getCurrentUrl();

            //System.out.println(currentUrl);

            extentTest.log(Status.PASS, "The product is sucessfully in the Wishlist Page");

 

            wlp.PageName();

            Thread.sleep(2000);

 

            webDriverUtility.scrollBarAction(driver);

 

            wlp.getProductName();

            extentTest.log(Status.PASS, "Name of the Product in the Wishlist page :- "+ wlp.getProductName());

            if (mrp.getGridProduct_name().equals(wlp.getProductName()) ) {

                System.out.println("The added product to Whislist cart is Same");

                extentTest.log(Status.INFO, "The Item added to Wishlist page are same");

                extentTest.log(Status.PASS, mrp.getGridProduct_name() + "-: The product from the grid page and the product from the wishlist page are same :-" + wlp.getProductName());

            }

            else {

                Assert.fail("The Product added to the Wishlist Cart are different please verify Once");

            }

 

            if (wlp.getLoginToBuyBtn().isDisplayed()) {

                System.out.println("The user is Logged Out User");

                extentTest.log(Status.PASS, "The User is Logged Out User and Login to Buy button is present in the Wishlist page");    

            }

            else {

                System.out.println("The user is Logged In User");

                extentTest.log(Status.FAIL, "The User is Logged In user");

            }

            Thread.sleep(4000);

        } 

        catch (InterruptedException e) {

            System.out.println("The script might fail because of the Network issue");

            extentTest.log(Status.FAIL, "Caught into Error"+ e.getMessage());

 

        } 

    }

 

}
