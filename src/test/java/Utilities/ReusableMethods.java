package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye) {

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

 //  public static void listYazdir(List<WebElement> list){

 //      for ( WebElement each :list   ) {
 //          System.out.print(each.getText()+" ");
 //      }

 //  }


    public static List<String> stringListesineDonustur(List<WebElement> webelementListesi){

        List<String> istenenStringList = new ArrayList<>();

        for (WebElement eachElement : webelementListesi
        ) {
            istenenStringList.add(eachElement.getText());
        }

        return istenenStringList;
    }

    public static void windowaGec(String url, WebDriver driver){

        Set<String> handles = driver.getWindowHandles();

        for ( String each : handles   ) {
           driver.switchTo().window(each);

           if (driver.getCurrentUrl().equals(url)){
               break;
           }
        }


    }
}
