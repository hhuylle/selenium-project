package com.cydeo.tests.day09_review_javaFaker_driverUtil;

import com.cydeo.tests.Utilities.BrowserUtils;
import com.cydeo.tests.Utilities.ConfigurationReader;
import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T2_DriverUtil_Practice {

    //TC #1: Bing search

    //Use `configuration.properties` for the following:
    //1. The browser type
    //2. The URL
    //3. The search keyword
    //4. Make title verification dynamic. If search value changes, title
    //assertion should not fail.



    @Test
    public void bing_search_test1(){

        //2- Go to: https://bing.com
        // driver.get(ConfigurationReader.getProperties("bingURL"));


        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));

        //3- Write “apple” in search box
        //Locate the search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@type='search']"));

        BrowserUtils.sleep(3);

        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search
        //Expected: flowers - Search

        String actualTitle = Driver.getDriver().getTitle();

        //We are just making the expectedTitle dynamic based on the text we are searching
        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Search";

        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }

    @Test
    public void bing_search_test2(){

        //2- Go to: https://bing.com
        // driver.get(ConfigurationReader.getProperties("bingURL"));


        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));

        //3- Write “apple” in search box
        //Locate the search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@type='search']"));

        BrowserUtils.sleep(3);

        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search
        //Expected: flowers - Search

        String actualTitle = Driver.getDriver().getTitle();

        //We are just making the expectedTitle dynamic based on the text we are searching
        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Search";

        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }

    @AfterMethod
    public void tearDownMethod(){
        // We will not be using the selenium's quite method directly anymore
        //Driver.getDriver().quit(); --> no more using this method
        // We will use .closeDriver() method
        Driver.closeDriver();
    }
}
