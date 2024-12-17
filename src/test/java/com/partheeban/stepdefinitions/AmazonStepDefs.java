package com.partheeban.stepdefinitions;

import com.partheeban.drivers.BaseDriver;
import com.partheeban.utility.SeleniumUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class AmazonStepDefs {


    String searchTextBox = "twotabsearchtextbox";
    String productTitleXpath = "//span[text()='%s']";

    String addToCartLink = productTitleXpath + "/ancestor::h2/ancestor::div[1]/following-sibling::div[2]/div/div/div[4]/div/div/div";

    String addedToCart = addToCartLink + "[4]/div/div/div[4]/span[1]";

    String addToCartButtonInNewPage = "add-to-cart-button";


    private BaseSteps baseSteps;
    private WebDriver webDriver;

    public AmazonStepDefs(BaseSteps baseSteps) {
        this.baseSteps = baseSteps;
    }


    @Given("open amazon website")
    public void openAmazonWebsite() {
        webDriver = BaseDriver.getWebDriver();
        webDriver.get("https://www.amazon.in/");
    }

    @Then("Find product {string}")
    @SneakyThrows
    public void findProductIphone(String product) {
        webDriver.findElement(By.id(searchTextBox)).sendKeys(product);
        webDriver.findElement(By.id(searchTextBox)).sendKeys(Keys.ENTER);
    }


    @Then("Add {string} to amazon cart")
    @SneakyThrows
    public void addAppleIPhoneGBUltramarineToAmazonCart(String product) {
        WebElement element = webDriver.findElement(By.xpath(String.format(productTitleXpath, product)));
        SeleniumUtility.scrollToElementInView(webDriver, element);
        webDriver.findElement(By.xpath(String.format(addToCartLink, product))).click();
        String expectedString = webDriver.findElement(By.xpath(String.format(addedToCart, product))).getText();
        assertThat(expectedString).as("Expected message is not received").isEqualTo("1 in cart");
    }

    @And("open {string}")
    @SneakyThrows
    public void openAppleIPhoneGBUltramarine(String product) throws InterruptedException {
        WebElement element = webDriver.findElement(By.xpath(String.format(productTitleXpath, product)));
        SeleniumUtility.scrollToElementInView(webDriver, element);
        element.click();
        Thread.sleep(6000);

        Set<String> windowHandles = webDriver.getWindowHandles();

        for (String window : windowHandles) {
            webDriver.switchTo().window(window);
        }

        WebElement addToCartButton = webDriver.findElement(By.id(addToCartButtonInNewPage));
        
        addToCartButton.click();


    }


}
