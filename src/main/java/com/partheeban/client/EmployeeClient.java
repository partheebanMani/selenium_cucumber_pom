package com.partheeban.client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.partheeban.constants.APIUrl.EMPLOYEE_GET_BASE_PATH;
import static com.partheeban.utility.PropertiesConfig.PROPERTIES_CONFIG;

public class EmployeeClient extends BaseClient {

    public EmployeeClient() {
        super();
    }


    public Response getAllEmployees(int pageNo) {
        return requestSpec().pathParam("pageNo", pageNo).get(EMPLOYEE_GET_BASE_PATH);
    }

    private RequestSpecification requestSpec() {
        return requestSpecification.baseUri(PROPERTIES_CONFIG.EmployeeBaseUrl())
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json");

    }


}
