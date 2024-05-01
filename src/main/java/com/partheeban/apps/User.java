package com.partheeban.apps;

import com.partheeban.utility.PropertiesConfig;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

@Getter
public class User {

    private RequestSpecification userSpecfication;

    public User() {
        RestAssured.baseURI = PropertiesConfig.PROPERTIES_CONFIG.userBaseUrl();
        userSpecfication = RestAssured.given();
    }
}
