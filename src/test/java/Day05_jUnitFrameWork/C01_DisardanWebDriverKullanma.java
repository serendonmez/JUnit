package Day05_jUnitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_DisardanWebDriverKullanma {
    public static void main(String[] args) throws InterruptedException {

        // TestOtomasyonun ana sf ya git
        // url in  test otomasyonu

        // özel webdriver kullanmamiiz gerekirse

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testotomasyonu.com/");

        String expectedURL= "https://testotomasyonu.com/";
        String ActualURL= driver.getCurrentUrl();
        if (expectedURL.equals(ActualURL)){
            System.out.println(" test Passed");
        }else {
            System.out.println(" test failed");
        }

        Thread.sleep(2000);

        driver.quit();

    }
}
