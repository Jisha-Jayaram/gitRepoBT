package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import generic.WebDriverUtility;

public class CategoryPopUpPage  {

    @FindBy(xpath = "//div[@class='Header_navOuterBlock__zy1hY']//a[text()='Bedding']") private WebElement BeddingText;

    @FindBy(xpath = "//div[@class='Header_navOuterBlock__zy1hY']//a[text()='Bedroom Accessories']") private WebElement BedroomAccText;

    @FindBy(xpath = "//div[@class='Header_navOuterBlock__zy1hY']//a[text()='Bedroom Furniture']") private WebElement BedroonFurnitureText;

    @FindBy(xpath = "//div[@class='Header_navOuterBlock__zy1hY']//a[text()='Mattress & Pillows']") private WebElement MatressAndPillowText;

    @FindBy(xpath = "//div[@class='Header_leftMenuList__mKlLk']//a[text()='View all']") private WebElement ViewAllBtn;
    
    @FindBy(xpath = "//a[text()='View all']") private WebElement viewAll;
    //Initiliztion

        public CategoryPopUpPage(WebDriver driver) {

            PageFactory.initElements(driver, this);    

        }
    public WebElement getBeddingText() {

        return BeddingText;

    }

    public WebElement getBedroomAccText() {

        return BedroomAccText;

    }

    public WebElement getBedroonFurnitureText() {

        return BedroonFurnitureText;

    }

    public WebElement getMatressAndPillowText() {

        return MatressAndPillowText;

    }


    public void Bedding() {

        BeddingText.click();

    }

    public void View() {

        ViewAllBtn.click();

    }
    
    public void ViewAllBtn() {
        viewAll.click();
    }

}
