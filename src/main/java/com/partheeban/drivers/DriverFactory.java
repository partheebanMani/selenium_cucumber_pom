package com.partheeban.drivers;

import com.partheeban.enums.Browsers;
import com.partheeban.exceptions.BrowserNotSupportedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Factory class for providing DriverProvider instances based on browser type.
 */
public final class DriverFactory {
    private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);
    private static final Map<Browsers, Supplier<DriverProvider>> providers = new EnumMap<>(Browsers.class);

    static {
        providers.put(Browsers.CHROME, ChromeDriverProvider::new);
        providers.put(Browsers.FIREFOX, FirefoxDriverProvider::new);
        providers.put(Browsers.SAFARI, SafariDriverProvider::new);
    }

    // Prevent instantiation
    private DriverFactory() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Returns a DriverProvider for the specified browser.
     *
     * @param browser browser name (case-insensitive)
     * @return DriverProvider instance
     * @throws IllegalArgumentException     if browser is null, empty, or blank
     * @throws BrowserNotSupportedException if browser is not supported
     */
    public static DriverProvider getDriverProvider(String browser) {
        Objects.requireNonNull(browser, "Browser name cannot be null");
        if (browser.isEmpty() || browser.isBlank()) {
            throw new IllegalArgumentException("Browser name cannot be empty or blank");
        }

        Browsers browserEnum;
        try {
            browserEnum = Browsers.valueOf(browser.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            log.error("Browser not supported: {}", browser);
            throw new BrowserNotSupportedException("Browser not supported: " + browser);
        }

        Supplier<DriverProvider> provider = providers.get(browserEnum);
        if (provider == null) {
            log.error("No provider registered for browser: {}", browser);
            throw new BrowserNotSupportedException("Browser not supported: " + browser);
        }
        return provider.get();
    }

}
