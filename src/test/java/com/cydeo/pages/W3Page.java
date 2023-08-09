package com.cydeo.pages;

import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3Page {

    //1-Create constructor and initialize the driver and object
    public W3Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //2- Instead of using findElement method we use @FindBy annotation

    @FindBy(id = "demo")
    public WebElement paragraph;
}
