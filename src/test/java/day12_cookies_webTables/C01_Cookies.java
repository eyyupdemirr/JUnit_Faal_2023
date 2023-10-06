package day12_cookies_webTables;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C01_Cookies extends TestBase {


    //1- Amazon anasayfaya gidin
    //2- tum cookie’leri listeleyin
    //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
    //6- eklediginiz cookie’nin sayfaya eklendigini test edin
    //7- ismi skin olan cookie’yi silin ve silindigini test edin
    //8- tum cookie’leri silin ve silindigini test edin


    @Test
    public void test01() {
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();
        // System.out.println(cookieSet);        //set oldugu icin direk yazdirabiliyoruz.(index desteklemez,foreach)
        // bu sekilde yazdirinca kac cookie oldugu, ve bunlarin neler oldugu anlasilmiyor

        int siraNo = 1;
        for (Cookie each : cookieSet
        ) {
            System.out.println(siraNo + " -" + each);
            siraNo++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedCookieSayisi = 5;
        int actulaCookieSayisi = cookieSet.size();

        Assert.assertTrue(actulaCookieSayisi > expectedCookieSayisi);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedCookievalue = "USD";
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();

        Assert.assertEquals(expectedCookievalue, actualCookieValue);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(yeniCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        System.out.println("====================yeni======================");

        cookieSet = driver.manage().getCookies();
        siraNo = 1;
        for (Cookie each : cookieSet
        ) {
            System.out.println(siraNo + " -" + each);
            siraNo++;
        }

        boolean yeniCookieEklendimi = false;

        for (Cookie each : cookieSet
        ) {
            if (each.getName().equals("en sevdigim cookie")) {
                yeniCookieEklendimi = true;
            }

        }

        Assert.assertTrue(yeniCookieEklendimi);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        System.out.println("========== skin silindikten sonra========== ");
        cookieSet =  driver.manage().getCookies();
        siraNo= 1;

        for (Cookie each : cookieSet
        ) {
            System.out.println(siraNo + "  -   " + each);
            siraNo++;
        }

        boolean skinSilindiMi = true;

        for (Cookie each : cookieSet
        ) {
            if (each.getName().equals("skin")){
                skinSilindiMi = false ;
            }
        }
        // en sonda testin passed olmasi icin skinSilindiMi ===> true olmali
        Assert.assertTrue(skinSilindiMi);


        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        cookieSet =  driver.manage().getCookies();

        int expectedSize=0;
        int actualsize=cookieSet.size();

        Assert.assertEquals(expectedSize,actualsize);







        bekle(2);


    }


}
