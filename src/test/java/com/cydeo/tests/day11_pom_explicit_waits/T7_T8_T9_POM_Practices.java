package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.tests.Utilities.BrowserUtils;
import com.cydeo.tests.Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T7_T8_T9_POM_Practices {

    LibraryLoginPage loginPage;

    @BeforeMethod
    public void setupMethod(){
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");
        loginPage = new LibraryLoginPage();
    }

    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }

    @Test
    public void T7_field_required_error_message_test(){

        //TC #7: Required field error message test
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com
        //3- Do not enter any information


        //4- Click to “Sign in” button
        loginPage.signInButton.click();

        //5- Verify expected error is displayed:
        //Expected: This field is required.
        Assert.assertTrue(loginPage.fieldRequiredErrorMessage.isDisplayed());
        //NOTE: FOLLOW POM DESIGN PATTERN

    }

    @Test
    public void T8_email_format_error_message_test(){
        //TC #8: Invalid email format error message test
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com
        //3- Enter invalid email format
        loginPage.emailInput.sendKeys("username");
        loginPage.signInButton.click();

        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        Assert.assertTrue(loginPage.enterAValidEmailErrorMessage.isDisplayed());

        //NOTE: FOLLOW POM DESIGN PATTERN
    }

    @Test
    public void T9_library_negative_login_test(){
        //TC #9: Library negative login
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com
        //3- Enter incorrect username or incorrect password
        loginPage.emailInput.sendKeys("username@yahoo.com");
        loginPage.passwordInput.sendKeys("password");
        loginPage.signInButton.click();

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        BrowserUtils.sleep(2);
        Assert.assertTrue(loginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());

        //NOTE: FOLLOW POM DESIGN PATTERN
    }



}
