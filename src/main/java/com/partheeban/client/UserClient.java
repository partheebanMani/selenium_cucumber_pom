package com.partheeban.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.partheeban.utility.PropertiesConfig.PROPERTIES_CONFIG;
import static io.restassured.RestAssured.given;

public class UserClient extends BaseClient {

    private final String token;

    public UserClient(String token) {
        super();
        this.token = token;
    }

    public Response createUser(String payload) {
        return requestSpec().body(payload).post("/create");
    }

    private RequestSpecification requestSpec() {
        return given()
                .spec(requestSpecification)
                .baseUri(PROPERTIES_CONFIG.userBaseUrl())
                .auth()
                .oauth2(token)
                .contentType(ContentType.JSON);
    }
}
