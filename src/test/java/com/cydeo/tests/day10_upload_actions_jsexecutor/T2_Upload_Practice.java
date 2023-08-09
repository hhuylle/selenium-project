package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {


    @Test
    public void upload_practice_test(){

        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        String path = "C:\\Users\\hhuyl\\OneDrive\\Desktop\\Hello World.txt";

        //3. Upload the file.
        //Use sendKeys() method and pass the "path" as a String.
        WebElement chooseFileButton = Driver.getDriver().findElement(By.id("file-upload"));
        chooseFileButton.sendKeys(path);
        //chooseFileButton.sendKeys("C:\\Users\\hhuyl\\OneDrive\\Desktop\\Hello World.txt");

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        //4. Assert:
        //-File uploaded text is displayed on the page
        WebElement fileUploadedText = Driver.getDriver().findElement(By.xpath("//div[@class='example']")); // By.tagName("h3")

        Assert.assertTrue(fileUploadedText.isDisplayed());

        Driver.closeDriver();

    }
}
