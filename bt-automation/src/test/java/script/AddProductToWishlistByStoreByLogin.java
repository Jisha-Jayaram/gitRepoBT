package script;

 

import org.testng.Assert;

import org.testng.annotations.Test;

 

import com.aventstack.extentreports.Status;

 

import generic.BTExcel;

import generic.CommonBaseTest;

import generic.WebDriverUtility;

import page.BtHomepage;

import page.CategoryPopUpPage;

import page.MultiRetailerGridPage;

import page.SignInPage;

import page.StoresNamePage;

import page.WhislistPage;

 

public class AddProductToWishlistByStoreByLogin  extends CommonBaseTest{

 

    @Test(priority = 17)

    public void AddProductThroughStorePage() throws Throwable {

 

        try {

            BtHomepage bhp = new BtHomepage(driver);

            SignInPage signinpage = new SignInPage(driver);

            MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);

            WhislistPage wlp = new WhislistPage(driver);

            CategoryPopUpPage cpp = new CategoryPopUpPage(driver);

            StoresNamePage snp = new StoresNamePage(driver);

            WebDriverUtility webDriverUtility = new WebDriverUtility();

 

            mrp.popUpCloseButton();//Handling The popup

            bhp.myAccount_Mouseover(); //Mouse Hover on the My Account

            Thread.sleep(2000);

            signinpage.singInClick();//click on SignIn Button

            Thread.sleep(2000);

            String signInmail = BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",4,0);//Fetching the email Id from the excel sheet

            String signInPassword =BTExcel.getCellData(INPUTXL_PATH, "BTSingUp",4,3);//Fetching the password from the Excel sheet

            signinpage.enterSingInEmail(signInmail); //Passing the user name

            extentTest.log(Status.INFO, "SinginEmail Entered:  "+signInmail);

            signinpage.enterSingInPwd(signInPassword); //Passing the password

            extentTest.log(Status.INFO, "Password:  "+"*******");

            signinpage.btnClick();//clicking on login button

            extentTest.log(Status.PASS, "The User Logged In Successfully");

            Thread.sleep(4000);

 

            bhp.StrsBtn(); //Clicking on the Stores Name from the Category

            Thread.sleep(3000);

 

            snp.RetaileStr(); //Clcik on the First Retailers from the Stores Name

            Thread.sleep(2000);

 

            mrp.BreadCum(); //Validation for page

            extentTest.log(Status.PASS, "The user is on the MultiRetailer Store grid Page");

 

            webDriverUtility.scrollBarAction(driver); //Scroll the page

            Thread.sleep(2000);

 

            mrp.ClickOnWishListIcon(); //Clicking on the wishlist icon of the product

            extentTest.log(Status.PASS, "Name of the Product in the Grid page :- "+ mrp.getGridProduct_name());

 

            bhp.verifyTheWslImgNo();//Validating the Wishlist icon Number

            System.out.println("Item is added to the WishlistCart Successfully");

            bhp.WishList(); //Click on wishlist icon on the Page

            extentTest.log(Status.PASS, "Item added to WishlistCart successfully");

            Thread.sleep(2000);

 

            wlp.PageName();//Validating the Wishlist Page

            Thread.sleep(2000);

            extentTest.log(Status.PASS, "The User is on the WishList Page");

 

            webDriverUtility.scrollBarAction(driver);

 

            //Validation for the Product Name from both Grid page and the wishlist page

            wlp.getProductName();

            extentTest.log(Status.PASS, "Name of the Product in the Wishlist page :- "+ wlp.getProductName());

            if (mrp.getGridProduct_name().equals(wlp.getProductName()) ) {

                System.out.println("The added product to Whislist cart is Same");

                extentTest.log(Status.INFO, "The Item added to WishlistPage are same");

            }

            else {

                Assert.fail("The Product added to the Wishlist Cart are different please verify Once");

            }

 

            //Validating for the Logged In user or Guest User

            if (wlp.getAddToBag().isDisplayed()) {

                System.out.println("The user is Logged In User");

                extentTest.log(Status.PASS, "The User is Logged In User and ADD TO BAG button is present in the Wishlist page");    

            }

            else {

                System.out.println("The user is Logged Out User");

                extentTest.log(Status.FAIL, "The User is Logged Out user");

            }

 

            Thread.sleep(3000);

            driver.navigate().refresh();

            Thread.sleep(3000);

            wlp.RemoveAll();

        }

        catch (InterruptedException e) {

            System.out.println("The script might fail because of the Network issue");

            extentTest.log(Status.FAIL, "Caught into Error"+ e.getMessage());

        } 

    }

}
