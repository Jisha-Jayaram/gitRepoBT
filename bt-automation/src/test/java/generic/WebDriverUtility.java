package generic;

import java.awt.event.ActionEvent;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

    WebDriver driver;

    /**

     * It is used to mouse over an element

     * @param driver

     */

    public void mouseOverAnElement(WebDriver driver,WebElement element) {

        Actions action = new Actions(driver);    

        action.moveToElement(element).perform();

    }

 

    /**

     * it is used to perform scrollBar Actions

     * 

     * @param driver

     */

    public void scrollBarAction(WebDriver driver) {

        JavascriptExecutor javaScript = (JavascriptExecutor) driver;

        javaScript.executeScript("window.scrollBy(0,500)");


    }


    public void scrollAndClickElement(WebDriver driver,WebElement ele) throws InterruptedException {

        JavascriptExecutor javaScript = (JavascriptExecutor) driver;

        javaScript.executeScript("window.scrollBy(0,500)");

        Thread.sleep(2000);

        ele.click();

    }


 

    public void scrollUntilElementFound(WebDriver driver, WebElement ele) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", ele);

        //js.executeScript("window.scrollBy(0,400)");

    }


    /**

     * it is used switch to select dropdown by using index

     * @param element

     * @param index

     */

    public void selectDropDown(WebElement element,int index)

    {

        Select select=new Select(element);

        select.selectByIndex(index);

    }



    /**

     * switch from one frame to another frame by using absolute_path

     * @param driver

     * @param element

     */

    public void switchtoFrame(WebDriver driver,WebElement element)

    {

        driver.switchTo().frame(element);

    }



    /**

     * its used to switch back from one child frame to parent frame

     * @param driver

     */

    public void switchBackToMainPage(WebDriver driver)

    {

        driver.switchTo().defaultContent();

    }

 

}
