package ubung;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class U1 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            /*
            1- C01_TekrarTesti isimli bir class olusturun
            2- https://www.google.com/ adresine gidin
            3- cookies uyarisini kabul ederek kapatin
            4- Sayfa basliginin “Google” ifadesi icerdigini test edin
            5- Arama cubuguna “Nutella” yazip aratin
            6- Bulunan sonuc sayisini yazdirin
            7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
            8- Sayfayi kapatin
             */



        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        ReusableMethods.bekle(2);

        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("(//div[@class ='QS5gu sy4vM'])[2]")).click();

        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTittle="Google";
        String actuallTitle = driver.getTitle();

        if (actuallTitle.contains(expectedTittle)) {
            System.out.println("Tittle test is PASSED");
        } else {
            System.out.println("Tittle test is FAILED");

        }
        //5- Arama cubuguna “Nutella” yazip aratin

       WebElement ara= driver.findElement(By.id("APjFqb"));
        ara.sendKeys("nutella"+ Keys.ENTER);

        //6- Bulunan sonuc sayisini yazdirin
       WebElement sonuc= driver.findElement(By.id("result-stats"));
       String sonuc2=sonuc.getText().replaceAll("\\D","");
        System.out.println(sonuc2);





        String sonuc1=sonuc.getText();
        sonuc1.replaceAll("\\D","");
        System.out.println("aaaaaaaaaaaaaa"+sonuc1);


        ReusableMethods.bekle(4);
        //driver.close();






    /*

    public static void main(String[] args) {
        //1- C01_TekrarTesti isimli bir class olusturun
        //2- https://www.google.com/ adresine gidin
        //3- cookies uyarisini kabul ederek kapatin
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        //5- Arama cubuguna “Nutella” yazip aratin
        //6- Bulunan sonuc sayisini yazdirin
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        //8- Sayfayi kapatin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        ReusableMethods.bekle(4);
        ReusableMethods.bekle(4);
        //3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("(//div[@class ='QS5gu sy4vM'])[2]")).click();
        //driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click(); copyXpath'li cozum
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTittle = "Google";
        String actuallTitle = driver.getTitle();
        if (actuallTitle.contains(expectedTittle)) {
            System.out.println("Tittle test is PASSED");
        } else {
            System.out.println("Tittle test is FAILED");
        }
        //5- Arama cubuguna “Nutella” yazip arati
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@jsname='yZiJbe']")); //Xpathli cozum
        //WebElement searchBox = driver.findElement(By.id("APjFqb")); //id'li cozum
        searchBox.click();
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        //6- Bulunan sonuc sayisini yazdirin
        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Sonuc: " + result.getText()); //Sonuc: Yaklaşık 153.000.000 sonuç bulundu (0,30 saniye
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonuc = result.getText();
        String[] sonucArr = new String[5];
        sonucArr = sonuc.split(" ");
        String sonucNumara = sonucArr[1];
        sonucNumara = sonucNumara.replace(".", "");
        System.out.println(sonucNumara); //15300000
        int sonucNumaraInt = Integer.parseInt(sonucNumara);
        int expectedNumber = 10000000;
        if (sonucNumaraInt > expectedNumber) {
            System.out.println("10 milyon tesi PASSED");
        } else {
            System.out.println("10 milyon testi FAILED");
            //8- Sayfayi kapatin
            ReusableMethods.bekle(2);
            driver.close();
        }
    }
    *************************

    1) Google a gidip Selectors Hub yazıp tıklıyorsun.
2) SelectorsHub'ı Chrome'a ekle çıkıyor, ona tıklıyorsun.
3) O uzantıyı Chrome'a ekliyor.




     */










    }
}
