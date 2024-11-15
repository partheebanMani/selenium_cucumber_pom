package com.partheeban.utility;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SeleniumUtility {

    private final WebDriver webDriver;

    public SeleniumUtility(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver updateDriverWaitTimeInSeconds(int seconds) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        return webDriver;
    }

    public WebDriver updateDriverWaitTimeInMinutes(int minutes) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMinutes(minutes));
        return webDriver;
    }


    public WebElement waitForElementToLoad(int seconds, By element) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }

    public WebElement waitForElementToAppear(WebElement element, int timeOut) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(timeOut));
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitForElementsListForAppear(WebElement element, int timeOut) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(timeOut));
        return webDriverWait.until(ExpectedConditions.visibilityOfAllElements(element));
    }


    public WebElement waitForElementToBeClickable(int seconds, By element) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(element));

    }

    public WebElement waitForElementToBeClickable(int seconds, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void addCookie(String key, String value) {
        webDriver.manage().addCookie(new Cookie(key, value));
    }

    public void deleteCookie(String key) {
        webDriver.manage().deleteCookieNamed(key);
    }

    public void deleteAllCookie() {
        webDriver.manage().deleteAllCookies();
    }

    public void addAllCookie(Map<String, String> map) {
        map.forEach((key, value) -> webDriver.manage().addCookie(new Cookie(key, value)));
    }

    public Set<Cookie> getAllCookies() {
        return webDriver.manage().getCookies();
    }

    public String getCookie(String key) {
        return webDriver.manage().getCookieNamed(key).getValue();
    }

    //utilities for Alerts

    public Alert getAlert() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    public void closeAlert() {
        getAlert().dismiss();
    }

    public String getTextFromAlert() {
        return getAlert().getText();
    }

    public void sendTextToAlert(String value) {
        getAlert().sendKeys(value);
    }

    public String getTextAndCloseAlert() {
        Alert alert = getAlert();
        String text = alert.getText();
        alert.dismiss();
        return text;
    }

    //utilities for DropDown

    public Select findSelectWebElement(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return new Select(webDriverWait.until(ExpectedConditions.visibilityOf(webElement)));
    }

    public void selectElementByText(WebElement webElement, String value) {
        findSelectWebElement(webElement).selectByVisibleText(value);
    }

    public void selectElementSByText(WebElement webElement, List<String> values) throws Exception {
        Select selectWebElement = findSelectWebElement(webElement);
        if (selectWebElement.isMultiple()) {

            values.forEach(selectWebElement::selectByVisibleText);
        } else {
            throw new Exception("multi select is not available for this " + webElement.toString());
        }
    }

    public void selectElementByValue(WebElement webElement, String value) {
        findSelectWebElement(webElement).selectByValue(value);
    }

    public void selectElementByIndex(WebElement webElement, int index) {
        findSelectWebElement(webElement).selectByIndex(index);
        webDriver.switchTo().defaultContent();

        Actions actions = new Actions(webDriver);
        actions.keyUp(Keys.CONTROL).keyUp(Keys.ENTER).keyDown(Keys.CONTROL).perform();
    }

    public void sendKeysTogether(Keys... keys) {
        new Actions(webDriver).sendKeys(keys).perform();
    }


}
