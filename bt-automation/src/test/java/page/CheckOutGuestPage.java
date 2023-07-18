package page;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class CheckOutGuestPage {

	    @FindBy(xpath = "//input[@name='name']")private WebElement FirstNameTxtFld;

	    @FindBy(xpath = "//input[@name='lname']") private WebElement LastNameTxtFld;

	    @FindBy(xpath = "//input[@name='email']") private WebElement EmailTxtFld;

	    @FindBy(xpath = "//input[@name='phoneNumber']")private WebElement PhoneNoTxtFld;

	    @FindBy(xpath = "//span[text()='Process to checkout']") private WebElement ProceedCheckoutBtn;

	    @FindBy(xpath = "//label[@class='custom-check checkout_checkBox__cEq8q']//span")private WebElement CheckBox;

	    @FindBy(xpath = "//span[@class='checkout_bagsItemTitle__edkbz']/a")private WebElement productNameOnCheckoutasGuest;

	    @FindBy(xpath = "//span[@class='checkout_bagsItemPrice__5t5dZ']")private WebElement productPriceOnCheckoutasGuest;

	 

	    public CheckOutGuestPage(WebDriver driver) {

	        PageFactory.initElements(driver, this);

	    }

	 

	    public String ProductNameOnCheckoutasGuest() {

	        String name = productNameOnCheckoutasGuest.getText();

	        System.out.println(name);

	        return name;

	    }

	 

	    public String productPriceOnCheckoutasGuest() {

	        String price = productPriceOnCheckoutasGuest.getText();

	        System.out.println(price);

	        return price;

	    }

	    public WebElement getFirstNameTxtFld() {

	        return FirstNameTxtFld;

	    }

	 



	    public WebElement getLastNameTxtFld() {

	        return LastNameTxtFld;

	    }

	 
	    public WebElement getEmailTxtFld() {

	        return EmailTxtFld;

	    }

	 
	    public WebElement getPhoneNoTxtFld() {

	        return PhoneNoTxtFld;

	    }


	    public WebElement getProceedCheckoutBtn() {

	        return ProceedCheckoutBtn;

	    }

	    public WebElement getCheckBox() {

	        return CheckBox;

	    }

	 

	    public void FirstTextFld() {

	        FirstNameTxtFld.sendKeys("Jisha");

	    }

	    public void LastTextFld() {

	        LastNameTxtFld.sendKeys("jayaram");

	    }

	
	    public void EmailTextFld() {

	        EmailTxtFld.sendKeys("jishajayaram@yopmail.com");

	    }

	 

	    public void PhoneNoTextFld() {

	        PhoneNoTxtFld.clear();

	        PhoneNoTxtFld.sendKeys("650868");

	    }

	 

	    public void CheckBox() {

	        CheckBox.click();

	    }

	    public void ProceedcheckOutBtn() {

	        ProceedCheckoutBtn.click();

	    }

	 

	    public void FillTheDetails() throws Throwable {

	        Thread.sleep(3000);

	        FirstNameTxtFld.sendKeys("jisha");

	        LastNameTxtFld.sendKeys("jayaram");

	        EmailTxtFld.sendKeys("jisha@yopmail.com");

	        PhoneNoTxtFld.sendKeys("657894");

	        Thread.sleep(4000);

	        CheckBox.click();

	        ProceedCheckoutBtn.click();

	        //Thread.sleep(3000);

	    }

	}



