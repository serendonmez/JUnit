package Day16_getScreenShot;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_JavascriptExecutor extends TestBase {

    @Test
    public void test(){


        driver.get("https://www.testotomasyonu.com/");

        WebElement sportShoes= driver.findElement(By.xpath("(//*[@class='blog-heading'])[4]"));
        ReusableMethods.bekle(2);

        System.out.println(sportShoes.getText());


        Actions actions=new Actions(driver);
        actions.moveToElement(sportShoes).perform();

        sportShoes.click();
        ReusableMethods.bekle(5);


        driver.get("https://wisequarter.com/");




        WebElement wisesf= driver.findElement(By.xpath("//*[text()='Why ']"));

        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});",wisesf);

        actions.moveToElement(wisesf).perform();
        System.out.println(wisesf.getText());
        wisesf.click();
    }




}
