package Day15_excelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class C04_ExcelDataTesti {


    @Test


    public void test() throws IOException {

        String fileStream= "src/test/java/Day15_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(fileStream);
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        Sheet sayfa1= workbook.getSheet("Sayfa1");






    }
}
