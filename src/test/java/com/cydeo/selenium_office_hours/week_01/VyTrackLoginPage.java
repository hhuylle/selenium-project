package com.cydeo.selenium_office_hours.week_01;

import com.cydeo.tests.Utilities.BrowserUtils;
import com.cydeo.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class VyTrackLoginPage {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        // 1-open a Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //It will go to the all findElement() method implicitly to give them time if they need
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");
    }
    @Test
    public void vyTrack_loginPage_test1(){
        // TC001 As a user I should be able to see Login label is displayed

        //  3-verify Login is displayed
        WebElement loginText = driver.findElement(By.xpath("//a[.='LOGIN']"));

        //Assert.assertTrue(login.isDisplayed());
        String expectedLoginText = "LOGIN";
        String actualLoginText = loginText.getText();

        Assert.assertEquals(actualLoginText,expectedLoginText);

    }

    @Test
    public void loginPage_test2(){

        // 3- Click Login label
        WebElement loginText = driver.findElement(By.linkText("LOGIN"));
        loginText.click();

        // 3- Verify the title contains "Login"
        String expectedTitle = "Login";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle, "Both Title are NOT matching!");

    }

    @Test
    public void login_credentials_test(){

        //TC003 As a user I should be able to login with valid credentials
        // 3- Click Login label
        WebElement loginText = driver.findElement(By.linkText("LOGIN"));
        loginText.click();

        // 4- Login to application with username as "User1" and password
        //    as "UserUser123"
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='_username']"));
        usernameInput.sendKeys("User1");

        BrowserUtils.sleep(3);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='_password']"));
        passwordInput.sendKeys("UserUser123" + Keys.ENTER);

        BrowserUtils.sleep(3);
/*
        //WebElement loginButton = driver.findElement(By.xpath("//button[.='Log in']"));
        //loginButton.click();

        //WebElement closeButton = driver.findElement(By.xpath("//button[.='×']"));
        //closeButton.click();

 */

        // 5- Verify the title contains "Dashboard"
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        BrowserUtils.sleep(10);

        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void password_hidden_test(){

        //TC004 As a user I should be able to see the password hidden as default
        // 3- Click Login label
        WebElement loginText = driver.findElement(By.linkText("LOGIN"));
        loginText.click();

        // 4- Login to application with username as "User1" and password
        //    as "UserUser123"
        //WebElement usernameInput = driver.findElement(By.id("prependedInput"));
        //usernameInput.sendKeys("User1");

        WebElement passwordInput = driver.findElement(By.name("_password"));
        passwordInput.sendKeys("UserUser123");

        // 5- Verify the password is hidden
        String expectedPasswordAttributeValue = "password";
        String actualPasswordAttributeValue = passwordInput.getAttribute("type");
        Assert.assertEquals(actualPasswordAttributeValue,expectedPasswordAttributeValue,"Password hidden verification failed!");

    }

    @Test
    public void all_texts_displayed_test(){

        //TC005 As a user I should be able to see Home, About us, Our Approach,
        //    Product and Services, Contact and LOGIN labels are displayed
        WebElement productAndServicesText = driver.findElement(By.xpath("//a[.='Products and Services']"));
        WebElement contactText = driver.findElement(By.xpath("//a[.='Contact']"));
        WebElement loginText = driver.findElement(By.xpath("//a[.='LOGIN']"));

        Assert.assertTrue(productAndServicesText.isDisplayed());
        Assert.assertTrue(contactText.isDisplayed());
        Assert.assertTrue(loginText.isDisplayed());


        //  3-verify Home, About us, Our Approach, Product and Services, Contact and LOGIN labels are displayed
        WebElement homeText = driver.findElement(By.xpath("//a[.='Home']"));
        WebElement aboutUsText = driver.findElement(By.xpath("//a[.='About us']"));
        WebElement ourApproachText = driver.findElement(By.xpath("//a[.='Our Approach']"));

        String expectedHomeText = "Home";
        String expectedAboutUsText = "About us";
        String expectedOurApproachText = "Our Approach";
        String expectedProductAndServicesText = "Products and Services";
        String expectedContactText = "Contact";
        String expectedLOGINText = "LOGIN";

        String actualHomeText = homeText.getText();
        String actualAboutUsText = aboutUsText.getText();
        String actualOurApproachText = ourApproachText.getText();
        String actualProductAndServicesText = productAndServicesText.getText();
        String actualContactText = contactText.getText();
        String actualLOGINText = loginText.getText();

        Assert.assertEquals(actualHomeText,expectedHomeText);
        Assert.assertEquals(actualAboutUsText,expectedAboutUsText);
        Assert.assertEquals(actualOurApproachText,expectedOurApproachText);
        Assert.assertEquals(actualProductAndServicesText,expectedProductAndServicesText);
        Assert.assertEquals(actualContactText,expectedContactText);
        Assert.assertEquals(actualLOGINText,expectedLOGINText);



    }
}
