package com.partheeban.pages;

import com.partheeban.utility.SeleniumUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected SeleniumUtility seleniumUtility;
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.seleniumUtility = new SeleniumUtility(webDriver);
//        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver,10), this);
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }


}
