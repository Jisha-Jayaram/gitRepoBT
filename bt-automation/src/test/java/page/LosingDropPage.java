package page;

 

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

 

public class LosingDropPage  {

 

    

    @FindBy(xpath = "//h1[text()='Better luck next time.']")

    private WebElement losingDropText;


    public LosingDropPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }


    public boolean LosePage() {

        if (losingDropText.isDisplayed()) {

            System.out.println("The user has lost the Drop Autcion Product");

            return true;

        }

        else {

            System.out.println("The user has win the Drop Autcion Product");

            return false;

        }

    }


}
