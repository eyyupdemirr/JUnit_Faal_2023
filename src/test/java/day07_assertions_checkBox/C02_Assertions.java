package day07_assertions_checkBox;

//2) https://www.youtube.com adresine gidin
//3) Aşağıdaki adları kullanarak 4 test metodu oluşturun
//   ve gerekli testleri yapin
//  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
// cookiesi kabul edin
//  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
//  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
//  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;


public class C02_Assertions {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        ReusableMethods.bekle(3);
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response-inverse'])[2]")).click();
        // driver.findElement(By.xpath("//*[@id='content']/div[2]/div[6]/div[1]/ytd-button-renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));   bu olmadi
        //  driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[16]")).click();
    }


    @AfterClass
    public static void teardown() {
        ReusableMethods.bekle(3);
        driver.close();
    }


    @Test
    public void youtube() {
        //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin

        String expectedTitle = "YouTube";
        String titleTest = driver.getTitle();
        Assert.assertEquals(expectedTitle, titleTest);

    }
    @Test
    public void logo(){
        WebElement logo=driver.findElement(By.xpath("(//*[@class='yt-spec-icon-shape'])[5]"));

        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void searchBox()
    {
        //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchbox=driver.findElement(By.xpath("//div[@id='search-input']"));

        Assert.assertTrue(searchbox.isEnabled());


       // searchbox.click();
       // searchbox.sendKeys("aykut eren"+Keys.ENTER);


    }

    @Test
    public void wrongTitleTest(){
        //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String unExpectedTitle= "youtube";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(unExpectedTitle,actualTitle);
    }


    @Test
    public void arama(){
        WebElement arama=driver.findElement(By.xpath("//div[@id='search-input']"));





        arama.sendKeys("aykut eren "+Keys.ENTER);




    }



}
