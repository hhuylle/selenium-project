package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.tests.Utilities.BrowserUtils;
import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class T1_WindowsHandling {

    //TC #1: Window Handle practice

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make set-ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");

    }

    @AfterMethod
    public void tearDownMethod(){

        driver.quit();
    }

    @Test
    public void windows_handling_test(){

        //3. Copy and paste the lines from below into your class
        //These lines will simply open new tabs using something called JavascriptExecutor
        // We will learn JavascriptExecutor later as well
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open

        //Return and store all window handles in s Set
        Set<String> allWindowHandles= driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);
            System.out.println("Current URL: "+driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains("etsy")){
                break;
            }
        }

        //5. Assert: Title contains “Etsy”
        String expectedInTitle = "Etsy";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));


    }

    @Test
    public void windows_handling_test2(){

        //3. Copy and paste the lines from below into your class
        //These lines will simply open new tabs using something called JavascriptExecutor
        // We will learn JavascriptExecutor later as well
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open

        BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");

        //5. Assert: Title contains “Etsy”
        //String expectedInTitle = "Etsy";
        //String actualTitle = driver.getTitle();

        //Assert.assertTrue(actualTitle.contains(expectedInTitle));
        BrowserUtils.verifyTitleContains(driver, "Etsy");

    }

}