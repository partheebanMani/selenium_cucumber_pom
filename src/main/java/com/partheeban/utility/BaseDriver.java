package com.partheeban.utility;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseDriver {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public synchronized static WebDriver getWebDriver() {
        if (webDriver.get() == null) {
            setWebDriver(DriverManager.setUpDriver());
        }

        return webDriver.get();
    }

    public static synchronized void setWebDriver(WebDriver webDriver) {
        BaseDriver.webDriver.set(webDriver);

    }

    public static void closeDriver() {
        getWebDriver().close();
    }

    public static void quitDriver() {
        getWebDriver().quit();
    }

    public static void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) getWebDriver();
            byte[] src = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
    }

}
