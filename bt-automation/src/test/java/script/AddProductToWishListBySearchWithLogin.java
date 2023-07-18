
package script;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.CommonBaseTest;

import page.BtHomepage;

import page.MultiRetailerGridPage;

import page.SignInPage;

import page.WhislistPage;
/**
* @author Zabi
*
*/
public class AddProductToWishListBySearchWithLogin extends CommonBaseTest {

    @Test(priority = 10)

    public void AddProductWithLogin() throws Throwable {

        BtHomepage bhp = new BtHomepage(driver);

        SignInPage signinpage = new SignInPage(driver);

        MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);

        WhislistPage wlp = new WhislistPage(driver);

        bhp.myAccount_Mouseover();

        Thread.sleep(2000);

        signinpage.singInClick();

        Thread.sleep(2000);

        String signInmail = "jisha@springdigital.com.au";

        String signInPassword ="Bt@2023";

        signinpage.enterSingInEmail(signInmail);

        extentTest.log(Status.INFO, "SinginEmail Entered:  "+signInmail);

        signinpage.enterSingInPwd(signInPassword);

        extentTest.log(Status.INFO, "Password:  "+"*******");

        signinpage.btnClick();

        extentTest.log(Status.PASS, "The User Logged In Successfully");

        Thread.sleep(5000);

        bhp.PassValue();

        //bhp.WishList();

        //wlp.RemoveBtn();

        mrp.ClickOnWishListIcon();

        extentTest.log(Status.PASS, "Name of the Product in the Grid page :- "+ mrp.getGridProduct_name());

        //mrp.getGridProductName();

        bhp.verifyTheWslImgNo();

        System.out.println("Item is added to the WishlistCart Successfully");

        bhp.WishList();

        extentTest.log(Status.PASS, "Item added to WishlistCart successfully");

        Thread.sleep(2000);

        wlp.getProductName();

        extentTest.log(Status.PASS, "Name of the Product in the Wishlist page :- "+ wlp.getProductName());

        if (mrp.getGridProduct_name().equals(wlp.getProductName()) ) {

            System.out.println("The added product to Whislist cart is Same");

            extentTest.log(Status.INFO, "The Item added to WishlistPage are same");

        }

        else {

            Assert.fail("The Product added to the Wishlist Cart are different please verify Once");

        }

 

        //    wlp.RemoveBtn();

        //ValidSignIn valid = new ValidSignIn();// Instaed of Writting the Valid Sign in Steps I need just to call the method of that page

        //        System.out.println(valid);

        //        valid.testValidSignIn();


        String values = wlp.getText();

        if (values.contains("ADD TO BAG")) {

            System.out.println("The user is Logged IN User");

            extentTest.log(Status.PASS, "The User is Logged In User and Add To Bag button is present in the Wishlist page");

        }

        else {

            System.out.println("The user is LoggedOut User");

            extentTest.log(Status.FAIL, "The User is LoggedOut user");

        }

    }

}
