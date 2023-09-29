package ubung;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class U2 {
    //1. Bir Class olusturalim YanlisEmailTesti
    //2. http://automationpractice.pl/index.php sayfasina gidelim
    //3. Sign in butonuna basalim
    //4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid
    //email address” uyarisi ciktigini test edelim
    WebDriver driver;

    @Test
    public void emailTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://automationpractice.pl/index.php");
        //3. Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();
        //4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("asd.asd.com");
        driver.findElement(By.xpath("//button[@class='btn btn-default button button-medium exclusive']")).click();
        WebElement invalidPassword = driver.findElement(By.xpath("//*[contains(text(),'Invalid email address.')]"));
        //System.out.println(invalidPassword.getText());
        Assert.assertTrue("****invalid password pop-up has been showed*******", invalidPassword.isDisplayed());
    }

    @After
    public void teardown() {
        ReusableMethods.bekle(3);
        driver.close();
    }
}

















/*
1. http://zero.webappsecurity.com/ Adresine gidin
2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
kontrol edin.
 */