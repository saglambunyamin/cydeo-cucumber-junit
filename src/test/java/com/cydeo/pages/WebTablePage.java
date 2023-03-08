package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage {

    public WebTablePage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (name = "username")
    public WebElement usernameBox;

    @FindBy (name = "password")
    public WebElement passwordBox;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement loginButton;

}
