
package script;

 

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import generic.CommonBaseTest;

import page.BtHomepage;

 

public class ScrollLast  extends CommonBaseTest{

	@Test(priority=99)

    public void ScrollTillLast() throws InterruptedException {

        BtHomepage bhp = new BtHomepage(driver);

        String title = driver.getTitle();

        System.out.println(title);

 

        Thread.sleep(5000);


        WebElement element = driver.findElement(By.xpath("//div[@class='Footer_newsletterBlock__kWwTv']"));


        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

          Thread.sleep(2000);


          driver.findElement(By.xpath("//div[@class='SelectDropdown_selectCountryCustom__lRiqY']")).click();

          Thread.sleep(2000);


          driver.findElement(By.xpath("//ul[@class='SelectDropdown_selectCountry__JwI18']//li")).click();

          Thread.sleep(3000);


    }

 

}
