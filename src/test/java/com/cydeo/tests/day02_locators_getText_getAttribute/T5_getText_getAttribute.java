package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttribute {

    public static void main(String[] args) {

        //TC #5: getText() and getAttribute() method practice
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        //3- Verify header text is as expected:
        //Expected: Registration form
        WebElement header = driver.findElement(By.tagName("h3"));

        String expectedHeader = "Registration form";
        String actualHeader = header.getText();

        if (actualHeader.contains(expectedHeader)){
            System.out.println("Header verification PASSED!");
        }else {
            System.out.println("Header verification FAILED!");
        }

        //4- Locate “First name” input box
        WebElement firstnameInput = driver.findElement(By.className("form-control"));

        //5- Verify placeholder attribute’s value is as expected:
        //Expected: first name
        String expectedPlaceHolder = "first name";
        String actualPlaceHolder = firstnameInput.getAttribute("placeholder");

        System.out.println("actualPlaceHolder = " + actualPlaceHolder);

        if (actualHeader.equals(expectedHeader)) {
            System.out.println("PlaceHolder verification PASSED!");
        }else {
            System.out.println("PlaceHolder verification FAILED!");
        }

    }
}
