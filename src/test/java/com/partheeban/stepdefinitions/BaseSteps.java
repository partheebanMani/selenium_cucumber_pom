package com.partheeban.stepdefinitions;

import com.partheeban.drivers.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.Data;


@Data
public class BaseSteps {

    private Scenario scenario;


    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
    }
    
    @After(order = 1)
    public void takeScreenshot(Scenario scenario) {
        System.out.println("================after hook is called take screenshot=================");
        BaseDriver.takeScreenshot(scenario);
    }

    @After(order = 0)
    public void exit() {
        System.out.println("============after hook to close Driver======================");
        BaseDriver.quitDriver();
    }
}
