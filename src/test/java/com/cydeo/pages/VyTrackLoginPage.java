package com.cydeo.pages;

import com.cydeo.tests.Utilities.ConfigurationReader;
import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLoginPage {

    public VyTrackLoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement loginButton;

    public void loginAsDriver(){
        username.sendKeys(ConfigurationReader.getProperty("usernameDriver"));
        password.sendKeys(ConfigurationReader.getProperty("passwordDriver"));
        loginButton.click();
        //Driver.closeDriver();
    }

    public void loginAsSalesManager(){
        username.sendKeys(ConfigurationReader.getProperty("usernameSalesManager"));
        password.sendKeys(ConfigurationReader.getProperty("passwordSalesManager"));
        loginButton.click();
        //Driver.closeDriver();
    }

    public void loginAsStoreManager(){
        username.sendKeys(ConfigurationReader.getProperty("usernameStoreManager"));
        password.sendKeys(ConfigurationReader.getProperty("passwordStoreManager"));
        loginButton.click();
        //Driver.closeDriver();
    }

}
