package com.cydeo.avengers.week4;

import com.cydeo.tests.Utilities.BrowserUtils;
import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitPractice extends TestBase {

    //Task#2:  Explicit Wait Practice
    //

    @Test
    public void explicit_wait_test(){

        //   		- Go to "https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html"
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");

        //   		- Click buttons in order
        WebElement start = driver.findElement(By.id("button00"));
        WebElement one = driver.findElement(By.id("button01"));
        WebElement two = driver.findElement(By.id("button02"));
        WebElement three = driver.findElement(By.id("button03"));

        start.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(one));
        BrowserUtils.waitForClickAbility(driver,one);
        one.click();

        BrowserUtils.waitForClickAbility(driver,two);
        two.click();

        BrowserUtils.waitForClickAbility(driver,three);
        three.click();

        //   		- Verify messages are equal after click all buttons
        //   				- All Buttons Clicked
        WebElement textMsg = driver.findElement(By.id("buttonmessage"));
        Assert.assertTrue(textMsg.getText().contains("All Buttons Clicked"));

        //   				- Clickable Buttons
        wait.until(ExpectedConditions.textToBe(By.id("buttonmessage"),"Clickable Buttons"));
        Assert.assertTrue(textMsg.getText().contains("Clickable Buttons"));

        //   				- Click Buttons In Order
        wait.until(ExpectedConditions.textToBePresentInElement(textMsg,"Click Buttons In Order"));
        Assert.assertTrue(textMsg.getText().contains("Click Buttons In Order"));

    }
}
