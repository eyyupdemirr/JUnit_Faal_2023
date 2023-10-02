package day08_dropdownMenu_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C01_dropdownMenu extends TestBase {
    /*
    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
     1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
     2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
            3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5. Dropdown’un boyutunun 4 olduğunu test edin

     */

    @Test
    public void ddTest(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement ddElementi= driver.findElement(By.xpath("//select[@id='dropdown']"));

        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        Select select=new Select(ddElementi);

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());


        //  4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> optionsList=select.getOptions();
        System.out.println(select.getOptions());         // list oldugu icin direk yazdiramayiz

        for (WebElement each:optionsList
             ) {
           // System.out.println(select.getFirstSelectedOption().getText());
            System.out.println(each.getText());
        }

        //5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedBoyut=4;
        int actualBoyut=optionsList.size();

        Assert.assertEquals("failed cikinca cikacak yazi",expectedBoyut,actualBoyut);


    }

}
