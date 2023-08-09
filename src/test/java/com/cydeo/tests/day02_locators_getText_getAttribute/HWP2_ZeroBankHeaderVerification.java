package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP2_ZeroBankHeaderVerification {

    public static void main(String[] args) throws InterruptedException {

        //HWP #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup(); // to create Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        //Expected: “Log in to ZeroBank”
        WebElement header = driver.findElement(By.tagName("h3"));
        String expectedHeader = "Log in to ZeroBank";
        String actualHeader = header.getText();

        if (actualHeader.contains(expectedHeader)){
            System.out.println("Header verification PASSED!");
        }else {
            System.out.println("Header verification FAILED!");
        }

        Thread.sleep(3000);

        driver.close();


    }
}
