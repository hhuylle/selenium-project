package com.cydeo.tests.sunday_reviews.week3;

import com.cydeo.tests.Utilities.CRM_Utilities;
import com.cydeo.tests.Utilities.ConfigurationReader;
import com.cydeo.tests.Utilities.Driver;
import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframePractice extends TestBase {

    // TC : Iframe practice


    @Test
    public void sendingMessage_iframe_test(){

        // 1. Users are already login and on the homepage of CRM app
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        CRM_Utilities.loginCRM(Driver.getDriver(),ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));

        // 2. Users click the MESSAGE tab
        Driver.getDriver().findElement(By.xpath("//span[.='Message']")).click();

        // 3. Users write test message
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));

        WebElement messageFrame = Driver.getDriver().findElement(By.tagName("body"));
        messageFrame.sendKeys("Hello everyone!");

        // 4. Users click the SEND button
        Driver.getDriver().switchTo().defaultContent(); // it will take to the main HTML
        Driver.getDriver().findElement(By.xpath("//button[" +
                "@id='blog-submit-button-save']")).click();

        // 5. Verify the message is displayed on the feed
        WebElement feedMsg = Driver.getDriver().findElement(By.xpath("//div[contains(@id,'blog_post_body')]"));
        String expectedMsg = "Hello everyone!";
        String actualMsg = feedMsg.getText();

        Assert.assertEquals(actualMsg,expectedMsg);

    }

}
