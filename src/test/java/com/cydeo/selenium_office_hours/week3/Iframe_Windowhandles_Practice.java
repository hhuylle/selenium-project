package com.cydeo.selenium_office_hours.week3;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Iframe_Windowhandles_Practice extends TestBase {

    //Task 1:  Iframe-window handles

    //Test website: http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target

    //Test Scenario:



    @Test
    public void iframe_windowhandles_test(){

        //Step 1- Go to the above URL.
        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");

        //Step 2- Get the current window’s handle and write to the console window. It must be the first window handle.
        // We store main window handle from beginning to use it in next coming lines, if any step wants us to go back o main window
        String mainWindowHandle = driver.getWindowHandle();

        //driver.switchTo().frame(2); This is not good option
        driver.switchTo().frame("iframeResult");
        //driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        System.out.println("Main Window Handle = " + mainWindowHandle);

        //Step 3- Locate the “Visit W3Schools.com!” link and click it.
        WebElement visitLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
        visitLink.click();
        //BrowserUtils.sleep(1);

        //Step 4- Get all window handles and hold them in a Set.
        Set<String> allWindowHandles = driver.getWindowHandles();



        //Step 5- Write to total window handle number to the console. It must be 2.
        System.out.println("allWindowHandles.size() = " + allWindowHandles.size());

        //Step 6- Switch to the second window.
        // each loop is the only way to switch between different windows
        for (String eachWindow : allWindowHandles) {
            driver.switchTo().window(eachWindow);
        }

        //Step 7- Get the current window’s handle and write to the console window. It must be a second window handle.
        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("Current Window Handle = " + currentWindowHandle);

        //Step 8- Check the upper left side logo in the second window.
        WebElement logo = driver.findElement(By.xpath("//a[@title='Home']/i"));
        // can use double //i if there only has one 'i' attribute

        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed");

        //Step 9- Go back (Switch) to the first window.
        driver.switchTo().window(mainWindowHandle);

        //Step 10- Get the current window’s handle and write to the console window. It must be the first window handle.
        System.out.println("Main Window Handle = " + driver.getWindowHandle());

        //Step 11- Check the See Run Button Text. It must contain “Run >” text.
        WebElement runButton = driver.findElement(By.id("runbtn"));

        String expectedText = "Run ❯";
        String actualText = runButton.getText();

        Assert.assertTrue(actualText.contains(expectedText));
    }
}
