package day09_iframe_cokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_Iframe extends TestBase {

    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke
    //   (https://www.guru99.com/live-selenium-project.html) tıklayınız


    @Test
    public void test01(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        WebElement cokiesElement= driver.findElement(By.id("gdpr-consent-notice"));
        driver.switchTo().frame(cokiesElement);

       //cookies kabul etmeliyiz
        driver.findElement(By.xpath("//*[text()='Tümünü Kabul Et']")).click();

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeList=driver.findElements(By.tagName("iframe"));
        System.out.println("sayfadaki iframe sayisi "+iframeList.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.

        WebElement youtubeIframeElement=driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
                //driver.findElement(By.xpath("//iframe[@wmode='transparent']"));   driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(youtubeIframeElement);

        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        driver.switchTo().defaultContent();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke

        WebElement jmeterIframe= driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(jmeterIframe);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();



    }







}
