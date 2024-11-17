import com.partheeban.drivers.BaseDriver;
import com.partheeban.stepdefinitions.BaseSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AmazonStepDefs {


    String searchTextBox = "twotabsearchtextbox";
    String productTitleXpath = "//span[text()='%s']";


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
        Thread.sleep(5000);
    }


    @Then("Add {string} to amazon cart")
    public void addAppleIPhoneGBUltramarineToAmazonCart(String product) {
        webDriver.findElement(By.xpath(String.format(productTitleXpath, product)));
    }
}
