package Day12_fakerClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_DinamicFileExistsTesting {


    @Test
    public void test() {




     //   String dosyaYolu= "C:\\Users\\User\\OneDrive            \\Desktop\\upload.png";

        System.out.println(System.getProperty("user.home"));


        String   dosyaYolu=System.getProperty("user.home")+"\\Desktop\\upload.png";
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
