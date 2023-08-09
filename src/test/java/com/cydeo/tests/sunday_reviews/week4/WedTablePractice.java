package com.cydeo.tests.sunday_reviews.week4;

import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WedTablePractice extends BaseTest{

    @Test
    public void web_table_test(){

        //// TC : Web table practice
        //    // 1. Open Chrome browser
        //    // 2. Go to https://practice.cydeo.com/tables
        //    // 3. Print table data as a single String, not so common, but useful sometimes
        WebElement table1 = Driver.getDriver().findElement(By.xpath("//table[@id='table1']"));
        System.out.println("table1.getText() = " + table1.getText());

        //    // 4. verify tconway@earthlink.net is anywhere in the table
        Assert.assertTrue(table1.getText().contains("tconway@earthlink.net"));

        //    // 5. print all column names in single line
        WebElement allColumNames = Driver.getDriver().findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.println("allColumNames.getText() = " + allColumNames.getText());

        //    // 6. print each column name in separate lines using a loop and findElements method
        List<WebElement> columNamesList = Driver.getDriver().findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        for (WebElement each : columNamesList) {
            System.out.println(each.getText());
        }

        //Locate John's due money:
        //WebElement johnMoney = Driver.getDriver().findElement(By.xpath("//table[@id='table1']//td[.='jsmith@gmail.com']//following-sibling::td[1]"));
        //System.out.println("johnMoney.getText() = " + johnMoney.getText());
    }
}
