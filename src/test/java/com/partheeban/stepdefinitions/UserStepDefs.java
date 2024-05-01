package com.partheeban.stepdefinitions;

import com.partheeban.BaseApplication;
import com.partheeban.container.TestContext;
import com.partheeban.model.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import java.util.List;
import java.util.Map;

import static com.partheeban.enums.RestAPIs.USERS;
import static org.assertj.core.api.Assertions.assertThat;

public class UserStepDefs extends BaseApplication {

    private TestContext testContext;

    public UserStepDefs(TestContext testContext) {
        super(List.of(USERS));
        this.testContext = testContext;
    }

    @Given("Create user with below details")
    public void createUserWithBelowDetails(DataTable datatable) {
        List<Map<String, String>> maps = datatable.asMaps(String.class, String.class);

        for (Map<String, String> row : maps) {
            User userPayload = new User(row.get("name"), Double.parseDouble(row.get("salary")), Integer.parseInt(row.get("age")));
            String payload = userPayload.toJsonStringWithPrettyPrinter();

            testContext.response = user.getUserSpecfication()
                    .given()
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .post("/api/v1/create");

            System.out.println(testContext.response.getBody());
            System.out.println(testContext.response.getStatusCode());

            assertThat(testContext.response.getStatusCode()).as("response code is not expected")
                    .isEqualTo(HttpStatus.SC_CREATED);


        }
    }
}
