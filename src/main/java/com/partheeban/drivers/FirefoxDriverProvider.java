package com.partheeban.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverProvider implements DriverProvider {
    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver();
    }
}
