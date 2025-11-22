package com.partheeban.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.partheeban.utility.PropertiesConfig.PROPERTIES_CONFIG;

public class UserClient extends BaseClient {

    private String token;

    public UserClient(String token) {
        super();
        this.token = token;
    }

    public Response createUser(String payload) {
        return requestSpec().body(payload).post("/createUser");
    }

    private RequestSpecification requestSpec() {
        return requestSpecification.baseUri(PROPERTIES_CONFIG.userBaseUrl())
                .auth()
                .oauth2(token)
                .contentType(ContentType.JSON);

    }
}
