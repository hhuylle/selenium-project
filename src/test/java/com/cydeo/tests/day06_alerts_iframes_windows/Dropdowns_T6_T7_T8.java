package com.cydeo.tests.day06_alerts_iframes_windows;

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

public class Dropdowns_T6_T7_T8 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDropdown(){

        driver.quit();
    }

    @Test
    public void dropdowns_Task6(){

        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown

        //3. Select “December 1st, 1933” and verify it is selected.
        //Locate dropdowns and pass them in Select object constructors
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //Select year using : visible text
        yearDropdown.selectByVisibleText("1933");

        //Select month using : value attribute
        monthDropdown.selectByValue("11");

        //Select day using : index number
        dayDropdown.selectByIndex(0);

        //Create expected value
        String expectedYear = "1933";
        String expectedMonth = "December";
        String expectedDay = "1";

        //Getting actual values from browser
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        //Create Assertions
        Assert.assertTrue(actualYear.equals(expectedYear));
        Assert.assertTrue(actualMonth.equals(expectedMonth));
        Assert.assertTrue(actualDay.equals(expectedDay));


    }

    @Test
    public void dropdowns_Task7(){

        //TC #7: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown

        //Locate dropdowns and pass them in Select object constructors
        Select statesDropdowns = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        statesDropdowns.selectByVisibleText("Illinois");

        //4. Select Virginia
        statesDropdowns.selectByValue("VA");

        //5. Select California
        statesDropdowns.selectByIndex(5);

        //6. Verify final selected option is California.
        //Use all Select options. (visible text, value, index)
        String expectedOptionText = "California";
        String actualOptionText = statesDropdowns.getFirstSelectedOption().getText();

        //Assertions
        Assert.assertEquals(actualOptionText,expectedOptionText,"STATES DROPDOWN VALUE IS NOT SUPPORTED! ");

    }

    @Test
    public void dropdowns_Task8(){

        //TC #8: Selecting value from non-select dropdown
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown


        //3. Click to non-select dropdown ( HTML dropdown )
        //Locate the non-select dropdown
        WebElement websiteDropdown = driver.findElement(By.linkText("Dropdown link"));
        websiteDropdown.click();

        //4. Select Facebook from dropdown
        WebElement facebookLink = driver.findElement(By.linkText("Facebook"));
        facebookLink.click();

        //5. Verify title is “Facebook - Log In or Sign Up” Facebook - log in or sign up
        String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle, "Title are not Equals!");


    }
}
