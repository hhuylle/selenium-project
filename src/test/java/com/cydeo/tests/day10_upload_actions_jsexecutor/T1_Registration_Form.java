package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.Utilities.ConfigurationReader;
import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {


    @Test
    public void registration_form_test(){

        //TC#1: Registration form confirmation
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registrationFormURL"));

        // can use name or xpath locators to find web elements
        //3. Enter first name
        WebElement firstname = Driver.getDriver().findElement(By.name("firstname"));
        firstname.sendKeys("Jenny");

        //4. Enter last name
        WebElement lastname = Driver.getDriver().findElement(By.name("lastname"));
        lastname.sendKeys("Ngo");

        //5. Enter username
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("jennyngo251095");

        //6. Enter email address
        WebElement email = Driver.getDriver().findElement(By.name("email"));
        email.sendKeys("jennyngo251095@gmail.com");

        //7. Enter password
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("jennyngo251095");

        //8. Enter phone number
        WebElement phone = Driver.getDriver().findElement(By.name("phone"));
        phone.sendKeys("267-267-2672");

        //9. Select a gender from radio buttons
        Driver.getDriver().findElement(By.xpath("//input[@value='female']")).click();

        //10. Enter date of birth
        WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirth.sendKeys("10/25/1995");

        //11. Select Department/Office
        Select departmentDropDown = new Select(Driver.getDriver().findElement(By.name("department")));
        departmentDropDown.selectByValue("DE");

        //12. Select Job Title
        Select jobtitleDropDown = new Select(Driver.getDriver().findElement(By.name("job_title")));
        jobtitleDropDown.selectByVisibleText("SDET");

        //13. Select programming language from checkboxes
        WebElement javaCheckBox = Driver.getDriver().findElement(By.id("inlineCheckbox2"));
        javaCheckBox.click();

        //14. Click to sign up button
        //13. Select programming language from checkboxes
        WebElement signInButton = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        signInButton.click();

        //15. Verify success message “You’ve successfully completed registration.” is displayed.
        WebElement successMsg = Driver.getDriver().findElement(By.xpath("//div[@role='alert']"));
        Assert.assertTrue(successMsg.isDisplayed());

        Driver.closeDriver();
    }

}
