package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
* @author Jisha Jayaram
*
*/
public class AddtoBagePage {
	
	@FindBy(xpath="//button[@class='multi_btnCustom__iFH_4']") 
	private WebElement ATBPopUpBtn;
	@FindBy(xpath="//div[@class = 'multi_productNameHeading__qQgAB ']")
	private WebElement ATBPopUpProd_Name;
	@FindBy(xpath="//div[@class = 'multi_productDetailInfo__fs_ew']/p/strong[contains(text(),'Sorry, the maximum quantity available for this product is 1')]")
	private WebElement stockvalidationtxt;
	@FindBy(xpath ="//div[@class = 'modal-content ProductDetailModal_modalBody__muvkK']/button")
	private WebElement closeicon;
	@FindBy(xpath="(//select[@class='form-control multi_formGroupControl__Px7bW'])[1]")
	private WebElement firstattributedropdown;
	@FindBy(xpath ="(//select[@class='form-control multi_formGroupControl__Px7bW'])[2]")
	private WebElement secondattributedropdown;

    public AddtoBagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement clickATBPopUpBtn() {
		ATBPopUpBtn.click();
		return ATBPopUpBtn;
	}

	public String getATBPopUpProd_Name() {
		String atbprod_name = ATBPopUpProd_Name.getText();
		return atbprod_name;
	}
	
	public WebElement getStockvalidationElement()
	{
		
			return stockvalidationtxt;
		
	}
	
	public String getStockvalidationtxt() {
		String svtxt = stockvalidationtxt.getText();
		return svtxt;
	}

	public void clickCloseIcon() {
		closeicon.click();
	}
	
	public void getfirstattributedropdown() {
		Select Colour = new Select(firstattributedropdown);
		List <WebElement> colourCount = Colour.getOptions();
		System.out.println(colourCount.size());
		Colour.selectByIndex(1);
	    //  drop.selectByIndex(1);
	}
	
	public void getsecondattributedropdown() {
		Select Size = new Select(secondattributedropdown);
		List <WebElement> sizeCount = Size.getOptions();
		System.out.println(sizeCount.size());
		Size.selectByIndex(1);
	}
	

}
