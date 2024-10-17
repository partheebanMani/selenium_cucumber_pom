package com.partheeban.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumUtility {

    private WebDriver webDriver;

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


}
