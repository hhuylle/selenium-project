package com.cydeo.tests.sunday_reviews.week3;

import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertPractice {

    // TC : Alert practice

    @BeforeMethod
    public void setupMethod(){

        // 1. Open browser
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        Driver.getDriver().get("https://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alert_practice_test(){

        // 3. Click to “Click for JS Prompt” button
        Driver.getDriver().findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();


        // 4. Send “hello” text to alert
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys("hello");

        // 5. Click to OK button from the alert
        alert.accept();

        // 6. Verify “You entered: hello” text is displayed.
        WebElement helloText = Driver.getDriver().findElement(By.id("result")); // we can use xpath //p[@id='result']

        String expectedText = "You entered: hello";
        String actualText = helloText.getText();

        Assert.assertEquals(actualText, expectedText);

    }
}
