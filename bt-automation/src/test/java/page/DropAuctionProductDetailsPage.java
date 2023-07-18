package page;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

 

public class DropAuctionProductDetailsPage {

    @FindBy(xpath = "//button[@class='multi_btnCustom__iFH_4 ']")private WebElement joinTheDropBtn;

    @FindBy(xpath = "//button[@class='multi_btnOrange__9JB2S']")private WebElement placeAnOfferBtn;

    @FindBy(xpath = "//div[@class='multi_colourFilterList__R1nCq']")private WebElement colorSelectionOption;

    @FindBy(xpath = "//div[@class='multi_labelName__MM2q7']") private WebElement materialSelectOption;

    @FindBy(xpath = "//div[@class='multi_colourFilterList__R1nCq']//label[@class='multi_colourFilterHd__p2tzS Colour']")private WebElement color;

    @FindBy(xpath = "//div[@class='multi_colourFilter__L3IhW']//label") private WebElement firstColor;

    @FindBy(xpath = "//div[@class='multi_labelName__MM2q7']//label") private WebElement material;

    @FindBy(xpath = "//select[@class='form-control multi_formGroupControl__Px7bW']") private WebElement selectDrp;

    @FindBy(xpath = "//div[@class='multi_auctionProductName__rlbuc']//h2")private WebElement productPrice;

    @FindBy(xpath = "//div[@class='multi_productNameHeading__qQgAB ']") private WebElement productName;
    


    public DropAuctionProductDetailsPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

 
    public String ProductName() {
        String text=productName.getText();
        return text;
    }
 

    public WebElement getJoinTheDropBtn() {

        return joinTheDropBtn;

    }

 

 

    public WebElement getPlaceAnOfferBtn() {

        return placeAnOfferBtn;

    }

 

    public void AttributeSelection() throws InterruptedException {

        String text = color.getText();

        //String text1 = material.getText();

        if (text.contains("Colour")) {

            firstColor.click();

        }

        Thread.sleep(2000);

        Select sel = new Select(selectDrp);

        sel.selectByIndex(1);

    }



    public void MaterailAtt() {

        Select sel = new Select(selectDrp);

        sel.selectByIndex(1);

    }


    public void JoinTheDrop() {

        joinTheDropBtn.click();

    }



    public void PlaceAnOffer() {

        placeAnOfferBtn.click();

    }


    public String ProductPrice() {

        String price=productPrice.getText();

        //System.out.println(price);

        String newprice = price.replace("Dropping from AUD $", " ");

        System.out.println(newprice);

        return newprice;

    }
    
    public String PlaceAnOfferButtonText() {

        String text=placeAnOfferBtn.getText();
       return text;
   }

}
