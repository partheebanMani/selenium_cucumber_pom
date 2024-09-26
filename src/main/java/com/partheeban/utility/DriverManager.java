package com.partheeban.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Locale;

import static com.partheeban.utility.PropertiesConfig.PROPERTIES_CONFIG;

public class DriverManager {

    public static WebDriver setUpDriver() {
        WebDriver driver = null;
        switch (PROPERTIES_CONFIG.browser().toLowerCase(Locale.ROOT)) {
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver();
            }
            case "safari" -> driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }


}
