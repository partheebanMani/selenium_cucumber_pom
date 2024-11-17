package com.partheeban.drivers;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;
import java.util.Locale;

import static com.partheeban.utility.PropertiesConfig.PROPERTIES_CONFIG;

public class DriverManager {

    private DriverManager() {
    }

    @SneakyThrows
    public static WebDriver setUpDriver() {
        WebDriver driver = null;

        String browser = PROPERTIES_CONFIG.browser().toLowerCase(Locale.ROOT);

        if (PROPERTIES_CONFIG.browserEnv().equalsIgnoreCase("grid")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            String hubURL = PROPERTIES_CONFIG.gridUrl();
            driver = new RemoteWebDriver(new URL(hubURL), capabilities);

        } else {
            driver = DriverFactory.getDriverProvider(browser).createDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }


}
