package com.partheeban.stepdefinitions;

import com.partheeban.drivers.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.Data;


@Data
public class BaseSteps {

    private Scenario scenario;


    @Before(value = "@Selenium", order = 0)
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
    }

    @Before(value = "@Selenium", order = 1)
    public void driverSetUp() throws InterruptedException {
        System.out.println("===============Driver setup hook===================== ");
        BaseDriver.getWebDriver();
    }

    @After(value = "@Selenium", order = 1)
    public void takeScreenshot(Scenario scenario) {
        System.out.println("================after hook is called take screenshot=================");
        BaseDriver.takeScreenshot(scenario);
    }

    @After(value = "@Selenium", order = 0)
    public void exit() {
        System.out.println("============after hook to close Driver======================");
        BaseDriver.quitDriver();
    }
}
