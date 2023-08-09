package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_TestNG_Selenium_Intro {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        //TC #4: Practice Title Verification
        //1. Open Chrome browser
        //2. Go to https://www.practice.cydeo.com
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void test1_cydeo_title_verification(){

        //3. Verify title:
        //Expected: Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);


    }
}
