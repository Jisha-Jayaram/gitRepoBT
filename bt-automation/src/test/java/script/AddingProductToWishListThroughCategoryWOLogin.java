package script;

 

import java.time.Duration;

import java.util.List;

 

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;

import org.testng.annotations.Test;

 

import com.aventstack.extentreports.Status;

 

import generic.CommonBaseTest;

import generic.WebDriverUtility;

import io.reactivex.rxjava3.functions.Action;

import page.BtHomepage;

import page.CategoryPopUpPage;

import page.MultiRetailerGridPage;

import page.WhislistPage;

 

public class AddingProductToWishListThroughCategoryWOLogin extends CommonBaseTest {

 

    @Test(priority = 11)

    public void AddProductWithoutLogin() throws Throwable {

        try {

            BtHomepage bhp = new BtHomepage(driver);

            MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);

            CategoryPopUpPage cpp = new CategoryPopUpPage(driver);

            WhislistPage wlp = new WhislistPage(driver);

            WebDriverUtility webDriverUtility = new WebDriverUtility();

 

            List<WebElement> list = driver.findElements(By.xpath("//li[@class='dropdown-open links']"));

            for(WebElement categoryName : list) {

                //System.out.println(categoryName.getText());

            }

 

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

 

            bhp.HomeCategoryBtn(); //Click on the Category button

            Thread.sleep(2000);

 

            cpp.ViewAllBtn(); //Click on the View All Button

            Thread.sleep(2000);

 

            mrp.BreadCum(); //Get the text from the breadCum and verify the user is on the page

            Thread.sleep(2000);

 

            webDriverUtility.scrollBarAction(driver);

            Thread.sleep(2000);

 

            mrp.ClickOnWishListIcon(); //Click on the Wishlist icon Button

            extentTest.log(Status.PASS, "Name of the Product in the Grid page :- "+ mrp.getGridProduct_name());

 



            String productNameOnGridPAge=mrp.getGridProduct_name(); //fetching the product name from the grid page

 

            bhp.verifyTheWslImgNo(); //Verifying the wishlist number

            System.out.println("Item is added to the WishlistCart Successfully");

            extentTest.log(Status.PASS, "Item added to Wishlis Page successfully");

 

            bhp.WishList(); //Click on the wishlist icon

            Thread.sleep(2000);

            extentTest.log(Status.PASS,"The product in the Wislist page is Only One");

 

            wlp.PageName(); //validation for the page

            Thread.sleep(2000);

 

            String productNameOnWishListPage =wlp.getProductName(); //Fetching the product name from the wishlist page

            extentTest.log(Status.PASS, "Name of the Product in the Wishlist page :- "+ wlp.getProductName());

 

            webDriverUtility.scrollBarAction(driver); //scrolling the page

 

            //Verifying the product name on wishlist and grid page

            if (productNameOnWishListPage.contains(productNameOnGridPAge) ) {

                System.out.println("The added product to Whislist cart is Same");

                extentTest.log(Status.INFO, "The Item added to Wislist Page are same");

            }

            else {

                System.out.println("The added product to Whislist cart is Different");

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
