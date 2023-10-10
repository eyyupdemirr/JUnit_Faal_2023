package day08_dropdownMenu_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSAlerts extends TestBase {


    @Test
    public void jsAlertTesti() {
        /*
      1. Test
     - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
         - 1.alert’e tiklayin
        - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
     - OK tusuna basip alert’i kapatin
         */


        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        String expectedYazi = "I am a JS Alert";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi, actualYazi);

        driver.switchTo().alert().accept();

    }

    @Test
    public void canselTest() {
        /*
        2.Test
        - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        - 2.alert’e tiklayalim
        - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String expectedsnucYazisi="You clicked: Cancel";
        String actualSonucYazisi=driver.findElement(By.id("result")).getText();

        Assert.assertEquals(expectedsnucYazisi,actualSonucYazisi);

    }


@Test
    public void prompTest(){


 /*
3.Test
 - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
 - 3.alert’e tiklayalim
 - Cikan prompt ekranina “Abdullah” yazdiralim
 - OK tusuna basarak alert’i kapatalim
 - Cikan sonuc yazisinin Abdullah icerdigini test edelim
     */

    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
   driver.switchTo().alert().sendKeys("Abdullah");
   driver.switchTo().alert().accept();
    WebElement sonucYazisielementi=driver.findElement(By.xpath("//*[text()='You entered: Abdullah']"));
   String expectedsonucYazisi="Abdullah";
   String actualSonucyazisi=sonucYazisielementi.getText();

   Assert.assertTrue(actualSonucyazisi.contains(expectedsonucYazisi));




}




}
