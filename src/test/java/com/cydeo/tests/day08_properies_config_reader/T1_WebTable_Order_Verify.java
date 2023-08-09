package com.cydeo.tests.day08_properies_config_reader;

import com.cydeo.tests.Utilities.WebDriverFactory;
import com.cydeo.tests.Utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTable_Order_Verify {

    //TC #1: Web table practice

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");

    }

    @Test
    public void order_verify_name_test(){

        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        //Locate Bob'cell using its name as the text
        WebElement bobsCell = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        System.out.println("bobsCell = " + bobsCell.getText());

        String expectedName ="Bob Martin";
        String actualName = bobsCell.getText();

        Assert.assertEquals(actualName, expectedName, "Name is not matching!");

        //3. Verify Bob Martin’s order date is as expected
        //ExpectedDate: 12/31/2021

        WebElement bobsDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']//following-sibling::td[3]"));
        //WebElement bobsDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/../td[5]"));
        System.out.println("bobsDate = " + bobsDate.getText());
        String expectedDate = "12/31/2021";
        String actualDate = bobsDate.getText();

        Assert.assertEquals(actualDate,expectedDate,"Date is not matching!");

    }

    @Test
    public void order_verify_name_test2(){

        //3. Verify Bob Martin’s order date is as expected

        String alexandraGray =  WebOrderUtils.returnOrderDate(driver,"Alexandra Gray");
        System.out.println("alexandraGrayDate = " + alexandraGray);

        String bobMartin = WebOrderUtils.returnOrderDate(driver,"Bob Martin");
        System.out.println("bobMartin = " + bobMartin);

        String johnDoe = WebOrderUtils.returnOrderDate(driver,"John Doe");
        System.out.println("johnDoe = " + johnDoe);

    }

    @Test
    public void test3(){

        WebOrderUtils.orderVerify(driver,"Bob Martin", "12/31/2021");
    }
}
