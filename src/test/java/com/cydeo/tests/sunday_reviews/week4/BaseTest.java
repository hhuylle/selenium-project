package com.cydeo.tests.sunday_reviews.week4;

import com.cydeo.tests.Utilities.ConfigurationReader;
import com.cydeo.tests.Utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void setup(){

        Driver.getDriver().get(ConfigurationReader.getProperty("webTableURL"));
    }

    @AfterMethod
    public void teardown() {

        Driver.closeDriver();

        // You can also implement taking screenshot method here to take a screenshot after each test
    }
}
