package com.cydeo.tests.day04_findElement_checkboxes_radio;

import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practices {
    public static void main(String[] args) {

        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");


        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
        //Locate "Home" link, using cssSelector, syntax #1, class attribute value
        //using              tagNam[attribute='value']
        WebElement homeLink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));

        //Locate "Home" link, using cssSelector, syntax #2, class attribute value
        //using              tagNam.value
        WebElement homeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));

        //Locate "Home" link, using cssSelector, syntax #1, href attribute value
        //using              tagNam[attribute='value']
        WebElement homeLink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));

        //b. “Forgot password” header
        //Locate Header using xpath, using text of h2
        WebElement headerForgotPassword_ex1 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //Locate Header using cssSelector, locate parent element and move down to h2
        WebElement headerForgotPassword_ex2 = driver.findElement(By.cssSelector("div[class='example'] > h2"));

        //Locate Header using cssSelector, locate parent element and move down to h2
        WebElement headerForgotPassword_ex3 = driver.findElement(By.cssSelector("div.example > h2"));

        //c. “E-mail” text
        //Locate "email" label using xpath
        WebElement emailLabel_ex1 = driver.findElement(By.xpath("//label[@for='email']"));

        //Locate "email" label using xpath
        WebElement emailLabel_ex2 = driver.findElement(By.xpath("//label[.='E-mail']"));

        //d. E-mail input box
        //Locate the email input box using xpath
        //      tagName[@attribute='value']
        WebElement emailInput_ex1 = driver.findElement(By.xpath("//input[@type='text']"));

        //Locate the email input box using xpath
        WebElement emailInput_ex2 = driver.findElement(By.xpath("//input[@name='email']"));

        //Locate the email input box using xpath
        WebElement emailInput_ex4 = driver.findElement(By.xpath("//input[contains(@pattern,'a-z')]"));

        //e. “Retrieve password” button
        //Locate it using xpath
        WebElement retrievePasswordButton = driver.findElement(By.xpath("//button[@id='form_submit']"));

        //f. “Powered by Cydeo text
        WebElement poweredByCydeoText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        //4. Verify all web elements are displayed.
        System.out.println("homeLink_ex1 = " + homeLink_ex1.isDisplayed());
        System.out.println("headerForgotPassword_ex1 = " + headerForgotPassword_ex1.isDisplayed());
        System.out.println("emailLabel_ex1 = " + emailLabel_ex1.isDisplayed());
        System.out.println("emailInput_ex1 = " + emailInput_ex1.isDisplayed());
        System.out.println("retrievePasswordButton = " + retrievePasswordButton.isDisplayed());
        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());


        //First solve the task with using cssSelector only. Try to create 2 different
        //cssSelector if possible
        //Then solve the task using XPATH only. Try to create 2 different
        //XPATH locator if possible

    }
}
