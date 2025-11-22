package com.partheeban.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object for the product information/details page.
 */
public class ProductInformation extends BasePage {

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backToProduct;

    @FindBy(xpath = "//div[@class='inventory_details_container']/div[2]/div[2]")
    private WebElement productDescription;

    public ProductInformation(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Gets the product description details.
     *
     * @return product description text, or empty string if not present
     */
    public String getProductDescriptionDetails() {
        return productDescription != null ? productDescription.getText() : "";
    }

    /**
     * Navigates back to the product page.
     */
    public void goBackToProductPage() {
        backToProduct.click();
    }
}
