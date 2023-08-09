package com.cydeo.selenium_office_hours.week3;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Web_Table_Practice extends TestBase {

    //url = http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html

    //Task 2:  Web Table



    @Test
    public void web_table_test(){

        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        //Step 1- Click on calendar
        WebElement calenderInput = driver.findElement(By.id("datepicker"));// use it if we do not need to store Web element
        calenderInput.click();

        //Step 2- Get all td of tables using findElements method
        List<WebElement> allDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        //Step 3- using for loop get the text of all elements
        //Step 4- using if else condition we will check the specific date
        //Step 5- If the date is matched then click and break the loop

        for (WebElement eachDay : allDays) {
            String day = eachDay.getText();

            //Step 3- using for loop get the text of all elements
            System.out.println("Day = " + day);

            //Step 4- using if else condition we will check the specific date
            //Step 5- If the date is matched then click and break the loop
            if (day.equalsIgnoreCase("18")){
                eachDay.click();
                break;
            }
        }
    }
}
