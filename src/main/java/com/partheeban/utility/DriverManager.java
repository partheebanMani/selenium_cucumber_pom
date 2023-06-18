package com.partheeban.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;

import static com.partheeban.utility.PropertiesConfig.PROPERTIES_CONFIG;

public class DriverManager {

    private static WebDriver driver;

    public static void setUpDriver() {
        if (driver != null) {
            BaseDriver.setWebDriver(driver);
        }

        switch (PROPERTIES_CONFIG.browser().toLowerCase(Locale.ROOT)) {
            case "chrome" -> driver = new ChromeDriver();
            case "safari" -> driver = new SafariDriver();
        }
        driver.get(PROPERTIES_CONFIG.url());
        BaseDriver.setWebDriver(driver);
    }


}
