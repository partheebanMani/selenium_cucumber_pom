package com.partheeban.pages;

import com.partheeban.utility.SeleniumUtility;
import com.partheeban.utility.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected SeleniumUtility seleniumUtility;
    protected WebDriver webDriver;
    protected Util util;

    public BasePage(WebDriver webDriver) {
        this.seleniumUtility = new SeleniumUtility(webDriver);
        PageFactory.initElements(webDriver, this);
        this.util = new Util();
        this.webDriver = webDriver;
    }


}
