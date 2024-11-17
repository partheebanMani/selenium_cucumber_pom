package com.partheeban.drivers;

import org.openqa.selenium.WebDriver;

public interface DriverProvider {
    WebDriver createDriver();
}
