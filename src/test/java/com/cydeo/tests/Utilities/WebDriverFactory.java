package com.cydeo.tests.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    // TASK: NEW METHOD CREATION
    // Method name: getDriver
    // Static method
    // Accepts String arg: browserType
    //  - This are will determine what type of browser is opened
    //  - If "chrome" passed --> it will open Chrome browser
    //  - If "firefox" passed --> it will open Firefox browser
    // RETURN TYPE" "WebDriver"

    public static WebDriver getDriver(String browserType){

        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else {
            System.out.println("The browser does not exist or not currently supported");
            return null;
        }


    }

}
