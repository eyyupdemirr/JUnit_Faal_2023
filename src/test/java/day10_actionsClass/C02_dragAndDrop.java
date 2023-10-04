package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_dragAndDrop extends TestBase {

    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin


    @Test
    public void test01(){

        //1- https://demoqa.com/droppable adresine gidelim
      driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim  .   //*[@*='draggable']

        WebElement suruklenecekElement= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement hedef=driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(suruklenecekElement,hedef).perform();
        bekle(4);


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement yazi=driver.findElement(By.xpath("//p[text()='Dropped!']"));

        Assert.assertEquals("Dropped!",yazi.getText());

        System.out.println(yazi.getText());



    }
}
