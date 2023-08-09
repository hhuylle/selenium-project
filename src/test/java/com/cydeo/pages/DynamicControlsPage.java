package com.cydeo.pages;

import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {

    //Create constructor and innitialize driver and object
    public DynamicControlsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableButton;

    //Using @FindBy annotation
    @FindBy(xpath = "//button[.='Remove']")
    public WebElement removeButton;

    @FindBy(id = "loading")
    public WebElement loadingBar;

    @FindBy(xpath = "//input[@type='checkbox']")
    //@FindBy(css = "//input[type='checkbox']")
    public WebElement checkBox;

    @FindBy(id = "message")
    public WebElement itsGoneMessage;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputBox;

    @FindBy(xpath = "//form[@id='input-example']//p")
    public WebElement itsEnableMessage;

}
