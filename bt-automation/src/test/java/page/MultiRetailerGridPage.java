package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
* @author shaik
*
*/
   public class MultiRetailerGridPage {
	   
	 @FindBy(xpath ="//div[@class='listing_listingCardInner__LwnDd']//h3" ) 
	 private WebElement GridProduct_name;
	   
	//Initilization
	 @FindBy(xpath = "(//div[@class='customCol false']//img[@alt='heart'])[1]") 
	 private WebElement firstHeart;
	 
	 @FindBy(xpath = "//div[@class='listing_productImage__dR7Sj']/span/img") 
	 private WebElement first_Product;
	 
	 @FindBy(xpath = "//button[.='View More']")
	 private WebElement viewMoreBtn;
	 
	 @FindBy(xpath = "//button[.='Add to Bag']")
	 private WebElement AddtoBagBtn;
	
	 public WebElement getAddtoBagBtn() {
		return AddtoBagBtn;
	}

	public void setAddtoBagBtn(WebElement addtoBagBtn) {
		AddtoBagBtn = addtoBagBtn;
	}

	@FindBy(xpath = "//div[@class = 'listing_listingCardInfo__5JhvL']/h3")
	 private WebElement gridProduct_name;
	 
	 @FindBy(xpath = "//div[@class='modal-content RegisterLogin_removePadding__jhYc2 RegisterLogin_modalContent__72Mzt']//button[@class='close']") 
	 private WebElement popUpCloseBtn;
	 
	 @FindBy(xpath ="//div[@class='container']/ul/li[2]")
	 private WebElement bredcrumbsmaster;  
	 
	 @FindBy(xpath ="//div[@class='container']/ul/li[3]")
	 private WebElement breadcrumbsparent;
	 
	 @FindBy(xpath = "//div[@class='container']//ul[contains(@class,'breadcums listing')]") 
	 private WebElement BreadCrum;
	 
	 @FindBy(xpath = "(//div[@class='listing_mainPrice__HXoxo']//span/span)[2]") 
	 private WebElement gridProduct_Price;
	 
	 @FindBy(xpath = "//div[@class='listing_heading__vnuhY']//b")private WebElement breadCumBySearch;

	public MultiRetailerGridPage(WebDriver driver) {
	
	      PageFactory.initElements(driver, this);
     }
	
	public WebElement getBreadCrum() {
        return BreadCrum;
    }
	
	public String getGridProduct_Price() {
        String priceOnMultiRetailerPage =gridProduct_Price.getText();
        System.out.println(priceOnMultiRetailerPage);
        return priceOnMultiRetailerPage;
    }
	
	public void ViewMoreBtn() {
        viewMoreBtn.click();
    }
	
	public void BreadCumBySearch() {
        String value = breadCumBySearch.getText();
        if (value.contains("toys")) {
            System.out.println("The user is on the Particular search Grid page");
        }
        else {
            System.out.println("The user is on the different page");
        }
    }
//Moving to fist product
		public WebElement getFirst_Product() throws Throwable {
			
			//Actions actions = new Actions(driver);
			//actions.moveToElement(first_Product).perform();  
			//Thread.sleep(2000);
			return first_Product;
		}
		
//Getting first product name	 
		 public String getGridProduct_name() {
			String grid_Prod_Name = gridProduct_name.getText();
			//System.out.println("The first product in the grid page and added to cart is : "+grid_Prod_Name);
			return grid_Prod_Name;
		}
//Return wishlist element
     public WebElement addWishlist() {
	
      	return firstHeart;
	}
//Clicking view more button from grid page for the first product     
     public WebElement getViewMoreBtn() {
    	 
    	viewMoreBtn.click();
 		return viewMoreBtn;
 	}
//Clicking Add to bag button from the grid page for the first product
 	public WebElement clickAddtoBagBtn() throws Throwable {
 		
 		AddtoBagBtn.click();
 		Thread.sleep(2000);
		return AddtoBagBtn;
	}
 	
 	public WebElement AddtoBagBtn() {
 		return AddtoBagBtn;
 	}
//Clicking on Wishlist icon from grid page for the first product
     public void ClickOnWishListIcon()
      {
    	 firstHeart.click(); 
      }

	 
//Clicking close button from Signup pop-up
	 public void popUpCloseButton() {
		 popUpCloseBtn.click();
	 }
	 
	//Category grid breadcrumbs

	public String getBredcrumbsmaster() 
	{
		String breadcrumbsmastertxt = (bredcrumbsmaster.getText()).toLowerCase();
		
		return breadcrumbsmastertxt;
	}
	
	public String getBredcrumbsparent() 
	{
		String breadcrumbsparenttxt = (breadcrumbsparent.getText()).toLowerCase();
		return breadcrumbsparenttxt;
	}
	
	public void BreadCum() {
		
        String value = BreadCrum.getText();
        if (value.contains("Home")) {
            System.out.println("The user is on the MultiRetailer Category Grid page");
        }
        else {
            System.out.println("The user is not on the MultiRetailer Category Grid page");

        }
    }
	
	public String getGridProductname() {
        String nameOnMultiRetailerPage = GridProduct_name.getText();
        System.out.println(nameOnMultiRetailerPage);

 

        try {
            if (nameOnMultiRetailerPage.contains("...")==true) {
                nameOnMultiRetailerPage = nameOnMultiRetailerPage.replaceAll("[^a-zA-Z0-9]", " ");
                nameOnMultiRetailerPage = nameOnMultiRetailerPage.trim();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

 

        return nameOnMultiRetailerPage;
    }

}