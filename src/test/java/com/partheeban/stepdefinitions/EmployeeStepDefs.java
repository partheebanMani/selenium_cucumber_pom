package com.partheeban.stepdefinitions;

import com.partheeban.BaseApplication;
import com.partheeban.container.TestContext;
import com.partheeban.enums.RestAPIs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSender;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class EmployeeStepDefs extends BaseApplication {

    private final RequestSender employeeRequestSpecBuilder;
    private final TestContext testContext;

    public EmployeeStepDefs(TestContext testContext) {
        super(List.of(RestAPIs.EMPLOYEE));
        this.testContext = testContext;
        employeeRequestSpecBuilder = employee.getEmployeeSpecification();
    }

    @Given("Call get all employee API")
    public void callGetAllEmployeeAPI() {
        testContext.response = employeeRequestSpecBuilder.get("/api/user?page=2");
    }

    @When("verify response code is {int}")
    public void verifyResponseCodeIs(int expectedResponseCode) {
        assertThat(testContext.response.getStatusCode()).as("Response code didn't match expected status code")
                .isEqualTo(expectedResponseCode);
        testContext.jsonResponseString = testContext.response.getBody().asString();

    }

    @Then("verify total data is equal to per_page")
    public void verifyTotalDataIsEqualToPer_page() {
        JSONObject jsonObject = new JSONObject(testContext.jsonResponseString);
        int per_page = jsonObject.getInt("per_page");
        int data_count = jsonObject.getJSONArray("data").length();
        assertThat(per_page).as("count is not matching").isEqualTo(data_count);
    }
}
