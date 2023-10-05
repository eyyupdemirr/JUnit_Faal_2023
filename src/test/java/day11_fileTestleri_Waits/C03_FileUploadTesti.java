package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {

    @Test
    public void test01() {


        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //2.chooseFile butonuna basalim


     /*
            insan olarak dosya secimi icin
            chooseFile butonuna bastiktan sonra
            acilan windows dosya penceresinden
            istedigimiz dosyayi secip yukleriz.

            Selenium'da otomasyon ile bu islemi yapmak icin
            chooseFile butonu locate edilip,
            bu webelement'e sendKeys(yuklenecekDosyaninDosyaYolu); yapilir
         */

        WebElement uploadButtonElementi = driver.findElement(By.id("file-upload"));
        String dinamikDosyaYolu = System.getProperty("user.dir") + "/src/test/java/day11_fileTestleri_Waits/text.txt";


        uploadButtonElementi.sendKeys(dinamikDosyaYolu);


        //C:\Users\ludwi\IdeaProjects\Team120_JUnit_Fall2023\src\test\java\day11_fileTestleri_Waits\text.txt
        //  \src\test\java\day11_fileTestleri_Waits\text.txt  C:\Users\ludwi\IdeaProjects\Team120_JUnit_Fall2023\src\test\java\day11_fileTestleri_Waits\text.txt

        //4.Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadedElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedElementi.isDisplayed());


    }


}
