package com.cydeo.tests.day04_findElement_checkboxes_radio;

import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class T2_findElements {

    public static void main(String[] args) {

        //TC #2: FindElements Task
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate all the links in the page.
        List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));

        //4- Print out the number of the links on the page.
        System.out.println("listOfLinks.size() = " + listOfLinks.size());

        //5- Print out the texts of the links.
        for (WebElement eachLink : listOfLinks) { // use for each loop to print out the text of links
            System.out.println("Text of links: "+eachLink.getText());
        }


        //6- Print out the HREF attribute values of the links
        for (WebElement each : listOfLinks) {
            System.out.println("HREF attribute's value of links: "+each.getAttribute("href"));
        }

        driver.close();

    }
}
