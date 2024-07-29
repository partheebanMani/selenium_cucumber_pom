package com.partheeban.utility;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class BaseDriver {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static synchronized WebDriver getWebDriver() {
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
        webDriver.remove();
    }

    public static void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) getWebDriver();
            byte[] src = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
    }

    public static void takeScreenshot(String location) throws IOException {
        File file = new File(location);
        TakesScreenshot takesScreenshot = (TakesScreenshot) getWebDriver();
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, file);
    }

}
