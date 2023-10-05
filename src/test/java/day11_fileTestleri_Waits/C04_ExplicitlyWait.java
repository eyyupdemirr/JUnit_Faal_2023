package day11_fileTestleri_Waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_ExplicitlyWait {






    //  //1. WebDriver ayarlarini implicitlyWait kullanmadan yapin
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Textbox’in etkin olmadigini(enabled) dogrulayın
    //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    //7. Textbox’in etkin oldugunu(enabled) dogrulayın.

    @Test
    public void test01(){

        //  //1. WebDriver ayarlarini implicitlyWait kullanmadan yapin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
       //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
       WebElement textbox= driver.findElement(By.xpath("//input[@type='text']"));

        Assert.assertFalse(textbox.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();


          /*
            Explicit Wait ile beklemek icin
            1- beklemek icin wait objesi olusturalim
            2- hangi web element beklenecekse locate edelim
            3- belirledigimiz webelement ne icin bekletilecek ?
         */

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(45));
        // textbox locate edilmisti
        wait.until(ExpectedConditions.elementToBeClickable(textbox));







        WebElement enable=driver.findElement(By.xpath("//p[@id='message']"));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        Assert.assertTrue(enable.isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textbox.isEnabled());



        ReusableMethods.bekle(3);
        driver.close();


    }



}
