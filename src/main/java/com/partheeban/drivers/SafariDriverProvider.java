package com.partheeban.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverProvider implements DriverProvider {
    @Override
    public WebDriver createDriver() {
        return new SafariDriver();
    }
}
