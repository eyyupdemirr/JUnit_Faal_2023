package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {


    public static void bekle(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void tumSayfaFotoCek(WebDriver driver,String resimAdi) {
        // her screenshot'in benzersiz bir isme sahip olmasi icin
        // 1- method'un cagrildigi yerden resim adi yollanacak
        // 2- sonuna tarih etiketi ekleyelim 2310062013

        LocalDateTime ldt= LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi=ldt.format(formatter);

        String dinamikDosyaYolu="target/ScreenShot/"  + tarihEtiketi + resimAdi + ".jpg";


        // 1.adim TakeScreenshot objesi olusturma
        TakesScreenshot tss= (TakesScreenshot) driver;

        // 2.adim fotografi kaydedecegimiz dosyayi olusturalim, dosya yolunu yazalim
       File tumSayfaSS=new File(dinamikDosyaYolu);

        // 3.adim bir gecici dosya olusturup buna tss objesi ile cektigimiz fotografi kaydedelim
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici resmi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void webElementFotoCek(WebElement webElement, String resimAdi) {
        // her screenshot'in benzersiz bir isme sahip olmasi icin
        // 1- method'un cagrildigi yerden resim adi yollanacak
        // 2- sonuna tarih etiketi ekleyelim 2310062013

        LocalDateTime ldt= LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi=ldt.format(formatter);

        String dinamikDosyaYolu="target/ScreenShot/"  + tarihEtiketi + resimAdi + ".jpg";




        // 2.adim fotografi kaydedecegimiz dosyayi olusturalim, dosya yolunu yazalim
        File tumSayfaSS=new File(dinamikDosyaYolu);

        // 3.adim bir gecici dosya olusturup buna tss objesi ile cektigimiz fotografi kaydedelim
        File geciciDosya=webElement.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici resmi asil dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
