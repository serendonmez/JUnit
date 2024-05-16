package Day05_jUnitFrameWork;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_JUnitIlkTest {


    @Test
    public void toTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testotomasyonu.com/");

        String expectedURLIcerik="testotomasyonu";
        String actualUrL= driver.getCurrentUrl();

        if (actualUrL.contains(expectedURLIcerik)){
            System.out.println(" test Passed");
        }else {
            System.out.println("failed");
        }

        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void wiseTesti () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://wisequarter.com/");

        String expectedURLIcerik="wise";
        String actualUrL= driver.getCurrentUrl();

        if (actualUrL.contains(expectedURLIcerik)){
            System.out.println(" test Passed");
        }else {
            System.out.println("failed");
        }
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void youtubeTesti() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://youtube.com/");

        String expectedURLIcerik="youtube";
        String actualUrL= driver.getCurrentUrl();

        if (actualUrL.contains(expectedURLIcerik)){
            System.out.println(" test Passed");
        }else {
            System.out.println("failed");
        }


        Thread.sleep(2000);
        driver.quit();

    }

}
