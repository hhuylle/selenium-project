package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_dropdown_Intro {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        //TC#5: Verifying “Simple dropdown” and “State selection” dropdown
        //default values
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void simpleDropdownTest(){


        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”

        //Locating the dropdown as a web element
        WebElement simpleDropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));

        //Creating Select class object, and passing te dropdown web element into the constructor
        Select select = new Select(simpleDropdown);

        String expectedDefaultValue = "Please select an option";

        //Actual:
        String actualDefaultValue = select.getFirstSelectedOption().getText();

        //Do our assertion
        Assert.assertEquals(actualDefaultValue, expectedDefaultValue);
        Assert.assertTrue(actualDefaultValue.equals(expectedDefaultValue));

        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”
        WebElement stateSelectionDropdown = driver.findElement(By.xpath("//select[@id='state']"));

        Select select1 = new Select(stateSelectionDropdown);

        String expectedDefaultValue2 = "Select a State";

        String actualDefaultValue2 = select1.getFirstSelectedOption().getText();

        Assert.assertEquals(actualDefaultValue2,expectedDefaultValue2);
        Assert.assertTrue(actualDefaultValue2.equals(expectedDefaultValue2));


    }
}
