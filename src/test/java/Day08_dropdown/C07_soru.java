package Day08_dropdown;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class C07_soru extends TestBase {
    /*
1. http://zero.webappsecurity.com/ Adresine gidin
2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password” yazin
5. Sign in tusuna basin, back tusuna basarak sayfaya donun
6. Online banking menusunden Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
kontrol edin.

     */
    @Test
    public void banktest(){

        driver.get("http://zero.webappsecurity.com/");

        driver.findElement(By.className("icon-signin"))
                .click();
        ReusableMethods.bekle(3);

        driver.findElement(By.xpath("//*[@*='text']")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");


        WebElement signin= driver.findElement(By.xpath("//*[@name='submit']"));
        signin.click();

        driver.navigate().back();
        ReusableMethods.bekle(3);

        //6. Online banking menusunden Pay Bills sayfasina gidin

                driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        ReusableMethods.bekle(3);





        driver.findElement(By.xpath("//*[@id='pay_bills_link']"))
                .click();
//7. “Purchase Foreign Currency” tusuna basin

        driver.findElement(By.xpath("//a[@href='#ui-tabs-3']"))
                .click();
      //  8. “Currency” drop down menusunden Eurozone’u secin
          WebElement ddm=   driver.findElement(By.xpath("//select[@id='pc_currency']"));
            Select select=new Select(ddm);
            select.selectByVisibleText("Eurozone (euro)");
        ReusableMethods.bekle(3);
            //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//input[@id='pc_amount']"))
                .sendKeys("10");

        //10. “US Dollars” in secilmedigini test edin

        WebElement USradioButton= driver.findElement(By.id("pc_inDollars_true"));

        Assertions.assertFalse(USradioButton.isSelected());

        //11. “Selected currency” butonunu secin

        driver.findElement(By.id("pc_inDollars_false"))
                .click();
        ReusableMethods.bekle(3);
//12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin

        driver.findElement(By.id("pc_calculate_costs"))
                .click();


        driver.findElement(By.id("purchase_cash"))
                .click();

//13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
//kontrol edin.
        ReusableMethods.bekle(3);
      WebElement successText=  driver.findElement(By.id("alert_content"));


        System.out.println(successText.getText());
        String expectedText= successText.getText();
        String text="Foreign currency cash was successfully purchased.";
        Assertions.assertEquals(text,expectedText);


    }
}
