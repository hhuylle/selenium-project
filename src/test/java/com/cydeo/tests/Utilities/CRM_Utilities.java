package com.cydeo.tests.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    //TC #5: Create utility method
    //1. Create a new method for login
    //2. Create a method to make Task3 logic re-usable
    //3. When method is called, it should simply login
    //This method should have at least 2 overloaded versions.



    //Method #2 info:
    //• Name: login_crm()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String username
    //• Arg3: String password
    /*
    This class will store the method related to CRM
    This method will log in using below credentials
    @username: helpdesk1@cydeo.com
    @password: UserUser
     */
    public static void loginCRM(WebDriver driver, String username, String password){

        //Method #1 info:
        //• Name: login_crm()
        //• Return type: void
        //• Arg1: WebDriver
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameInput.sendKeys(username);

        //4. Enter valid password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys(password);

        //5. Click to `Log In` button
        WebElement buttonLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        buttonLogin.click();

    }
}
