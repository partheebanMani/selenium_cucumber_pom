package com.partheeban.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for the login page.
 */
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


    public void goTo(String url) {
        webDriver.get(url);
    }

    /**
     * Enters the username in the username field.
     *
     * @param userName the username to enter
     */
    public void enterUserName(String userName) {
        if (userName != null && !userName.isEmpty()) {
            this.userName.clear();
            this.userName.sendKeys(userName);
        }
    }

    /**
     * Enters the password in the password field.
     *
     * @param password the password to enter
     */
    public void enterPassword(String password) {
        if (password != null && !password.isEmpty()) {
            this.password.clear();
            this.password.sendKeys(password);
        }
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginButton() {
        seleniumUtility.waitForElementToBeClickable(webDriver, 10, loginButton).click();
    }

    /**
     * Performs the login action with the given credentials.
     *
     * @param userName the username
     * @param password the password
     */
    public void login(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
    }


}
