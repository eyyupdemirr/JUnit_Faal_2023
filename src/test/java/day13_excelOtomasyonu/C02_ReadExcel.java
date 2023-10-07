package day13_excelOtomasyonu;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        // ilgili ayarlari yapip workbook'u olusturun

            String dosyaYolu="src/test/java/day13_excelOtomasyonu/ulkeler.xlsx";
            FileInputStream fis=new FileInputStream(dosyaYolu);
            Workbook workbook=WorkbookFactory.create(fis);

        // 2.sayfaya gidin
        Sheet sheet2=workbook.getSheet("Sayfa2");

        // kullanilan en son satirin 24.satir oldugunu test edin
        int expectedSatir=24;
        int actualSatir=sheet2.getLastRowNum()+1;

        Assert.assertEquals(expectedSatir,actualSatir);


        // fiziki kullanilan satir sayisinin 8 oldugunu test edin

        int fksatir=8;
        int actualKsatir=sheet2.getPhysicalNumberOfRows();

        Assert.assertEquals(fksatir,actualKsatir);



        // olmayan satir veya sutun numarasi yazdirmaya calissak
        // System.out.println(sayfa2.getRow(30).getCell(1)); NullPointerException
        System.out.println(sheet2.getRow(5).getCell(1150)); // null





    }





}
