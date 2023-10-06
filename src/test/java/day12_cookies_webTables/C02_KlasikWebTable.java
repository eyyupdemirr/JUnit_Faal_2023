package day12_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_KlasikWebTable extends TestBase {
    @Test
    public void test01(){

        //1.“https://www.amazon.com” adresine gidin
        //2.Sayfanin en altina inin
        //3.Web table tum body’sini yazdirin
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        //5.Tum satirlari yazdirin
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        //7. 5.sutunu yazdirin
        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun


        //1.“https://www.amazon.com” adresine gidin
        driver.get("https://www.amazon.com");

        //2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.END).perform();
        bekle(3);

        //3.Web table tum body’sini yazdirin
        WebElement tableAmazon=driver.findElement(By.className("navFooterMoreOnAmazon"));
        System.out.println(tableAmazon.getText());

        //4.Web table’daki satir sayisinin 7 oldugunu test edin

        List<WebElement> satirlarListesi= driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatir=7;
        int actualSatir=satirlarListesi.size();
        Assert.assertEquals(expectedSatir,actualSatir);
        bekle(2);

        //5.Tum satirlari yazdirin
        for (int i = 0; i < satirlarListesi.size(); i++) {

            System.out.println((i+1)+" inci satir ---   "+satirlarListesi.get(i).getText());
        }


        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> sutunSAyisis=driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedSS=13;
        int actualSS=sutunSAyisis.size();

        Assert.assertEquals(expectedSatir,actualSatir);

        //7. 5.sutunu yazdirin
        List<WebElement> besSutun=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        System.out.println("============= besinci Sutun" +                "     ");
        for (WebElement each:besSutun
             ) {
            System.out.println(each.getText());
        }

        //8.Satir ve sutun sayisini parametre olarak alip,
        //  hucredeki bilgiyi String olarak döndüren bir method olusturun
        System.out.println("========== method ile gelen datalar =========");

        System.out.println(hucredekiBilgi(3, 5));
        System.out.println(hucredekiBilgi(5, 7));

        bekle(2);




    }
    public String hucredekiBilgi(int satirNo,int sutunNo){
        ////    //tr[   5    "]/td["   3      ]

   //   String dinamikXpath="//tr["+satir+"//td["+sutun+"]";
        String dinamikXpath = "//tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenDataElementi=driver.findElement(By.xpath(dinamikXpath));
    return istenenDataElementi.getText();

    }



}

