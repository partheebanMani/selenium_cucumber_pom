package com.partheeban.utility;

import org.openqa.selenium.WebDriver;

public class BaseDriver {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getWebDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver webDriver) {
        BaseDriver.webDriver.set(webDriver);

    }


}
