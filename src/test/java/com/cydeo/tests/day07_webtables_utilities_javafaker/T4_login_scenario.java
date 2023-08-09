package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.tests.Utilities.BrowserUtils;
import com.cydeo.tests.Utilities.CRM_Utilities;
import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_login_scenario {

    //TC #4: Login scenario

    //USERNAME                        PASSWORD
    //helpdesk1@cybertekschool.com    UserUser


    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make set-ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //2. Go to: http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

    }

    @AfterMethod
    public void tearDownMethod(){

    }

    @Test
    public void loginScenario_test(){

        //3. Enter valid username
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameInput.sendKeys("helpdesk1@cybertekschool.com");

        BrowserUtils.sleep(3);

        //4. Enter valid password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("UserUser");

        BrowserUtils.sleep(3);

        //5. Click to `Log In` button
        WebElement buttonLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        buttonLogin.click();

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver,"(2) Portal");

    }

    @Test
    public void loginScenario_test2(){

        //3. Enter valid username
        CRM_Utilities.loginCRM(driver,"helpdesk1@cybertekschool.com", "UserUser");

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver,"(2) Portal");

    }
}
