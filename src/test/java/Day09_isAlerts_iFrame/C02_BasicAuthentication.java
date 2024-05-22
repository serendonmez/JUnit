package Day09_isAlerts_iFrame;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02_BasicAuthentication extends TestBase {




            /*
    1- Bir class olusturun : BasicAuthentication
2- https://testotomasyonu.com/basicauth sayfasina gidin
3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
Html komutu : https://username:password@URL
 Username    : membername
  password     : sunflower
4- Basarili sekilde sayfaya girildigini dogrulayin

     */

    @Test
    public void test01(){

        //1- Bir class olusturun : BasicAuthentication
        //2- https://testotomasyonu.com/basicauth sayfasina gidin

        // driver.get("https://testotomasyonu.com/basicauth");
        // URL'e normal bir sekilde gitmek istersek
        // sonrasinda kullanici adi ve sifreyi otomasyonla yazmamiz  MUMKUN DEGILDIR


        // Otomasyonla giris yapabilmek icin
        // giris yapmak istedigimiz firmadan
        // kullanici adi ve sifre ile birlikte
        // bu degerleri nasil yollayacagimiz BILGISINI de almamiz
        // ve bize soylenen yontemle giris yapmamiz ZORUNLUDUR


        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : membername
        // 	password      : sunflower
        //
        //4- Basarili sekilde sayfaya girildigini dogrulayin

        WebElement basariliGirisYaziElementi = driver.findElement(By.xpath("//*[text()='Congratulations! You are logged in as: membername']"));

        Assertions.assertTrue(basariliGirisYaziElementi.isDisplayed());

        ReusableMethods.bekle(2);

    }










}
