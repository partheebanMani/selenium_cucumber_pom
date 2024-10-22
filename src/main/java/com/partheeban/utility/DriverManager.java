package com.partheeban.utility;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

import static com.partheeban.utility.PropertiesConfig.PROPERTIES_CONFIG;

public class DriverManager {

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
            driver = setUpWebDriver(browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }

    private static WebDriver setUpWebDriver(String browser) {
        Map<String, Supplier<WebDriver>> drivers = new HashMap<>();
        drivers.put("chrome", getChromeDriver());
        drivers.put("firefox", getFirefoxDriver());
        drivers.put("safari", getSafariDriver());

        return drivers.getOrDefault(browser.toLowerCase().trim(), () -> {
            throw new RuntimeException("Browser not found...");
        }).get();

    }

    private static Supplier<WebDriver> getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        return () -> new ChromeDriver(options);
    }

    private static Supplier<WebDriver> getFirefoxDriver() {
        return FirefoxDriver::new;
    }

    private static Supplier<WebDriver> getSafariDriver() {
        return SafariDriver::new;
    }


}
