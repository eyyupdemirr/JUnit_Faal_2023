package day06_notations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_Before_AfterNotasyonlari {

    /*
     // 3 test method'u olusturup asagidaki gorevleri
    // bagimsiz olarak calisabilecek sekilde olusturun
    // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin
    // 2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin
    // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin
     */
    WebDriver driver;

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void amazonTest() {


        setup();
        driver.get("https://www.amazon.com");

        String expectedUrl = "amazon";

        if (driver.getCurrentUrl().contains(expectedUrl)) {
            System.out.println("Amazon url Passed");
        } else {
            System.out.println("Amazon url Failed");
        }

        ReusableMethods.bekle(2);
        driver.close();
    }

    @Test
    public void wiseTesti() {
        setup();
        driver.get("https://www.wisequarter.com");
        String expectedUrl = "Wise";

        if (driver.getCurrentUrl().contains(expectedUrl)) {
            System.out.println("Wise url Passed");
        } else {
            System.out.println("Wise url Failed");
        }

        ReusableMethods.bekle(2);
        driver.close();
    }

    @Test
    public void youtubeTesti(){
        // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin
        setup();
        driver.get("https://www.youtube.com");

        String unexpectedTitleIcerik = "best";

        String actualTitle = driver.getTitle();

        if (actualTitle.contains(unexpectedTitleIcerik)){
            System.out.println("Youtube testi FAILED");
        }else{
            System.out.println("Youtube testi PASSED");
        }
        driver.close();

}}
