package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


/**
* @author Jisha Jayaram
*
*/
public class BtHomepage {

	@FindBy(xpath="//*[@id=\"top-header\"]//span[@class='Header_userNameClass__nl8jn']") 
	private WebElement My_Account;

	@FindBy(xpath="//input[@class=\"Header_searchInpt__fss7F\"]") private WebElement SearchTextField;

	@FindBy(xpath = "//button[contains(text(),\"Show all results\")]") private WebElement ShowAllResultBtn;

	@FindBy(xpath = "//img[@src='/img/heart-icon-res.png']") private WebElement WishlistIconBtn;

	@FindBy(xpath="//span[text()='SIGN OUT']") 
	private WebElement Logout;
	
	@FindBy(xpath="//span[@class='Header_shopingCart__ruMS3']")
	private WebElement cartImgNum;
	
	@FindBy(xpath = "//div[@class='Header_navigation__zOzB9']//a[text()='Stores']")
	private WebElement StoreElement;
	
	@FindBy(xpath = "//span[@class='Header_shopingCart__ruMS3 Header_shopingCartOption__ATOrL']") 
	private WebElement WslImgNo;
	
	@FindBy(xpath = "//li[@class='dropdown-open links']//span[text()='Home & Livings']") 
	private WebElement HomeAndLivingBtn;
	
	@FindBy(xpath = "//div[@class = 'Header_navigation__zOzB9']/ul/li[2]/span")
	private WebElement Mastercattwo;
	
	@FindBy(xpath ="//div[1][@class='Header_navOuterBlock__zy1hY']/a")
	private WebElement parentcatone;
	
	@FindBy(xpath = "//div[@class='Header_navigation__zOzB9']//a[@href='/drop-auctions']") 
	private WebElement dropAuctionBtn;
	
	@FindBy(xpath ="//div[@class='Header_menuOuter__Ny2aw']//a[text()='Stores']" ) 
	private WebElement StoresBtn;
	
    @FindBy(xpath = "//div[@class='Header_headerRightBlock__XqwMS']//a[@href='/checkout']") 
    private WebElement checkOutBtn;
    
    @FindBy(xpath = "//ul[@class='Header_openSubNav__R9QSv']//a[@href='/my-account']") 
    private WebElement myAccount;
    
    @FindBy(xpath = "//div[@class='Header_logo__vYddb']//img[@class='Header_logoImage__D9BH9']") 
    private WebElement betterThatImg;
    
    @FindBy(xpath = "//div[@class='Header_navigation__zOzB9']//li[7]") 
    private WebElement categoryBtn;
    
    @FindBy(xpath = "//a[@href='/my-good-cause']") 
    private WebElement gcName;
    
    @FindBy(xpath = "//div[@class='Footer_newsletterBlock__kWwTv']") 
    private  WebElement lastElementOfPage;
    
    @FindBy(xpath = "//div[@class='SelectDropdown_selectCountryCustom__lRiqY']") 
    private WebElement countryIcon;
    
    @FindBy(xpath = "//ul[@class='SelectDropdown_selectCountry__JwI18']//li") 
    private WebElement countrySelect;
    
	
	public BtHomepage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	public WebElement getMy_Account() {
		return My_Account;
	}

	public WebElement getSearchTextField() {
		return SearchTextField;
	}

	public WebElement getShowAllResultBtn() {
		return ShowAllResultBtn;
	}

	public WebElement getWishlistIconBtn() {
		return WishlistIconBtn;
	}

	public WebElement getLogout() {
		return Logout;
	}
	
	public boolean getCartImgNum() {
		String cartCount = cartImgNum.getText();	
		//System.out.println("The number of product added to cart = "+cartCount);
		if(cartCount.equals("1")) {
			   return true;
		}
		else
		{
        		return false;
		}
	}
	
	public void clickCartImg() throws Throwable {
		cartImgNum.click();
		Thread.sleep(2000);
	}

	public boolean VerifyMyAccount() {

		String myaccttxt = My_Account.getText();
		System.out.println("myaccttxt = "+ myaccttxt);
		if(myaccttxt.equals("MY ACCOUNT")) 
		{
			System.out.println("myaccttxt"+ myaccttxt+"displaying properly.");
			return true;
		}
		else
		{
			System.err.println("Recheck the entered details on sign up page again: SIGNUP FAILED DUE TO INVALID DATA ENTRY");
			return false;

		}
	}
	
	public void myAccount_Mouseover()
	{
		My_Account.click();
	}
	
	public WebElement getStoresBtn() {
        return StoresBtn;
    }

	public void logoutClick()
	{
		Logout.click();
	}

	public void PassValue() throws Throwable {

		SearchTextField.clear();
		SearchTextField.sendKeys("Toys");
		Thread.sleep(1000);
		SearchTextField.click();
		ShowAllResultBtn.click();
		}

	public void WishList() {
	    WishlistIconBtn.click();
	    }
	
	public void clickStoreElement() {
		StoreElement.click();
	}
	
	public boolean verifyTheWslImgNo() {
		String WishlistCount = WslImgNo.getText();
		System.out.println(WishlistCount);
		if (WishlistCount.equals("1")) {
			return true;
			}
		else {
			return false;
			}
		}
	
	public void HomeCategoryBtn() {
        HomeAndLivingBtn.click();
    }
	
	public String getParentcatone() {
		
		String parentcatetxt = (parentcatone.getText()).toLowerCase();
		parentcatone.click();
		return parentcatetxt;
	}
	
	public String getMastercattwo() {
		String MastCatsecondtxt = (Mastercattwo.getText()).toLowerCase();
		Mastercattwo.click();
		return MastCatsecondtxt;
	}


    public void DropAuctionBtn() {
    dropAuctionBtn.click();
    }

    public void StrsBtn() {
    StoresBtn.click();
    }
    
    public void CheckOutBtn() {
        checkOutBtn.click();
    }
    
    public void MyAccount() {
        myAccount.click();
    }
    
    public void BetterThatImg() {
        betterThatImg.click();
    }
    
    public void GcName() {
        String value = gcName.getText();
        //System.out.println(value);
        if (value.contains("Select a good cause.")) {
            System.out.println("The New Customer has not selected a GC");
        }
        else {
            System.out.println("The New Customer has selected a GC");
        }
    }
    
    public void CategoryBtn() {
        categoryBtn.click();
    }
    
    public void SelectTheCountry() throws InterruptedException {
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", lastElementOfPage);
        countryIcon.click();
        Thread.sleep(2000);
        countrySelect.click();
        Thread.sleep(3000);
    }
    
     public WebElement getLastElementOfPage() {

            return lastElementOfPage;

        }
    
    
}

