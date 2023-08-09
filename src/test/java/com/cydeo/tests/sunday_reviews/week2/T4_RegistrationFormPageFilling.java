package com.cydeo.tests.sunday_reviews.week2;

import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_RegistrationFormPageFilling {

    // TC#4: Registration Form Page Filling Form Test

    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/registration_form
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/registration_form");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void registrationFromPageFilling(){

        // 3. Enter First name: "John"
        WebElement firstnameInput = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstnameInput.sendKeys("John");

        // 4. Enter Last name: "Smith"
        WebElement lastnameInput = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastnameInput.sendKeys("Smith");

        // 5. Enter Username: "johnsmith123"
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        usernameInput.sendKeys("johnsmith123");

        // 6. Enter Email address: "john.smith@email.com"
        WebElement emailAddressInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailAddressInput.sendKeys("john.smith@email.com");

        // 7. Enter password: "John1234"
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("John1234");

        // 8. Enter Phone number: "123-456-7890"
        WebElement phoneNumInput = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumInput.sendKeys("123-456-7890");

        // 9. Click to "Male" from Gender
        WebElement male = driver.findElement(By.xpath("//input[@value='male']"));
        male.click();

        // 10. Enter Date of birth "01/28/1990"
        WebElement dateOfBirthInput = driver.findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirthInput.sendKeys("01/28/1990");

        // 11. Select "Department of Engineering" from Department/Office dropdown
        WebElement departmentOfEngineering = driver.findElement(By.xpath("//select[@name='department']"));
        departmentOfEngineering.click();

        WebElement selectDE = driver.findElement(By.xpath("//option[@value='DE']"));
        selectDE.click();

        // 12. Select "SDET" from Job title dropdown
        WebElement SDET = driver.findElement(By.xpath("//select[@name='job_title']"));
        SDET.click();

        WebElement selectSDET = driver.findElement(By.xpath("//option[.='SDET']"));
        selectSDET.click();

        // 13. Click to "Java" from languages
        WebElement java = driver.findElement(By.xpath("//input[@value='java']"));
        java.click();

        // 14. Click to "Sign up" button
        WebElement signupButton = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
        signupButton.click();

        //     Expected: "Well done!"
        String expectedWellDone = "Well done!";
        String actualWellDone = driver.findElement(By.xpath("//h4[@class='alert-heading']")).getText();

        Assert.assertTrue(actualWellDone.equals(expectedWellDone),"\"Well Done!\" Text verification FAILED!");
    }


}
