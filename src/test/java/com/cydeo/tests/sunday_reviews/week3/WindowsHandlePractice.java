package com.cydeo.tests.sunday_reviews.week3;

import com.cydeo.tests.Utilities.Driver;
import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsHandlePractice extends TestBase {

    // TC : Windows handle practice

    @Test
    public void window_handle_test(){

        //    1. Open browser
        //    2. Go to website: https://demoqa.com/browser-windows
        Driver.getDriver().get("https://demoqa.com/browser-windows");

        //    3. Click on New Tab button
        Driver.getDriver().findElement(By.xpath("//button[.='New Tab']")).click();

        //    4. Click on New Window button
        Driver.getDriver().findElement(By.xpath("//button[.='New Window']")).click();

        //    5. Click on New Window Message button
        Driver.getDriver().findElement(By.xpath("//button[.='New Window Message']")).click();

        //    6. Store parent window handle id in a variable
        String parentWindowHandle = Driver.getDriver().getWindowHandle();

        //    7. Store all window handle ids in to a Set
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        System.out.println("allWindowHandles.size() = " + allWindowHandles.size());

        //    9. Print out each window title
        for (String eachWindow : allWindowHandles) {
            System.out.println("Each window id: " + eachWindow);
            Driver.getDriver().switchTo().window(eachWindow);
            System.out.println("Current window title = " + Driver.getDriver().getTitle());
        }

    }
}
