package com.partheeban.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.partheeban.constants.APIUrl.EMPLOYEE_GET_BASE_PATH;
import static com.partheeban.utility.PropertiesConfig.PROPERTIES_CONFIG;
import static io.restassured.RestAssured.given;

public class EmployeeClient extends BaseClient {

    public EmployeeClient() {
        super();
    }


    public Response getAllEmployees(int pageNo) {
        return requestSpec().pathParam("pageNo", pageNo).get(EMPLOYEE_GET_BASE_PATH);
    }

    private RequestSpecification requestSpec() {
        return given().spec(requestSpecification).baseUri(PROPERTIES_CONFIG.EmployeeBaseUrl())
                .relaxedHTTPSValidation()
                .header("x-api-key", "reqres-free-v1")
                .contentType(ContentType.JSON);

    }


}
