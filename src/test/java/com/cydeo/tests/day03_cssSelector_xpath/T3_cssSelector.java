package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_cssSelector {

    public static void main(String[] args) {

        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        String expectedLoginText = "Log In";

        //Locating loginButton using class attribute's value
        //WebElement loginButton = driver.findElement(By.cssSelector("value"));

        //Locating loginButton using cssSelector using type attribute's value
        //WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In']"));

        //Locating loginButton using cssSelector using type attribute's value
        //WebElement loginButton = driver.findElement(By.cssSelector("input[class='login-btn']"));

        //WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        WebElement loginButton = driver.findElement(By.cssSelector("input.login-btn"));

        String actualLoginText = loginButton.getAttribute("value");

        if (actualLoginText.contains(expectedLoginText)) {
            System.out.println("Log In text PASSED!");
        } else {
            System.out.println("expectedLoginText = " + expectedLoginText);// only shows what happen if it's not passed
            System.out.println("actualLoginText = " + actualLoginText);// only shows what happen if it's not passed
            System.out.println("Log In text FAILED!");

            //PS: Inspect and decide which locator you should be using to locate web
            //elements.
            //PS2: Pay attention to where to get the text of this button from



        }


    }
}