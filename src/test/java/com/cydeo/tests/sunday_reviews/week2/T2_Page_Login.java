package com.cydeo.tests.sunday_reviews.week2;

import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_Page_Login {

    public static void main(String[] args) throws InterruptedException {

        // TC#2: Practice page Login test

        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/login
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/login");

        // 3. Enter username: "tomsmith"
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("tomsmith");

        Thread.sleep(3000);
        // 4. Enter password: "SuperSecretPassword"
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("SuperSecretPassword");
        Thread.sleep(3000);

        // 5. Click to Login button
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        // 6. Verify text displayed on page
        //    Expected: "You logged into a secure area!"
        WebElement textVerify = driver.findElement(By.xpath("//div[@class='flash success']"));
        String expectedText = "You logged into a secure area!";
        String actualText = textVerify.getText();
        if (actualText.contains(expectedText)){
            System.out.println("Text on the page verification PASSED!");
        }else {
            System.out.println("Text on the page verification FAILED!");
        }

        driver.close();

    }
}
