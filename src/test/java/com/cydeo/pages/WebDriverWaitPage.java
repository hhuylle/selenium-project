package com.cydeo.pages;

import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebDriverWaitPage {

    public WebDriverWaitPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy(xpath = "//div[.='Loading... ']")
    public WebElement loadingBar;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='pwd']")
    public WebElement password;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitbutton;

    @FindBy(id = "flash")
    public WebElement errorMsg;


}
