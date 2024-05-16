package Day05_jUnitFrameWork;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_AramaTesti {
    /*
    Ahmet Bulutluoz
  20:38 Uhr
// gerekli nayarlamalari yapip
// 3 farkli test method'u olusturun
// ve asagidaki testleri farkli test method'larinda calistirin
// 1- testotomasyonu anasayfaya gidin ve anasayfaya gittiginizi test edin
// 2- phone icin arama yaptirip, arama sonucunda urun bulunabildigini test edin
// 3- ilk urunu tiklayip, urun isminde case sensitive olmaksizin phone gectigini test edin
     */

    @Test
    public void Test1(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testotomasyonu.com/");

        String expectedSF= "Test Otomasyonu";
        String  ActualSF= driver.getTitle();

        if (ActualSF.equals(expectedSF)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }

        driver.quit();
    }
    @Test
    public void Test2(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testotomasyonu.com/");
        WebElement aramaKutusu  =driver.findElement(By.className("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        List<WebElement> bulunanPhoneSayisi= driver.findElements(By.xpath("//*[@*='prod-img']"));

        if (bulunanPhoneSayisi.size()>0){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
    }

    @Test
    public void Test3() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testotomasyonu.com/");

        WebElement ilkPhone= driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        ilkPhone.click();

        Thread.sleep(3000);
        WebElement phoneName=driver.findElement(By.className("APPLEL iPhone 13 (Starlight, 128 GB)"));


       String stringphoneName= phoneName.getText().toLowerCase();


       if (stringphoneName.contains("Phone")){
           System.out.println("passed");
       }else {
           System.out.println("failed");
       }

       driver.quit();



    }
}
