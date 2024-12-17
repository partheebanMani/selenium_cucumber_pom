package com.partheeban.utility;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class Util {
    public class CSV {

        public List<String[]> readAllLines(String filePath) throws Exception {
            return Files.lines(Paths.get(filePath))
                    .map(line -> line.split(","))
                    .toList();

        }
    }

    public class Wait {
        public WebElement getExplicitWebElement(WebDriver driver, int seconds, By element) {
            return new WebDriverWait(driver, Duration.ofSeconds(seconds)).
                    until(ExpectedConditions.elementToBeClickable(element));
        }

        public void getFluentWait(WebDriver driver, int timeout, int pollingfrequency, String id) {
            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofSeconds(pollingfrequency))
                    .ignoring(NoSuchElementException.class);

            wait.until(s -> s.findElement(By.id(id)));
        }
    }

    public class FilesUtil {

        static final String DATA_FILES_LOCATION = "src/main/resources";

        @SneakyThrows
        public String getDataFromFile(String fileName) throws IOException {
            Path path = Paths.get(DATA_FILES_LOCATION + fileName);
            Stream<String> lines = Files.lines(path);
            String data = lines.collect(Collectors.joining("\n"));
            lines.close();
            return data;
        }

    }


    public class StringHelper {

        public String randomString(int length) {
            return RandomStringUtils.randomAlphabetic(length);
        }
    }

}
