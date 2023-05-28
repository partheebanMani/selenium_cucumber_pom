package com.partheeban.stepdefinitions;

import com.partheeban.pages.Inventory;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class InventoryStepDefs {

    private Scenario scenario;
    private WebDriver driver;
    private Inventory inventory;

    public InventoryStepDefs(BaseSteps baseSteps) {
        scenario = baseSteps.getScenario();
        driver = baseSteps.getDriver();
    }

    @Then("verify browser navigated to inventory page")
    public void verifyBrowserNavigatedToInventoryPage() {
        assertThat(inventory.getAppLogoText()).as("App logo name is not same as expected")
                .isEqualToIgnoringCase("Swag labs");
    }
}
