package Day12_fakerClass_fileTestleri;

import Utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C06_DinamicFileUploadTesting extends TestBase {


@Test
    public void test (){

//1.https://the-internet.herokuapp.com/upload adresine gidelim
//2.chooseFile butonuna basalim
//3.day12 altindaki upload.png dosyasini dinamik olarak secelim.
//4.Upload butonuna basalim.
//5."File Uploaded!" textinin goruntulendigini test edelim.

    driver.get("https://the-internet.herokuapp.com/upload");

    //2.chooseFile butonuna basalim


    WebElement chooseFile= driver.findElement(By.xpath("//*[@id='file-upload']"));
    // absolute path ile dosya yolunu alalim

    // "C:\\Users\\User\\IdeaProjects\\Team141_JUnit        \\src\\test\\java\\Day12_fakerClass_fileTestleri\\upload.png"
    //             "user.dir"                                   //    projedeki herkes icin ayni kisim
    String filePath=System.getProperty( "user.dir")+"\\src\\test\\java\\Day12_fakerClass_fileTestleri\\upload.png";

    chooseFile.sendKeys(filePath);



    WebElement uploadButton= driver.findElement(By.className("button"));
    uploadButton.click();

   String actualFileUploaded = driver.findElement(By.tagName("h3")).getText();

    String expectedFileUploaded= "File Uploaded!";
    Assertions.assertEquals(expectedFileUploaded,actualFileUploaded);







}



    }
