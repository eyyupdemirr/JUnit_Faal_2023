package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C06_Deneme extends TestBase {

   /* ● https://the-internet.herokuapp.com/windows adresine gidin.
            ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
            ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
            ● Click Here butonuna basın.
            ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            ● Sayfadaki textin “New Window” olduğunu doğrulayın.
            ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.*/

    @Test
    public void cokluPencereTesti() {
        // https://the-internet.herokuapp.com/windows adresine gidin.

        String ilkSayfaWh = driver.getWindowHandle();
        System.out.println("****************************"+ilkSayfaWh);

        driver.get("https://the-internet.herokuapp.com/windows");

        //●   Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        WebElement yaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi = "Opening a new window";
        Assert.assertEquals(expectedYazi, yaziElementi.getText());  //once expected sonra actual


        //  ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        expectedYazi = "The Internet";
        Assert.assertEquals(expectedYazi, driver.getTitle());

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        String ilkSayfaWh1 = driver.getWindowHandle();
        System.out.println("11111111****************************"+ilkSayfaWh1);

        expectedYazi = "New Window";
        // Assert.assertEquals(expectedYazi,driver.getTitle());


        /*
            Bir linke tikladigimizda
            biz newWindow() kullanmadigimiz halde yeni sayfa aciliyorsa
            driver eski sayfada kalir
            yeni sayfada islem yapabilmek icin
            bizim driver'i yeni sayfaya gecirmemiz gerekir.

                */



        Set<String> wHdSeti = driver.getWindowHandles();

        System.out.println(ilkSayfaWh);
        System.out.println("Set Olanlar " + wHdSeti);            //set oldugu icin direk yazdirabiliyoruz


        String ikinciSayfam = "";

        for (String each : wHdSeti
        ) {
            if (!each.equals(ilkSayfaWh))
                ikinciSayfam = each;
        }


        // artik 2.sayfanin whd'ini bildigimiz icin, ikinci sayfaya gecis yapabiliriz
        driver.switchTo().window(ikinciSayfam);

        expectedYazi = "New Window";
        Assert.assertEquals(expectedYazi, driver.getTitle());

        //  ● Sayfadaki textin “New Window” olduğunu doğrulayın.

        expectedYazi = "New Window";

        Assert.assertEquals(expectedYazi, driver.findElement(By.tagName("h3")).getText());


        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın

        driver.switchTo().window(ilkSayfaWh);
        expectedYazi = "The Internet";

        Assert.assertEquals(expectedYazi, driver.getTitle());





    }


}
