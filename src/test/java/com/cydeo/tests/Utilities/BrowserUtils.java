package com.cydeo.tests.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class BrowserUtils {

    /*
    This class will be storing only the utility method that can be used across the project
     */

    /*
    This method will accept int (in seconds)
    and execute Thread.sleep method for given duration
    Arg: int second
     */

    public static void sleep(int second){

        //TC #2: Create utility method
        //1. Create a new class called BrowserUtils
        //2. Create a method to make Task1 logic re-usable
        //3. When method is called, it should switch window and verify title.
        //Method info:
        //• Name: switchWindowAndVerify
        //• Return type: void
        //• Arg1: WebDriver
        //• Arg2: String expectedInUrl
        //• Arg3: String expectedTitle

        second *= 1000;

        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle){

        Set<String> allWindowHandles= driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);
            System.out.println("Current URL: "+driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    public static void verifyTitle(WebDriver driver, String expectedTitle){

        //TC #3: Create utility method
        //1. Create a new method for title verification
        //2. Create a method to make title verification logic re-usable
        //3. When method is called, it should simply verify expected title with actual
        //title
        //Method info:
        //• Name: verifyTitle()
        //• Return type: void
        //• Arg1: WebDriver
        //• Arg2: String expectedTitle

        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }

    public static void verifyTitleContains(WebDriver driver, String expectedInTitle){

        Assert.assertTrue(driver.getTitle().contains(expectedInTitle));
    }

    public static void waitForInvisibilityOf(WebElement target){

        //Create the object of'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //Use 'wait' object with proper syntax to create explicit wait conditions
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    public static void waitForTitleContains(String title){

        //Create the object of'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //Use 'wait' object with proper syntax to create explicit wait conditions
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void clickOption(WebDriver driver, String option){

        driver.findElement(By.linkText(option)).click();
    }

    public static WebElement waitForClickAbility(WebDriver driver,WebElement element){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
