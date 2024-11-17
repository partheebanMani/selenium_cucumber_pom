package com.partheeban.drivers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {
    private static final Map<String, Supplier<DriverProvider>> providers = new HashMap<>();

    static {
        providers.put("chrome", ChromeDriverProvider::new);
        providers.put("firefox", FirefoxDriverProvider::new);
        providers.put("safari", SafariDriverProvider::new);
    }

    public static DriverProvider getDriverProvider(String browser) {
        return providers.getOrDefault(browser.toLowerCase().trim(),
                () -> {
                    throw new RuntimeException("Browser not supported: " + browser);
                }
        ).get();
    }

}
