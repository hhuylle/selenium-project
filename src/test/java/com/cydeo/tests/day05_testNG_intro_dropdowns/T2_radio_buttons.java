package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T2_radio_buttons {

    public static void main(String[] args) throws InterruptedException {

        //TC #2: Radiobutton handling
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/radio_buttons
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/radio_buttons");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. Click to “Hockey” radio button
        WebElement hockeyRadioButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        Thread.sleep(2000);
        hockeyRadioButton.click();

        //4. Verify “Hockey” radio button is selected after clicking.
        if (hockeyRadioButton.isSelected()){
            System.out.println("Hockey radio button is selected verification PASSED!");
        }else {
            System.out.println("Hockey radio button is NOT selected verification FAILED!");
        }

        driver.close();

        //USE XPATH LOCATOR FOR ALL WEB ELEMENT LOCATORS

    }
}
