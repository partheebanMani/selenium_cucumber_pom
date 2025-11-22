package com.partheeban.pages;

import com.partheeban.utility.SeleniumUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Abstract base class for all page objects.
 * Provides common functionality and initializes web elements.
 */
public abstract class BasePage {

    protected final SeleniumUtility seleniumUtility;
    protected final WebDriver webDriver;

    /**
     * Constructor to initialize page elements and utilities.
     *
     * @param webDriver WebDriver instance
     */
    public BasePage(WebDriver webDriver) {
        this.seleniumUtility = new SeleniumUtility(webDriver);
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }
    
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
