package com.partheeban.stepdefinitions;

import com.partheeban.drivers.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.partheeban.utility.PropertiesConfig.PROPERTIES_CONFIG;

public class UtilitiesStepDefs {

    private BaseSteps baseSteps;

    private WebDriver webDriver;

    private String googleSearchXpath = "//textarea[@id='APjFqb']";
    private String clickSearch = "//input[@class='gNO89b']";

    public UtilitiesStepDefs(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
        webDriver = BaseDriver.getWebDriver();
    }

    @Given("Open google page")
    public void openGooglePage() {
        webDriver.get(PROPERTIES_CONFIG.googleUrl());
    }


    @When("Enter product to search for {string}")
    public void enterProductToSearchFor(String product) throws InterruptedException {
        webDriver.findElement(By.xpath(googleSearchXpath)).sendKeys(product);
        webDriver.findElement(By.xpath(clickSearch)).click();
        Thread.sleep(10000);
    }

    @Then("Find site which has lowest price")
    public void findSiteWhichHasLowestPrice() {
    }

    @And("Navigate to shopping section")
    public void navigateToShoppingSection() {

    }

    @Given("Execute the test case")
    @SneakyThrows
    public void executeTheTestCase() {
        String FOURTH_STAR = "//*[@class='rvs-svg']/div/*[name()='svg'][4]";
        webDriver.get("https://wallethub.com/profile/test-insurance-company-13732055i");
        WebElement element = webDriver.findElement(By.xpath(FOURTH_STAR));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).perform();
        Thread.sleep(5000);

        actions.moveToElement(element).click().perform();
        Thread.sleep(5000);
        provideFeedBack("Life Insurance");
    }


    @SneakyThrows
    public void provideFeedBack(String dropDownToSelect) {

        String dropDownElement = "//*[@id=\"reviews-section\"]/modal-dialog/div/div/write-review/div[2]/div[2]/div[2]/ng-dropdown/div/ul";
        String dropElements = "//*[@id=\"reviews-section\"]/modal-dialog/div/div/write-review/div[2]/div[2]/div[2]/ng-dropdown/div/ul/li";

        WebElement element = webDriver.findElement(By.xpath(dropDownElement));

        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build();
        actions.perform();

        for (WebElement webDriverElement : webDriver.findElements(By.xpath(dropElements))) {

            if (webDriverElement.getText().equalsIgnoreCase(dropDownToSelect)) {
                actions.click();
                break;
            }


        }

        Thread.sleep(5000);

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Boolean until = new WebDriverWait(webDriver, Duration.ofSeconds(2)).until(S -> element.isEnabled());
    }
}
