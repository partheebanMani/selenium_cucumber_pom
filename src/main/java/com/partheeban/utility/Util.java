package com.partheeban.utility;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
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

        public void getFluentWait(WebDriver driver, int timeout, int pollingFrequency, String id) {
            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofSeconds(pollingFrequency))
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


    public class JSON {

        public void validateJsonSchema(String jsonSchema, String jsonString) {
            JSONObject schema = new JSONObject(jsonSchema);
            JSONObject data = new JSONObject(jsonSchema);
            SchemaLoader.load(schema).validate(data);
        }
    }

    public class ExcelUtility {

        public Object[][] readExcelSheet(String location) throws IOException {

            int SHEETNUMBER = 0;

            Object[][] data = null;
            FileInputStream fileInputStream = null;
            XSSFWorkbook xssfWorkbook = null;
            try {

                fileInputStream = new FileInputStream(location);
                xssfWorkbook = new XSSFWorkbook(fileInputStream);
                XSSFSheet sheet = xssfWorkbook.getSheetAt(SHEETNUMBER);

                if (sheet == null)
                    throw new RuntimeException("No sheet present in this excel file");

                int rowsCount = sheet.getLastRowNum();
                int columnCount = sheet.getRow(0).getLastCellNum();

                data = new Object[rowsCount][columnCount];

                for (int i = 0; i < rowsCount; i++) {
                    XSSFRow row = sheet.getRow(i);

                    for (int j = 0; j < columnCount; j++) {
                        XSSFCell cell = row.getCell(j);

                        if (cell == null) {
                            data[i][j] = "";
                        } else {
                            CellType cellType = cell.getCellType();

                            switch (cellType) {
                                case NUMERIC -> data[i][j] = cell.getNumericCellValue();
                                case BOOLEAN -> data[i][j] = cell.getBooleanCellValue();
                                default -> data[i][j] = cell.getStringCellValue();
                            }

                        }
                    }

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (xssfWorkbook != null)
                    xssfWorkbook.close();

                if (fileInputStream != null)
                    fileInputStream.close();
            }

            return data;

        }


    }

    public static class RandomUtil {

        public static <T extends Enum<T>> T randomMember(Class<T> enumType) {
            T[] constants = enumType.getEnumConstants();
            if (constants == null || constants.length == 0) {
                return null;
            }

            Random random = new Random();
            int randomIndex = random.nextInt(constants.length);
            return constants[randomIndex];
        }


    }

}
