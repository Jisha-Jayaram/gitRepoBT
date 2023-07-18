/**

* 

*/

package page;

 

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

 

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

 

/**

* @author shaik

*

*/

public class WhislistPage {

 

    public WhislistPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

 

    @FindBy(xpath = "//div[@class='listing_listingCardInner__LwnDd']//h3")

    private WebElement productNameOnWishListPg;


    @FindBy(xpath = "//div[@class='customCol wishlistCOl']//button[text()='REMOVE']")

    private WebElement RemoveBtn;


    @FindBy(xpath = "//div[@class='customCol wishlistCOl']")

    private WebElement EntirePage;


    @FindBy(xpath = "//div[@class='listing_heading__vnuhY']//h1") 

    private WebElement pageName;


    @FindBy(xpath = "//button[@class='listing_btnCustom__cbLGx listing_btn_type1__kSMy2 px-3 w-auto overcastBtn']")

    private WebElement removeAllBtn;


    @FindBy(xpath = "//ul[@class='breadcums padding-top d-flex align-items-center justify-content-center']")

    private WebElement wishlistBreadCum;


    @FindBy(xpath = "//button[@class='listing_btnCustom__cbLGx listing_btn_type2__QCFEf']")

    private WebElement addToBag;


    public WebElement getWishlistBreadCum() {

        return wishlistBreadCum;

    }

 

 

    public WebElement getAddToBag() {

        return addToBag;

    }

 

 

    public WebElement getAddToBagOnPopUp() {

        return addToBagOnPopUp;

    }

 

    @FindBy(xpath = "//button[@class='multi_btnCustom__iFH_4']") 

    private WebElement addToBagOnPopUp;


    @FindBy(xpath = "//button[text()='Login to Buy']")

    private WebElement loginToBuyBtn;

 



    public WebElement getRemoveAllBtn() {

        return removeAllBtn;

    }

 

 



    public WebElement getPageName() {

        return pageName;

    }

 

 

    public WebElement getRemoveBtn() {

        return RemoveBtn;

    }

 

    public WebElement getProductNameOnWishListPg() {

        return productNameOnWishListPg;

    }

 



    public WebElement getLoginToBuyBtn() {

        return loginToBuyBtn;

    }

 



    public String getProductName() {

        String ProductNameInWishlist = productNameOnWishListPg.getText();

        System.out.println("Product Name on the Wishlist Page :-" + ProductNameInWishlist);

        return ProductNameInWishlist;

    }

 

    public WebElement getEntirePage() {

        return EntirePage;

    }

 

    public void PageName() {

        String name=pageName.getText();

        if (name.contains("Shopping wishlist")) {

            System.out.println("The user is in the WishList Page");

        }

        else {

            System.out.println("The User is not in the Wishlist Page");

        }

    }

 

    public String wishListHeading() {

        String text = wishlistBreadCum.getText();

        System.out.println(text);

        return text;

 

    }

    public void RemoveBtn() {

        RemoveBtn.click();

    }

 

    public void AddToBagOnPopUp() {

        addToBagOnPopUp.click();

    }

    public void AddToBag() {

        addToBag.click();

    }

    public String getText() {

        String value = EntirePage.getText();

        System.out.println(value);

        return value;

    }

    public void RemoveAll() {

        removeAllBtn.click();

    }

 

 



}
