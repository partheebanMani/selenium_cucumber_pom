package com.partheeban.stepdefinitions;

import com.partheeban.BaseApplication;
import com.partheeban.container.TestContext;
import com.partheeban.model.User;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

import static com.partheeban.constants.JsonFields.*;
import static com.partheeban.enums.RestAPIs.USERS;

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
            User userPayload = new User(row.get(NAME), Double.parseDouble(row.get(SALARY)), Integer.parseInt(row.get(AGE)));
            String payload = userPayload.toJsonStringWithPrettyPrinter();
            testContext.response = user.client.createUser(payload);
        }
    }

}
