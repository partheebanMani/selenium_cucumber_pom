package com.partheeban.stepdefinitions;

import com.partheeban.pages.Login;
import com.partheeban.utility.BaseDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.partheeban.utility.PropertiesConfig.PROPERTIES_CONFIG;
import static org.assertj.core.api.Assertions.assertThat;


public class SampleTestDefs extends BaseDriver {

    private WebDriver driver;

    public SampleTestDefs(BaseSteps baseSteps) {
        this.driver = baseSteps.getDriver();
    }

    private Login login;

    @Given("Enter username as {string}")
    public void enterUsernameAsStandard_user(String username) {
        login = new Login(driver);
        login.enterUserName(username);
    }

    @When("Enter password as {string}")
    public void enterPasswordAsSecret_sauce(String password) {
        login.enterPassword(password);
    }

    @Then("Click login button")
    public void clickLoginButton() throws InterruptedException {
        login.clickLoginButton();
        Thread.sleep(10000);
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
