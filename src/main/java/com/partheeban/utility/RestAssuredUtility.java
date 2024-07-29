package com.partheeban.utility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtility {


    public static RequestSpecification getRequestSpecBuilder(String url) {
        return RestAssured.given()
                .baseUri(url)
                .contentType(ContentType.JSON);
    }

    public static RequestSpecification getRequestSpecBuilder(String url, String token) {
        return RestAssured.given()
                .baseUri(url)
                .auth()
                .oauth2(token)
                .contentType(ContentType.JSON);
    }

}
