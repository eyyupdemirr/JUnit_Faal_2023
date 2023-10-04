package day10_actionsClass;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {


    //1- https://www.facebook.com adresine gidelim
    //2- Cookies kabul edin
    //3- Yeni hesap olustur butonuna basalim
    //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    //5- Kaydol tusuna basalim


    @Test
    public void test01() {
        driver.get("https://www.facebook.com");

        // driver.findElement(By.xpath("//button[@title='Alle Cookies erlauben']")).click();
        driver.findElement(By.xpath("//button[@title='Tüm çerezlere izin ver']")).click();


        //3- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("(//a[@*='button'])[2]")).click();


        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        driver.findElement(By.name("firstname")).click();

        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String eMail = faker.internet().emailAddress();


        actions.sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(eMail)
                .sendKeys(Keys.TAB)
                .sendKeys(eMail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("1")
                .sendKeys(Keys.TAB)
                .sendKeys("Eki")
                .sendKeys(Keys.TAB)
                .sendKeys("2003")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT)
                .perform();


        //5- Kaydol tusuna basalim
        driver.findElement(By.name("websubmit")).click();
        bekle(10);

    }


}
