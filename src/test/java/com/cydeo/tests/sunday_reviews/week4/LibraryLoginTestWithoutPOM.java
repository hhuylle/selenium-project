package com.cydeo.tests.sunday_reviews.week4;

import com.cydeo.pages.LibraryLoginPageWithoutPOM;
import com.cydeo.tests.Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LibraryLoginTestWithoutPOM {

    // As soon as we create object it will go to PAGE class and look for elements that we located


    @Test
    public void required_field_error_message_test(){

        Driver.getDriver().get("https://library1.cydeo.com/");

        // As soon as we create object it will go to PAGE class and look for elements that we located
        LibraryLoginPageWithoutPOM libraryLoginPageWithoutPOM =  new LibraryLoginPageWithoutPOM();

        libraryLoginPageWithoutPOM.signInButton.click();

        Assert.assertTrue(libraryLoginPageWithoutPOM.fieldRequiredErrorMessage.isDisplayed());


    }
}
