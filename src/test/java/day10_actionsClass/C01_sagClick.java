package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C01_sagClick extends TestBase {

    /*
    2- https://the-internet.herokuapp.com/context_menu sitesine gidin
    3- Cizili alan uzerinde sag click yapin
    4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
    5- Tamam diyerek alert’i kapatalim
    6- Elemental Selenium linkine tiklayalim
    7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
     */

        @Test
    public void tes01(){
                //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
            driver.get("https://the-internet.herokuapp.com/context_menu");
           String ilksayfaWhd= driver.getWindowHandle();

                // 3- Cizili alan uzerinde sag click yapin
            WebElement taraliAlan=driver.findElement(By.id("hot-spot"));
            Actions actions=new Actions(driver);
            actions.contextClick(taraliAlan).perform();

                //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
            String expectedAlertYazi="You selected a context menu";
            String actaualAlertYazi=driver.switchTo().alert().getText();

            Assert.assertEquals(actaualAlertYazi,expectedAlertYazi);

                //5- Tamam diyerek alert’i kapatalim
          driver.switchTo().alert().accept();


            // 6- Elemental Selenium linkine tiklayalim
            WebElement seleniumLink= driver.findElement(By.linkText("Elemental Selenium"));
            seleniumLink.click();
            String ikincisayfaWhd= "";

            Set<String> handleList=driver.getWindowHandles();

            for (String each:handleList
                 ) {
                if (!each.equals(ilksayfaWhd))
                    ikincisayfaWhd=each;
            }



                    //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
            driver.switchTo().window(ikincisayfaWhd);
            String expectedYazi="Make sure your code lands";
            String actualYAzi=driver.findElement(By.tagName("h1")).getText();

            Assert.assertEquals(expectedYazi,actualYAzi);







        }


}
