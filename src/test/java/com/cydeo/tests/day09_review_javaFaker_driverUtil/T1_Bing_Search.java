package com.cydeo.tests.day09_review_javaFaker_driverUtil;

import com.cydeo.tests.Utilities.BrowserUtils;
import com.cydeo.tests.Utilities.ConfigurationReader;
import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_Bing_Search {

    //TC #1: Bing search

    //Use `configuration.properties` for the following:
    //1. The browser type
    //2. The URL
    //3. The search keyword
    //4. Make title verification dynamic. If search value changes, title
    //assertion should not fail.

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        //1- Open a Chrome browser
        String browserType = ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- Go to: https://bing.com
        driver.get(ConfigurationReader.getProperty("bingURL"));
    }

    @Test
    public void bing_search_test(){

        //3- Write “apple” in search box
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@type='search']"));

        BrowserUtils.sleep(3);

        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search
        //Expected: flowers - Search
        //We are just making the expectedTitle dynamic based on the text we are searching
        String actualTitle = driver.getTitle();
        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Search";

        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }
}
