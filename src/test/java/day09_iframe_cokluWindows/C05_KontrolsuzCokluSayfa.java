package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C05_KontrolsuzCokluSayfa extends TestBase {

    // https://the-internet.herokuapp.com/iframe url'ine gidin

    // sayfa basliginin Internet icerdigini test edin

    // Elemental Selenium linkini tiklayin

    // Yeni acilan tab'in Title'inin Selenium icerdigini test edin

    // Ilk sayfaya donup url'in internet icerdigini test edin


    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/iframe url'ine gidin.

        driver.get("https://the-internet.herokuapp.com/iframe");
        String ilkSayfaWhd=driver.getWindowHandle();

        // sayfa basliginin Internet icerdigini test edin

        String expectedicerik = "Internet";

        Assert.assertTrue(driver.getTitle().contains(expectedicerik));

        // Elemental Selenium linkini tiklayin

        WebElement seleniumElementi= driver.findElement(By.linkText("Elemental Selenium"));
        seleniumElementi.click();

        // Yeni acilan tab'in Title'inin Selenium icerdigini test edin

        String ikinciSayfam="";
        Set<String> whdList=driver.getWindowHandles();

        for (String each:whdList
             ) {
            if (!each.equals(ilkSayfaWhd))
                ikinciSayfam=each;
        }

        driver.switchTo().window(ikinciSayfam);

        expectedicerik = "Selenium";

        Assert.assertTrue(driver.getTitle().contains(expectedicerik));


        // Ilk sayfaya donup url'in internet icerdigini test edin

        driver.switchTo().window(ilkSayfaWhd);

        expectedicerik = "internet";

        Assert.assertTrue(driver.getCurrentUrl().contains(expectedicerik));


    }


}
