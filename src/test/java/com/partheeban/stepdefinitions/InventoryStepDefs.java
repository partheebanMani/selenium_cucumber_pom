package com.partheeban.stepdefinitions;

import com.partheeban.pages.Inventory;
import com.partheeban.utility.BaseDriver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
public class InventoryStepDefs {

    private Scenario scenario;
    private Inventory inventory;

    public InventoryStepDefs(BaseSteps baseSteps) {
        scenario = baseSteps.getScenario();
    }

    @Then("verify browser navigated to inventory page")
    public void verifyBrowserNavigatedToInventoryPage() {
        inventory = new Inventory(BaseDriver.getWebDriver());
        assertThat(inventory.getAppLogoText()).as("App logo name is not same as expected")
                .isEqualToIgnoringCase("Swag labs");
    }

    @Given("sort by name {string}")
    public void sortByName(String name) {
        inventory.selectDropDownByName(name);
    }

    @Given("verify {string} is present in products page")
    public void verifySauceLabsBackpackIsPresentInProductsPage(String productName) {
        assertThat(inventory.isProductAvailable(productName)).as("product is not available in product page").isTrue();
    }

    @When("Add {string} to cart")
    public void addSauceLabsBackpackToCart(String productName) {
        Arrays.stream(productName.split(",")).forEach(product -> inventory.findProductAndAddToCart(product));
    }

    @Then("verify {string} is added in cart")
    @SneakyThrows
    public void verifySauceLabsBackpackIsAddedInCart(String productName) {
    }

    @When("Verify cart count is increased to {int}")
    public void verifyCartCountIsIncreasedTo(int expectedCount) {
        assertThat(inventory.getCartCount()).as("Cart count is not as expected").isEqualTo(expectedCount);
    }

    @When("Click shopping cart icon")
    @SneakyThrows
    public void clickShoppingCartIcon() {
        inventory.clickShoppingCartLink();
    }


}
