package com.cydeo.tests.day12_review;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.tests.Utilities.BrowserUtils;
import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T2_T3_Explicit_Wait_Practice {

    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod(){
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();
    }

    @Test
    public void t2_remove_checkbox_test(){

        //TC #2: Explicit wait practice
        //3- Click to “Remove” button
        dynamicControlsPage.removeButton.click();

        //4- Wait until “loading bar disappears”
        //Create object of 'webDriverWait' class, and setup constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //Use 'wait' object with the proper syntax explicit wait conditions
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));

        //Using the costom utility method 'waitForInvisibilityOf' to wait loadingBar disappears
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed
        //Assert.assertTrue(!dynamicControlsPage.checkBox.isDisplayed());--> returns false

        //assertFalse() method is expecting a 'false' boolean value to PASS the test
        try{
            Assert.assertFalse(dynamicControlsPage.checkBox.isDisplayed());
        }catch (NoSuchElementException e){
            System.out.println("NoSuchElementException is thrown. It means that the checkbox is not on the page");
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.itsGoneMessage.isDisplayed());

    }

    @Test
    public void t3_explicit_wait_practice_test(){

        //TC #3: Explicit wait practice
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        //3- Click to “Enable” button
        dynamicControlsPage.enableButton.click();
        //4- Wait until “loading bar disappears”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled());

        //b. “It’s enabled!” message is displayed.
        //Assert.assertTrue(dynamicControlsPage.itsEnableMessage.isDisplayed());

        String expectedMsgText = "It's enabled!";
        String actualMsgText = dynamicControlsPage.itsEnableMessage.getText();
        Assert.assertTrue(actualMsgText.equals(expectedMsgText));

    }

    @AfterMethod
    public void teardownMethod(){
        Driver.closeDriver();
    }
}
