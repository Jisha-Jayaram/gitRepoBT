package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class BackendDashBoardPage {

    @FindBy(xpath = "//img[@src='/public/assets/images/logo.png']") private WebElement betterThatImg;

    @FindBy(xpath = "//ul[@id='side-menu']//a[@class='waves-effect home active']//span") private WebElement dashBoardBtn;

    @FindBy(xpath = "//a[@href='/auction/list']//span") private WebElement dropAuctionBtn;

    @FindBy(xpath = "//a[@href='/customer']//span")private WebElement customersBtn;
    
    @FindBy(xpath = "//a[@href='/retailer_product_list']") private WebElement ProductsBtn;
    
    @FindBy(xpath = "//a[@href='/retailer_product_list']/span[.=' My Products']") private WebElement ProductInfoBtn;
    
    @FindBy(xpath = "//form/div[@class='row search-filters']/div/input") private WebElement Searchcust;
    

    public BackendDashBoardPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }


    public WebElement getBetterThatImg() {

        return betterThatImg;

    }


    public WebElement getDashBoardBtn() {

        return dashBoardBtn;

    }


    public WebElement getDropAuctionBtn() {

        return dropAuctionBtn;

    }


    public WebElement getSearchcust() {
		return Searchcust;
	}


	public void setSearchcust(String Searccustinput) {
		Searchcust.clear();
		Searchcust.sendKeys(Searccustinput);
		Searchcust.sendKeys(Keys.ENTER);
		//Searchcust.click();
	}
	


	public WebElement getCustomersBtn() {

        return customersBtn;

    }


    public void DropAuction() {

        dropAuctionBtn.click();

    }
    
    public void ProductBtnclick()
    {
    	ProductsBtn.click();
    }

    public void ProductInfoBtnClick()
    {
    	ProductInfoBtn.click();
    }
    
    public void CustomerBtnClick()
    {
    	customersBtn.click();
    }
    

}
