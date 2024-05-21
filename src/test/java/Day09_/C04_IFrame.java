package Day09_;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C04_IFrame extends TestBase {
    /*
    1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
 2 ) Bir metod olusturun: iframeTest
 - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
 - Text Box’a “Merhaba Dunya!” yazin.
 - TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin ve  yazisini konsolda yazdirin.
     */
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement anIFrameElementi= driver.findElement(By.tagName("//h3"));
        Assertions.assertTrue(anIFrameElementi.isEnabled());
        System.out.println(anIFrameElementi.getText());


    }

}
