package com.cydeo.tests.sunday_reviews.week2;

import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T3_RegistrationFormPagePractice {



        // TC#3: Registration Form Page Testing

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/registration_form
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/registration_form");
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }

    @Test
    public void registrationFormPage(){

        // 3. Verify title is as expected:
        // Expected: "Registration Form"
        String expectedTitle = "Registration Form";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.equals(expectedTitle),"Title verification FAILED!");
    }
}
