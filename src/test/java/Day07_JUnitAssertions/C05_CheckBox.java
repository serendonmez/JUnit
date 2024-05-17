package Day07_JUnitAssertions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_CheckBox {

    /*
    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
 a. Verilen web sayfasına gidin.
     https://testotomasyonu.com/form
 b. Sirt Agrisi ve Carpinti checkbox’larini secin
 c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
 d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin
     */


    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }


    @Test
    public void checkBoxTesti() throws InterruptedException {
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        //     secme islemi hem yazidan hem kutudan yapilabildiginden
        //     testin daha efektif olmasi icin
        //     sirt agrisini kutudan, carpintiyi yazidan secelim
        WebElement sirtAgrisiKutusu = driver.findElement(By.id("gridCheck5"));
        sirtAgrisiKutusu.click();

        WebElement carpintiYaziElementi = driver.findElement(By.xpath("//*[@for='gridCheck4']"));
        carpintiYaziElementi.click();

        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        //     carpintiyi yazidan sectik ama yazidan test yapamayiz
        WebElement carpintiKutusu = driver.findElement(By.id("gridCheck4"));

        // sirt agrisi checkbox'in secili oldugunu test edin
        Assertions.assertTrue(sirtAgrisiKutusu.isSelected());
        // carpinti checkbox'in secili oldugunu test edin
        Assertions.assertTrue(carpintiKutusu.isSelected());

        //	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        WebElement sekerCheckbox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckbox = driver.findElement(By.id("hastalikCheck7"));


        //Seker checkbox’inin seçili olmadigini test edin

        Assertions.assertFalse(sekerCheckbox.isSelected());

        //Epilepsi checkbox’inin seçili olmadigini test edin

        Assertions.assertFalse(epilepsiCheckbox.isSelected());

        Thread.sleep(3000);
    }





}
