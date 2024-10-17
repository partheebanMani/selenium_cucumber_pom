package com.partheeban.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductInformation extends BasePage {

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backToProduct;

    @FindBy(xpath = "//div[@class='inventory_details_container']/div[2]/div[2]")
    private WebElement productDescription;


    public ProductInformation(WebDriver webDriver) {
        super(webDriver);
    }

    public String getProductDescriptionDetails() {
        return productDescription.getText();
    }

    public void goBackToProductPage() {
        backToProduct.click();
    }


}
