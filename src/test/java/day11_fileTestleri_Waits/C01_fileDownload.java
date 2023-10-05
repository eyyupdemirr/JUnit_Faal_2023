package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_fileDownload extends TestBase {

    @Test
    public void test01(){

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. logo.jpg dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='logo.jpg']")).click();

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyayolu="C:\\Users\\ludwi\\Downloads";
        bekle(11);

        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));






        //   C:\Users\ludwi\OneDrive\Desktop

        //   C:\Users\ludwi\Downloads

    }











}
