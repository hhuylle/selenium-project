package com.cydeo.tests.sunday_reviews.week3;

import com.cydeo.tests.Utilities.Driver;
import com.cydeo.tests.base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaFakerPractice extends TestBase {

    @Test
    public void java_faker_test(){

        // TC: Java Faker practice
        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/login
        Driver.getDriver().get("https://practice.cydeo.com/login");

        // 3. Enter username using java faker
        Faker faker = new Faker();

        WebElement username = Driver.getDriver().findElement(By.name("username"));
        username.sendKeys(faker.name().username());

        // 4. Enter password using java faker
        WebElement password = Driver.getDriver().findElement(By.name("username"));
        password.sendKeys(faker.internet().password());

        // 5. Click to Login button
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        button.click();

        // 6. Verify text displayed on page
        //    Expected: "Your username is invalid!"
        WebElement resultText = Driver.getDriver().findElement(By.xpath("//div[@id='flash']"));
        String actualResulText = resultText.getText();
        String expectedResultText = "Your username is invalid!";

        Assert.assertTrue(actualResulText.contains(expectedResultText));

    }
}
