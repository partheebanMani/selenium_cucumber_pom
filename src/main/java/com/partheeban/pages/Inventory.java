package com.partheeban.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Inventory {

    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(className = "bm-burger-button")
    private WebElement menuIcon;

    @FindBy(className = "app_logo")
    private WebElement appLogo;

    @FindBy(xpath = "//*[@class='shopping_cart_badge']")
    private WebElement shoppingCartBadge;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackBagButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
    private WebElement sortByIcon;


    public Inventory(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
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

    public Boolean isRemoveButtonEnabled() {
        return removeBackBagButton.isEnabled();
    }

    public void selectDropDownByName(String value) {
        Select select = new Select(sortByIcon);
        select.selectByVisibleText(value);
    }

    public WebElement findProduct(String productName) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), '" + productName + "')]")));
    }

    public void findProductAndAddToCart(String productName) {
        WebElement addToCartElement = findProduct(productName).findElement(By.xpath("./ancestor::div[2]/child::div[2]/button"));
        addToCartElement.click();
    }


    public Boolean isProductAvailable(String productName) {
        return findProduct(productName).isEnabled();
    }

    public Integer getCartCount() {
        return Integer.parseInt(shoppingCartBadge.getText());
    }


}
