package com.cydeo.tests.base;

import com.cydeo.tests.Utilities.ConfigurationReader;
import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

// This class is the parent if all Test classes
// You will update this t classes instead writing in all test classes, you just write in this class, and you can extend this class from any classclass based on what you are keep writing in your most tes
public abstract class TestBase { // This class abstract because preventing to create objects

    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        // Driver class will handle driver setting line of codes
        // Since we are using Driver class, we will not need to use setting up browser drivers codes
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // After we implement Driver class singleton design pattern in our project
        // We will not need above codes instead we will determine common line of codes from the most tests
        // Method to implement in this class

        // We can use this class for navigating to the page
        // driver.get("URL of app");
    }

    @AfterMethod
    public void tearDownMethod(){
        //driver.quit();
        //driver.close();
        //Driver.closeDriver();

        //Taking screenshot here to get screenshot of failing Test after they'd done
    }

}
