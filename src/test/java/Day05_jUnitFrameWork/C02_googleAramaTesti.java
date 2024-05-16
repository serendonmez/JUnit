package Day05_jUnitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_googleAramaTesti {
    public static void main(String[] args) throws InterruptedException {

        /*
        2- https://www.google.com/ adresine gidin
3- cookies uyarisini kabul ederek kapatin
4- Sayfa basliginin “Google” ifadesi icerdigini test edin
5- Arama cubuguna “Nutella” yazip aratin
//6- ilk urune tiklayalim
//7- acilan sayfada urun isminde Nutella gectigini test edin
8- Sayfayi kapatin
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");

        driver.findElement(By.xpath(">>*[text()='Alle akzeptieren'")).click();


        String expectedTitleIcerik = "Google";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@name='q']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);


        Thread.sleep(3000);
        driver.quit();
    }
}
