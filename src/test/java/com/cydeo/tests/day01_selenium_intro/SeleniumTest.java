package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {

        // Setting up the web driver manager
        WebDriverManager.chromedriver().setup();

        // Create the instance of
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");



    }

}
