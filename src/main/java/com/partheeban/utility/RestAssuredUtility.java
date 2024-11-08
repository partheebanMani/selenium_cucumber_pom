package com.partheeban.utility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RestAssuredUtility {


    public RequestSpecification getRequestSpecBuilder(String url) {
        return RestAssured.given()
                .baseUri(url);
    }

    public RequestSpecification getRequestSpecBuilder(String url, String token) {
        return RestAssured.given()
                .baseUri(url)
                .auth()
                .oauth2(token)
                .contentType(ContentType.JSON);
    }


}
