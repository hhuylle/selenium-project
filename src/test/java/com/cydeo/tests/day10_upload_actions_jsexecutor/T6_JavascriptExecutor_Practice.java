package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.Utilities.BrowserUtils;
import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T6_JavascriptExecutor_Practice {

    @Test
    public void infinite_scroll_test_using_JSExecutor(){

        //TC #6: Scroll using JavascriptExecutor
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        //((JavascriptExecutor) Driver.getDriver()).executeScript("window.scroll(0,750)");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //3- Use below JavaScript method and scroll
        //a. 750 pixels down 10 times.
        BrowserUtils.sleep(2);
        for (int i = 0; i < 10; i++) { // use for loop to run 10 times
            js.executeScript("window.scroll(0,750)"); //window.scroll(x,y)
        }

        //b. 750 pixels up 10 times
        //JavaScript method to use : window.scrollBy(0,0)
        BrowserUtils.sleep(2);
        for (int i = 0; i < 10; i++) { // use for loop to run 10 times
            js.executeScript("window.scroll(0,-750)"); //window.scroll(x,y)
        }
    }
}
