package com.partheeban.stepdefinitions;

import com.partheeban.BaseApplication;
import com.partheeban.container.TestContext;
import com.partheeban.model.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static com.partheeban.constants.APIUrl.CREATE_USER_BASE_PATH;
import static com.partheeban.constants.JsonFields.*;
import static com.partheeban.enums.RestAPIs.USERS;

public class UserStepDefs extends BaseApplication {

    private TestContext testContext;
    private RequestSpecification userRequestSpecification;

    public UserStepDefs(TestContext testContext) {
        super(List.of(USERS));
        this.testContext = testContext;
        userRequestSpecification = user.getUserSpecfication();
    }

    @Given("Create user with below details")
    public void createUserWithBelowDetails(DataTable datatable) {
        List<Map<String, String>> maps = datatable.asMaps(String.class, String.class);

        System.out.println("user step definition" + user.getDatabase());

        for (Map<String, String> row : maps) {
            User userPayload = new User(row.get(NAME), Double.parseDouble(row.get(SALARY)), Integer.parseInt(row.get(AGE)));
            String payload = userPayload.toJsonStringWithPrettyPrinter();

            testContext.response = userRequestSpecification
                    .body(payload)
                    .post(CREATE_USER_BASE_PATH);

        }
    }

}
