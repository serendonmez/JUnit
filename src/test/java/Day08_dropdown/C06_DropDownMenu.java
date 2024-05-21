package Day08_dropdown;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class C06_DropDownMenu extends TestBase {

    /*
    ● https://testotomasyonu.com/form adresine gidin.
	1.Index kullanarak Option 1 secin ve yazdirin
	2. Value kullanarak Option 2 secin ve yazdirin
	3. VisibleText kullanarak Option 1 secin ve yazdirin
	4. Tüm dropdown degerlerini yazdirin
	5.Dropdown un boyutunun 4 old test edin
     */



    @Test
    public void dropdowntesti(){

        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // dropdown menuyu kullanmak icin 3 adim yazalim
        WebElement dropdownElementi = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropdownElementi);

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın

        List<WebElement> tumOptionElementleriList = select.getOptions();

        System.out.println(ReusableMethods.stringListesineDonustur(tumOptionElementleriList));

        //5. Dropdown’un boyutunun 4 olduğunu test edin

        int expectedOptionSayisi = 4;
        int actualOptionSayisi = tumOptionElementleriList.size();

        Assertions.assertEquals(expectedOptionSayisi,actualOptionSayisi);

        ReusableMethods.bekle(3);

    }



}
