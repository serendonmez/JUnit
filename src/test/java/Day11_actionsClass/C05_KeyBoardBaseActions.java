package Day11_actionsClass;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_KeyBoardBaseActions extends TestBase {

    /*
1- https://www.testotomasyonu.com sayfasina gidelim
2- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin
3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin
     */

    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");
        //2- Arama kutusuna actions method’larini kullanarak
        //   “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin

        Actions actions = new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        // aramaKutusu.sendKeys("DELL Core I3");


        ReusableMethods.bekle(1);



        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT) // shift tusuna 2.emre kadar basili tutar
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT) // basili tuttugumuz shift'den elimizi kaldirir
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("i")
                .keyUp(Keys.SHIFT)
                .sendKeys("3")
                .sendKeys(Keys.ENTER)
                .perform();

        ReusableMethods.bekle(1);

        WebElement products= driver.findElement(By.className("product-count-text"));
        Assertions.assertTrue(products.isDisplayed());

        //3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin


        String expectedUrunIsimIcerigi = "DELL Core I3";
        String actualUrunIsmi = driver.findElement(By.xpath("//*[@class='mx-2 mb-3 mt-4']"))
                                        .getText();
        System.out.println(actualUrunIsmi);

        Assertions.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerigi));

        ReusableMethods.bekle(3);
    }



    }






