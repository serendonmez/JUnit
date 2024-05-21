package Day09_;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C01_JavascriptAlerts extends TestBase {

        /*
        3 test method'u olusturup asagidaki gorevi tamamlayin
1. Test
 - https://testotomasyonu.com/javascriptAlert adresine gidin
 - 1.alert'e tiklayin
 - Alert'deki yazinin "I am a JS Alert" oldugunu test edin
 - OK tusuna basip alert'i kapatin
2.Test
 - https://testotomasyonu.com/javascriptAlert adresine gidin
 - 2.alert'e tiklayalim
 - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
3.Test
 - https://testotomasyonu.com/javascriptAlert adresine gidin
 - 3.alert'e tiklayalim
 - Cikan prompt ekranina "Abdullah" yazdiralim
 - OK tusuna basarak alert'i kapatalim
 - Cikan sonuc yazisinin Abdullah icerdigini test edelim
         */

    //3 test method'u olusturup asagidaki gorevi tamamlayin

    @Test
    public void test01(){
        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 1.alert'e tiklayin

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"))
                .click();
        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin

        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();

    }

    @Test
    public void test02(){
        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"))
                .click();

        //	- Cancel'a basip,
        driver.switchTo()
                .alert()
                .dismiss();

        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@id='result']"));

        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }


    @Test
    public void test03(){
        //3.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"))
                .click();
        //	- Cikan prompt ekranina "Bugra" yazdiralim

        driver.switchTo().alert().sendKeys("Bugra");


        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //	- Cikan sonuc yazisinin Bugra icerdigini test edelim

        String expectedSonucYaziIcerigi = "Bugra";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@id='result']"));
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assertions.assertTrue(actualSonucYazisi.contains(expectedSonucYaziIcerigi));

    }





}
