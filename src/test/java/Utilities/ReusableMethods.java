package Utilities;


import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
}
