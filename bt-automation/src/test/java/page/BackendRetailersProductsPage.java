package page;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 

import io.reactivex.rxjava3.annotations.Experimental;
import net.bytebuddy.asm.Advice.Enter;

 

public class BackendRetailersProductsPage {
    @FindBy(xpath = "//a[@id='remove-product-bulk-deletion-btn']") private WebElement bulkProductRemove;
    @FindBy(xpath = "//span[@class='select2-selection select2-selection--single']") private WebElement selectrRetailerField;
    @FindBy(xpath = "//input[@class='select2-search__field']")private WebElement inputRetailerTextFld;
    @FindBy(xpath = "//input[@id='product_name']") private WebElement productNameTextFld;
    @FindBy(xpath = "//button[@class='btn action-btn-alt download dropdown-toggle']") private WebElement actionsBtn;
    @FindBy(xpath = "//tr[@class='odd']//td[2]")private WebElement productNameAfterSearch;
    @FindBy(xpath = "//a[contains(@href,'/auction/create/')]")private WebElement scheduleDpAuctionBtn;
    @FindBy(xpath = "//ul[@class='select2-results__options select2-results__options--nested']//li") private List<WebElement> listOfRetailers;
    @FindBy(xpath = "//tr[@role='row']") private List<WebElement> listOfProducts;
    @FindBy(xpath = "(//li[@class='select2-results__option' and @aria-selected='false'])[5]")private WebElement firstRetailer;

    String enteredProductName=null;

    
    public BackendRetailersProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public WebElement getBulkProductRemove() {
        return bulkProductRemove;
    }


    public WebElement getSelectrRetailerField() {
        return selectrRetailerField;
    }

    public WebElement getInputRetailerTextFld() {
        return inputRetailerTextFld;
    }

 
    public WebElement getProductNameTextFld() {
        return productNameTextFld;
    }

    public void FirstRetailer() {

        firstRetailer.click();
    }

public void SelectRetailerField() {
    selectrRetailerField.click();
}
public void InputRetaileFld(String retailerName) {
    inputRetailerTextFld.sendKeys(retailerName+Keys.ENTER);
}



public String ProductNameTextFld(String productName ) {

      productNameTextFld.sendKeys(productName+Keys.ENTER);
     // productNameTextFld.submit();
       enteredProductName= productNameTextFld.getAttribute("value");
      System.out.println("Entered product name: " + enteredProductName);
      return enteredProductName;

}

 

public void ActionsBtn() {

    String searchedpdt = productNameAfterSearch.getText();
    System.out.println(searchedpdt);
    /*
        if (searchedpdt==(enteredProductName)) {
            actionsBtn.click();
            }

    */
    actionsBtn.click();    
    }


 


public void ScheduleDropAuctionbtn() {
    scheduleDpAuctionBtn.click();
}
 

public void ListOfRetailers(String retailerName) {
    for (WebElement retailers : listOfRetailers) {
        String retailerNames = retailers.getText();
        System.out.println(retailerNames);
        if (retailerNames.contains(retailerName)) {

            System.out.println("print");
        }
    }
}


public void ListOfProducts(String productName) throws Throwable {

    productNameTextFld.sendKeys(productName+Keys.ENTER);
    Thread.sleep(3000);
    for (WebElement products : listOfProducts) {
        String name=products.getText();
        System.out.println(name);
        if (name.contains("ladies hand bag")) {
            actionsBtn.click();
            Thread.sleep(3000);
        }
    }



}

 

 


}