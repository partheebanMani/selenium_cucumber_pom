package com.partheeban.utility;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

    public static void closeDriver() {
        driver.close();
    }

    public static void quitDriver() {
        driver.quit();
    }

    public static void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            byte[] src = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
    }
}
