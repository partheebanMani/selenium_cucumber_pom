package com.partheeban.drivers;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class BaseDriver {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static final Logger log = LoggerFactory.getLogger(BaseDriver.class);

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
            takeSeleniumScreenshot(scenario);
//            getFullPageScreenshot(scenario);
        }
    }

    public static void takeSeleniumScreenshot(Scenario scenario) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getWebDriver();
        byte[] src = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        scenario.attach(src, "image/png", "screenshot");

    }

    public static void takeScreenshot(String location) throws IOException {
        File file = new File(location);
        TakesScreenshot takesScreenshot = (TakesScreenshot) getWebDriver();
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, file);
    }

    public static void getFullPageScreenshot(Scenario scenario) {

        try {
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                    .takeScreenshot(getWebDriver());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(screenshot.getImage(), "PNG", baos);
            byte[] imageBytes = baos.toByteArray();
            scenario.attach(imageBytes, "image/png", "FullPageScreenshot");

        } catch (Exception e) {
            log.info("Exception occurred while taking screenshot");

        }

    }

}
