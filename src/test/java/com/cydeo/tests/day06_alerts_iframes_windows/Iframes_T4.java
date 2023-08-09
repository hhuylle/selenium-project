package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Iframes_T4 {

    //1. Create a new class called: T4_Iframes
    //2. Create new test and make set ups
    //3. Go to: https://practice.cydeo.com/iframe


    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/iframe");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void iframe_Test(){

        // We have to switch to iframe to be able to locate the web element in there
        //Option #1 - switch "id" attribute value:
        driver.switchTo().frame("mce_0_ifr");

        //Option #2: - switch using index number:
        //driver.switchTo().frame(0);

        //Option #3 - switch using WebElement:
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        WebElement paragraphText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(paragraphText.isDisplayed());

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame(); // use parentFrame() to go back just 1 layer
        //driver.switchTo().defaultContent(); // use defaultContent() method to go back to main HTML

        WebElement headerText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(headerText.isDisplayed());

    }
}
