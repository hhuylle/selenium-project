package com.cydeo.tests.sunday_reviews.week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Navigation_GetMethod {

    public static void main(String[] args) {

        // TC#1: Navigations and Get methods Practice

        // 1. Open a Chrome browser
        // 2. Go to: https://www.etsy.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.etsy.com");

        // 3. Navigate to https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        // 4. Navigate back, forward and refresh
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        // 5. Write “selenium” in search box
        WebElement searchSelenium = driver.findElement(By.xpath("//input[@type='text']"));
        searchSelenium.sendKeys("selenium");

        // 6. Press search button to search
        WebElement button = driver.findElement(By.cssSelector("input[id='nav-search-submit-button']"));
        button.click();

        // 7. Verify title is "Amazon.com : selenium"
        String expectedTitle = "Amazon.com : selenium";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }

        // 8. Verify url contains "selenium"
        String expectedContainsSeleniumInURL = "selenium";
        String actualContainsSeleniumInURL = driver.getCurrentUrl();
        if (actualContainsSeleniumInURL.contains(expectedContainsSeleniumInURL)){
            System.out.println("URL contains \"selenium\" verification PASSED!");
        }else {
            System.out.println("URL contains \"selenium\" verification FAILED!");
        }

        driver.close();

    }
}
