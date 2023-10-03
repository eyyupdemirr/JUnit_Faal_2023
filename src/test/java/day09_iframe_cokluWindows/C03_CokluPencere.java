package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_CokluPencere extends TestBase {

    // amazon ana sayfaya gidip url'in amazon icerdigini test edin
    // yeni bir tab'da wisequarter.com'a gidin ve url'in wise icerdigini test edin
    // yeni bir pencere olarak youtube'a gidin ve url'in youtube icerdigini test edin
    // wisequarter'in acik oldugu sayfaya donup title'in Wise icerdigini test edin
    // Amazon'un acik oldugu sayfaya donun ve Title'in Amazon icerdigini test edin


    @Test
    public void test01() {
        // amazon ana sayfaya gidip url'in amazon icerdigini test edin

        driver.get("https://www.amazon.com");
        String expectedUrlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        String amazonHD=driver.getWindowHandle();

        // yeni bir tab'da wisequarter.com'a gidin ve url'in wise icerdigini test edin

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String expectedIcerik="wise";
        String actualIcerik=driver.getCurrentUrl();
        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        String wiseWHD=driver.getWindowHandle();

        // yeni bir pencere olarak youtube'a gidin ve url'in youtube icerdigini test edin

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
       // String expectedUrlIcerik="youtube";   bunu kabul etmedi cunku yukarida ayni isim var
        expectedUrlIcerik="youtube";          // bu yuzden bizde deger atamasi yoluyla devam ediyoruz

        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrlIcerik));

        // wisequarter'in acik oldugu sayfaya donup title'in Wise icerdigini test edin

        driver.switchTo().window(wiseWHD);
        String expectedTitleIcerik="Wise";
        Assert.assertTrue(driver.getTitle().contains(expectedTitleIcerik));

        // Amazon'un acik oldugu sayfaya donun ve Title'in Amazon icerdigini test edin
        driver.switchTo().window(amazonHD);
        expectedTitleIcerik="Amazon";

        Assert.assertTrue(driver.getTitle().contains(expectedTitleIcerik));


        bekle(3);








    }

}
