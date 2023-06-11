package com.partheeban.stepdefinitions;

import com.partheeban.utility.BaseDriver;
import com.partheeban.utility.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

@Data
public class BaseSteps {

    private WebDriver driver;
    private Scenario scenario;


    @Before(order = 0)
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
    }

    @Before(order = 1)
    public void driverSetUp() throws InterruptedException {
        System.out.println("===============Driver setup hook===================== ");
        DriverManager.setUpDriver();
        driver = BaseDriver.getWebDriver();
    }

    @After(order = -1)
    public void takeScreenshot(Scenario scenario) {
        System.out.println("================after hook is called take screenshot=================");
        DriverManager.takeScreenshot(scenario);
    }

    @After(order = 0)
    public void exit() {
        System.out.println("============after hook is called take screenshot======================");
        DriverManager.closeDriver();
    }

    @AfterSuite
    public void exitBrowser() {
        DriverManager.quitDriver();
    }

}
