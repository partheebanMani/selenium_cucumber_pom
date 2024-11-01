package com.partheeban.stepdefinitions;

import com.partheeban.BaseApplication;
import com.partheeban.container.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.partheeban.enums.RestAPIs.CAT;
import static org.assertj.core.api.Assertions.assertThat;

public class CatServiceStepDefs extends BaseApplication {

    TestContext testContext;
    ResultSet resultSet;
    Statement statement = null;


    public CatServiceStepDefs(TestContext testContext) {
        super(List.of(CAT));
        this.testContext = testContext;
    }

    @When("Run query {string} in cat service")
    public void runQueryInCatService(String query) throws SQLException {
        Connection dataBaseConnection = cat.getDataBaseConnection();
        statement = dataBaseConnection.createStatement();
        resultSet = statement.executeQuery(query);
    }

    @Then("verify result is matching with expected {int}")
    @SneakyThrows
    public void verifyResultIsMatchingWithExpected(int expectedCount) {

        try {
            if (resultSet.next()) {
                int acutalCount = resultSet.getInt("count");
                assertThat(acutalCount).as("Count is not matching").isEqualTo(expectedCount);
            }
        } finally {
            closeResources();
        }
    }

    private void closeResources() {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace(); // You may want to log this instead of printing
        }

    }

}
