package com.partheeban.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;


    public Login(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterUserName(String userName) {
        this.userName.sendKeys(userName);
    }

    public void enterPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        seleniumUtility.waitForElementToBeClickable(webDriver, 10, loginButton).click();
    }

    public String getCurrentPageURL() {
        return webDriver.getCurrentUrl();
    }


}
