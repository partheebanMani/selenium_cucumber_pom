package com.partheeban.drivers;

import com.partheeban.enums.Browsers;
import com.partheeban.exceptions.BrowserNotSupportedException;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;


//Factory design pattern used here
// getDriverprovider method return webDriver
public class DriverFactory {
    private static final Map<Browsers, Supplier<DriverProvider>> providers = new EnumMap<>(Browsers.class);

    static {
        providers.put(Browsers.CHROME, ChromeDriverProvider::new);
        providers.put(Browsers.FIREFOX, FirefoxDriverProvider::new);
        providers.put(Browsers.SAFARI, SafariDriverProvider::new);
    }

    public static DriverProvider getDriverProvider(String browser) {

        if (browser == null || browser.isEmpty() || browser.isBlank()) {
            throw new IllegalArgumentException("Browser name cannot be null or empty");
        }

        String finalBrowser = browser;
        return providers.getOrDefault(Browsers.valueOf(browser.toUpperCase()),
                () -> {
                    throw new BrowserNotSupportedException("Browser not supported: " + finalBrowser);
                }
        ).get();
    }

}
