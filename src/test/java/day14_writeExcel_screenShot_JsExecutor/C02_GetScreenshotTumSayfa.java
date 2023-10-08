package day14_writeExcel_screenShot_JsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_GetScreenshotTumSayfa extends TestBase {
    @Test
    public void test01() throws IOException {

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // Nutella icin arama yapin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Taschenlampe"+ Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edin
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
        String expectedIcerik= "Taschenlampe";
        Assert.assertTrue(sonucYazisi.getText().contains(expectedIcerik));

        // rapor icin sayfanin fotografini cekin

        // 1.adim TakeScreenshot objesi olusturma
        TakesScreenshot tss= (TakesScreenshot) driver;

        // 2.adim fotografi kaydedecegimiz dosyayi olusturalim, dosya yolunu yazalim
        File tumsayfaScreenshot=new File("target/ScreenShot/tumsayfaScreenshot1.png");


        // 3.adim bir gecici dosya olusturup buna tss objesi ile cektigimiz fotografi kaydedelim
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici resmi asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciResim,tumsayfaScreenshot);











    }




}
