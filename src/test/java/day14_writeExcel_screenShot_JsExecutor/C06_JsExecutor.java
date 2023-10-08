package day14_writeExcel_screenShot_JsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_JsExecutor extends TestBase {

    @Test
    public void test01(){
        // wisequarter anasayfasina gidin
        driver.get("https://www.wisequarter.com");

        // alt kisimda bulunan “Go To Career Page” butonuna kadar asagi inin
        WebElement buttonElementi=driver.findElement(By.xpath("(//a[@href='https://wisequarter.com/career/'])[10]"));
        // WebElement goToCareerElementi = driver.findElement(By.xpath("(//a[@href='https://wisequarter.com/career/'])[10]"));
        //buttonElementi.click();

        JavascriptExecutor jse= (JavascriptExecutor) driver;
        bekle(2);

        jse.executeScript("arguments[0].scrollIntoView(true);", buttonElementi);
        bekle(2);

        // ve bu butona click yapin

        jse.executeScript("arguments[0].click();", buttonElementi);
        bekle(3);
        jse.executeScript("alert('yasasinnnn');");

        bekle(3);


        }
}
