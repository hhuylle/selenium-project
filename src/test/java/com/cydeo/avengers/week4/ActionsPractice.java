package com.cydeo.avengers.week4;

import com.cydeo.tests.Utilities.BrowserUtils;
import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsPractice extends TestBase {

    //Task#1: Actions Practice
    //



    @Test
    public void actions_test(){
        //    - Go to  "https://www.globalsqa.com/demo-site/draganddrop/"
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        //    - Drag and Drop "High Tatras" and "High Tatras 2" into "Trash"
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame.lazyloaded")));

        WebElement highTatras = driver.findElement(By.xpath("//h5[.='High Tatras']"));
        WebElement highTatras2 = driver.findElement(By.xpath("//h5[.='High Tatras 2']"));
        WebElement trash = driver.findElement(By.id("trash"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(highTatras, trash)
                        .dragAndDrop(highTatras2,trash)
                                .perform();
        BrowserUtils.sleep(2);
        //    - Verify Trash has 2 photo
        List<WebElement> trashImgs = driver.findElements(By.xpath("//div[@id='trash']//li"));
        Assert.assertTrue(trashImgs.size()==2);

    }
}
