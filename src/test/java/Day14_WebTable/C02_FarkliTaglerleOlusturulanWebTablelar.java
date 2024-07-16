package Day14_WebTable;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C02_FarkliTaglerleOlusturulanWebTablelar extends TestBase {


    /*
    1. “https://testotomasyonu.com/webtables2” sayfasina gidin
 2. Headers da bulunan basliklari yazdirin
 3. 3.sutunun basligini yazdirin
 4. Tablodaki tum datalari yazdirin
 5. Tabloda kac tane cell (data) oldugunu yazdirin
 6. Tablodaki satir sayisini yazdirin
 7. Tablodaki sutun sayisini yazdirin
 8. Tablodaki 3.kolonu yazdirin
 9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
10. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin
     */




    @Test
    public void test01(){

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        //           //*[@role='trow'] [2] / *[@role ='tdata'][3]

        //  2. Headers da bulunan basliklari yazdirin

        List<WebElement> baslikElementleriList =
                driver.findElements(By.xpath("//*[@role='hrow']  / *[@role ='hdata']"));

        System.out.println("Basliklar : " + ReusableMethods.stringListesineDonustur(baslikElementleriList));
        //Basliklar : [Product Name, Category, Price, Actions]

        //  3. 3.sutunun basligini yazdirin

        System.out.println("3.sutun basligi : " + baslikElementleriList.get(2).getText());
        //  3.sutun basligi : Price

        //  4. Tablodaki tum datalari yazdirin
        WebElement tumTableElementi = driver.findElement(By.className("table"));

        System.out.println("Tum body : \n" + tumTableElementi.getText());

        //  5. Tabloda kac tane cell (data) oldugunu yazdirin

        List<WebElement> bodydekiDataElementleriList =
                driver.findElements(By.xpath("//*[@role='trow'] / *[@role ='tdata']"));

        System.out.println("Body'deki cell sayisi : " + bodydekiDataElementleriList.size() );
        //Body'deki cell sayisi : 20

        //  6. Tablodaki satir sayisini yazdirin

        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//*[@role='trow']"));

        System.out.println("Tablodaki satir sayisi : " + satirElementleriList.size());
        //Tablodaki satir sayisi : 5


        //  7. Tablodaki sutun sayisini yazdirin
        //     Yukarda basliklari bir liste olarak kaydetmistik
        System.out.println("Tablodaki sutun sayisi : " + baslikElementleriList.size());
        //  Tablodaki sutun sayisi : 4

        //  8. Tablodaki 3.kolonu yazdirin

        List<WebElement> ucuncuSutunElementleriList =
                driver.findElements(By.xpath("//*[@role='trow'] / *[@role ='tdata'] [3]"));

        System.out.println("3. sutun datalari : " + ReusableMethods.stringListesineDonustur(ucuncuSutunElementleriList));
        // 3. sutun datalari : [$399.00, $399.00, $399.00, $40.00, $15.00]


        // 9. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin
        // 3.satir, 2.sutundaki elementi yazdiralim  Furniture

        System.out.println(getCellData(3,2)); // Furniture

        // 1. satir, 4. sutundaki datayi yazdiralim  Go

        System.out.println(getCellData(1,4)); // Go


        //  10. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        System.out.println("Furniture kategorisindeki urunlerin fiyatlari : "); // $399.00

        for (int i = 1; i <= satirElementleriList.size() ; i++) {

            if (getCellData(i,2).equalsIgnoreCase("Furniture")){

                System.out.println(getCellData(i,3));
            }

        }

    }


    public String getCellData(int satirNo , int sutunNo){

        //       //*[@role='trow'] [    2     ] / *[@role ='tdata'] [    2   ]

        String dinamikXPath = "//*[@role='trow'] [" + satirNo + "] / *[@role ='tdata'] [" + sutunNo + "]";

        WebElement istedenCellElementi = driver.findElement(By.xpath(dinamikXPath));

        return istedenCellElementi.getText();
    }
}
