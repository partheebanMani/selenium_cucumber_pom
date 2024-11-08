package com.partheeban.stepdefinitions;

import com.partheeban.drivers.BaseDriver;
import com.partheeban.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;

import static com.partheeban.utility.PropertiesConfig.PROPERTIES_CONFIG;
import static org.assertj.core.api.Assertions.assertThat;


public class SampleTestDefs {

    private Login login;


    @Given("Enter username as {string}")
    public void enterUsernameAsStandard_user(String username) {
        BaseDriver.getWebDriver().get(PROPERTIES_CONFIG.url());
        login = new Login(BaseDriver.getWebDriver());
        login.enterUserName(username);
    }

    @When("Enter password as {string}")
    public void enterPasswordAsSecret_sauce(String password) {
        login.enterPassword(password);
    }

    @Then("Click login button")
    @SneakyThrows
    public void clickLoginButton() {
        login.clickLoginButton();
    }

    @When("verify this is {string}")
    public void verifyThisIsTrue(String value) {
        assertThat(value).as("test case failed").isEqualToIgnoringCase("true");
    }

    @When("verify login is successful")
    public void verifyLoginIsSuccessful() {
        assertThat(login.getCurrentPageURL()).isNotEqualTo(PROPERTIES_CONFIG.url());
    }

    @When("verify browser remains in login page")
    public void verifyBrowserRemainsInLoginPage() {
        assertThat(login.getCurrentPageURL()).isEqualTo(PROPERTIES_CONFIG.url());
    }
}
