package com.cydeo.tests.sunday_reviews.week4;

import com.cydeo.pages.WebDriverWaitPage;
import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebDriverWaitTest {

    @Test
    public void webdriver_wait_test(){

        // TC: WebdriverWait practice
        // 1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        // 2. Click to start
        WebDriverWaitPage webDriverWaitPage = new WebDriverWaitPage();
        webDriverWaitPage.startButton.click();

        // 3. Wait until loading bar disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(webDriverWaitPage.loadingBar));

        // 4. Assert username inputbox is displayed
        Assert.assertTrue(webDriverWaitPage.username.isDisplayed());

        // 5. Enter username: tomsmith
        webDriverWaitPage.username.sendKeys("tomsmith");

        // 6. Enter password: incorrectpassword
        webDriverWaitPage.password.sendKeys("incorrectpassword");

        // 7. Click to Submit button
        webDriverWaitPage.submitbutton.click();

        // 8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(webDriverWaitPage.errorMsg.getText().contains("Your password is invalid!"));
    }
}
