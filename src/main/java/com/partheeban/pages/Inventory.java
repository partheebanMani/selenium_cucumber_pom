package com.partheeban.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventory {

    private WebDriver webDriver;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(className = "bm-burger-button")
    private WebElement menuIcon;

    @FindBy(className = "app_logo")
    private WebElement appLogo;


    public Inventory(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public void clickMenuIcon() {
        menuIcon.click();
    }

    public String getAppLogoText() {
        return appLogo.getText();
    }

}
