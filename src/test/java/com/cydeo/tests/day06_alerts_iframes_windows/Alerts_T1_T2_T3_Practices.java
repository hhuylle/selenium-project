package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts_T1_T2_T3_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDown(){

    }

    @Test
    public void information_alert_Test1(){

        //3. Click to “Click for JS Alert” button
        WebElement infoAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        infoAlertButton.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        //Failure message will only be displayed if assertion fail
        Assert.assertTrue(resultText.isDisplayed(),"Result Text is not displayed!");

        String expectedText = "You successfully clicked an alert";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText,expectedText,"Actual result text is NOT expected result text!");

    }

    @Test
    public void confirmation_alert_Test2(){

        //3. Click to “Click for JS Confirm” button
        WebElement confirmAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmAlertButton.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultText.isDisplayed());
    }

    @Test
    public void prompt_alert_Test3(){

        //3. Click to “Click for JS Prompt” button
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promptAlertButton.click();

        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

        //5. Click to OK button from the alert
        alert.accept();

        //6. Verify “You entered: hello” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultText.isDisplayed());

    }


}
