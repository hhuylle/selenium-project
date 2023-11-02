package com.cydeo.tests.sunday_reviews.week3;

import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardvsSoft_Assertion {

    @BeforeMethod
    public void setupMethod(){

        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/login
        Driver.getDriver().get("https://practice.cydeo.com/login");

    }

    @Test
    public void login_test_with_hard_assertion() throws InterruptedException {

        // 3. Enter username: "tomsmith"
        // 4. Enter password: "SuperSecretPassword"
        // 5. Click to Login button
        WebElement usernameInput = Driver.getDriver().findElement(By.name("username"));
        usernameInput.sendKeys("tomsmith");

        //Thread.sleep(3000);
        // 4. Enter password: "SuperSecretPassword"
        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("SuperSecretPassword");
        //Thread.sleep(3000);

        // 5. Click to Login button
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        button.click();

        Thread.sleep(3000);

        // I made it failed purposely to see if hard assert failed, next line of codes will not execute
        Assert.assertEquals( Driver.getDriver().getTitle(),"Secure Are","Title verification failed");

        Thread.sleep(3000);

        WebElement resultText = Driver.getDriver().findElement(By.xpath("//div[@id='flash']"));
        String actualResulText = resultText.getText();
        String expectedResultText = "You logged into a secure area!";

        System.out.println("resultText.getText() = " + resultText.getText());

        Assert.assertTrue(actualResulText.contains(expectedResultText));
        // 6. Verify text displayed on page
        //    Expected: "You logged into a secure area!"
    }

    @Test
    public void login_test_with_soft_assertion(){

        // 3. Enter username: "tomsmith"
        // 4. Enter password: "SuperSecretPassword"
        // 5. Click to Login button
        WebElement usernameInput = Driver.getDriver().findElement(By.name("username"));
        usernameInput.sendKeys("tomsmith");

        //Thread.sleep(3000);
        // 4. Enter password: "SuperSecretPassword"
        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("SuperSecretPassword");
        //Thread.sleep(3000);

        // 5. Click to Login button
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        button.click();

        SoftAssert softAssert = new SoftAssert();
        // I made it failed purposely to see if hard assert failed, next line of codes will not execute
        softAssert.assertTrue(Driver.getDriver().getTitle().equals("Secure Are"));

        //Thread.sleep(3000);
        //Assert.assertTrue(Driver.getDriver().getTitle().equals("Secure Area"));

        WebElement resultText = Driver.getDriver().findElement(By.xpath("//div[@id='flash']"));
        String expectedResultText = "You logged into a secure area!!!";
        String actualResultText = resultText.getText();
        System.out.println("resultText.getText() = " + resultText.getText());

        //System.out.println("resultText.getText() = " + resultText.getText());

        softAssert.assertTrue(actualResultText.contains(expectedResultText));

        // We have to use assertAll() method at the end of Text method to execute all assertions
        softAssert.assertAll();

        // 6. Verify text displayed on page
        //    Expected: "You logged into a secure area!"
    }
}
