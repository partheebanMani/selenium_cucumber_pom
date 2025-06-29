package com.partheeban.stepdefinitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindBrokenLinks {


    public static boolean verifyLinks(String href) {

        Response response = RestAssured.given().get(URI.create(href).toString());

        int responseCode = response.statusCode();

        return responseCode >= HttpStatus.SC_OK && responseCode < HttpStatus.SC_MULTIPLE_CHOICES;

    }

    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();


        webDriver.get("https://www.google.co.in/");
        webDriver.findElement(By.name("q")).sendKeys("find urls");
        webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("logo"))));

        List<WebElement> links = webDriver.findElements(By.tagName("a"));
        List<String> brokenLinks = new ArrayList<>();

        for (WebElement element : links) {

            String href = element.getAttribute("href");

            if (href != null && !verifyLinks(href)) {
                brokenLinks.add(href);
            }
        }

        Select select = new Select(webDriver.findElement(By.id("df")));
        select.selectByIndex(9);
        

        webDriver.close();
        webDriver.quit();


        System.out.println(brokenLinks.toString());

        Map<String, Integer> maps = Map.of("sfsd", 23, "werewr", 45);

        Double average = maps.values().stream().mapToInt(Integer::intValue).average().orElse(0);

    }
}
