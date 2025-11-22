package com.partheeban.stepdefinitions;

import com.partheeban.drivers.BaseDriver;
import com.partheeban.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.partheeban.utility.PropertiesConfig.PROPERTIES_CONFIG;
import static org.assertj.core.api.Assertions.assertThat;


public class SampleTestDefs {

    private static final Logger log = LoggerFactory.getLogger(SampleTestDefs.class);
    private Login login;


    @Given("Enter username as {string}")
    public void enterUsernameAsStandard_user(String username) {
        login = new Login(BaseDriver.getWebDriver());
        login.goTo(PROPERTIES_CONFIG.url());
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
        assertThat(login.getCurrentUrl()).isNotEqualTo(PROPERTIES_CONFIG.url());
    }

    @When("verify browser remains in login page")
    public void verifyBrowserRemainsInLoginPage() {
        assertThat(login.getCurrentUrl()).isEqualTo(PROPERTIES_CONFIG.url());
    }
}
