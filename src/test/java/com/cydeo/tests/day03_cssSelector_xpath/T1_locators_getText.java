package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {

    public static void main(String[] args) {

        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a Chrome browser
        //WebDriverManager.chromedriver().setup();
       //WebDriver driver = new ChromeDriver();

        //Creating a new ChromeDriver and storing it in "driver"
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”
        WebElement usernameInput = driver.findElement(By.className("login-inp"));
        usernameInput.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys("incorrect");

        //5- Click to login button.
        WebElement button = driver.findElement(By.className("login-btn"));
        button.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        String expectedErrorText = "Incorrect login or password";
        String actualErrorText = driver.findElement(By.className("errortext")).getText();

        if (actualErrorText.contains(expectedErrorText)){
            System.out.println("Error message text verification PASSED!");
        }else {
            System.out.println("Error message text verification FAILED!!");
        }



    }
}
