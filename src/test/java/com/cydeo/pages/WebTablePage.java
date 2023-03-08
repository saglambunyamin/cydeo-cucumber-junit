package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
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

    public void login () {

        this.usernameBox.sendKeys("Test");
        this.passwordBox.sendKeys("Tester");
        this.loginButton.click();

    }

    public void login (String username, String password) {

        this.usernameBox.sendKeys(username);
        this.passwordBox.sendKeys(password);
        this.loginButton.click();

    }

    public void loginWithConfig () {
        usernameBox.sendKeys(ConfigurationReader.getProperty("web.table.username"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("web.table.pw"));
        loginButton.click();
    }

}
