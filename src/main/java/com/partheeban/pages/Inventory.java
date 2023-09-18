package com.partheeban.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Inventory {

    private WebDriver webDriver;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(className = "bm-burger-button")
    private WebElement menuIcon;

    @FindBy(className = "app_logo")
    private WebElement appLogo;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backBag;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackBagButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
    private WebElement sortByIcon;


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

    public Boolean isItBackBag() {
        return backBag.isEnabled();
    }

    public void addBackBag() {
        backBag.click();
    }

    public Boolean isRemoveButtonEnabled() {
        return removeBackBagButton.isEnabled();
    }

    public void selectDropDownByName(String value) {
        Select select = new Select(sortByIcon);
        select.selectByVisibleText(value);
    }
}
