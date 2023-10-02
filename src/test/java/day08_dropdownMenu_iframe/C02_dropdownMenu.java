package day08_dropdownMenu_iframe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import utilities.TestBase_BeforeClass;

import java.util.List;

public class C02_dropdownMenu extends TestBase_BeforeClass {

    WebElement kategoryElement;
    Select select;

    @Before
    public void amazonaGidis() {
        driver.get("https://www.amazon.com/");
        kategoryElement = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(kategoryElement);


    }


    /*
    ● https://www.amazon.com/ adresine gidin.

    - Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

	-Test 2
    1. Kategori menusunden Books secenegini secin
     2. Arama kutusuna Java yazin ve aratin
     3. Bulunan sonuc sayisini yazdirin
    4. Sonucun Java kelimesini icerdigini test edin
     */
    @Test
    public void ddTesti() {
    /* ● https://www.amazon.com/ adresine gidin.

    - Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

     */


        List<WebElement> kategoryList = select.getOptions();

        int expectedKatSay = 45;
        int actualKAtSAy = kategoryList.size();

        Assert.assertEquals(expectedKatSay, actualKAtSAy);
    }

    @Test
    public void javaaramaTesti() {
        /*
        -Test 2
     1. Kategori menusunden Books secenegini secin
     2. Arama kutusuna Java yazin ve aratin
     3. Bulunan sonuc sayisini yazdirin
     4. Sonucun Java kelimesini icerdigini test edin
         */

        select.selectByVisibleText("Books");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        WebElement aramaSonucu = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String expectedIcerik = "Java";
        String actualIcerik = aramaSonucu.getText();

        System.out.println(aramaSonucu.getText());
        Assert.assertTrue(expectedIcerik.contains(actualIcerik));

    }


}
