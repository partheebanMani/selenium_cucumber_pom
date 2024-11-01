package com.partheeban.apps;

import com.partheeban.utility.PropertiesConfig;
import com.partheeban.utility.RestAssuredUtility;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.experimental.ExtensionMethod;
import org.apache.commons.lang3.StringUtils;

@Getter
@ExtensionMethod(RestAssuredUtility.class)
public class User {

    private final RequestSpecification userSpecfication;
    private String token;
    private String database;

    public User() {
        if (StringUtils.isEmpty(token)) {
            generateToken();
        }
        userSpecfication = PropertiesConfig.PROPERTIES_CONFIG.userBaseUrl().getRequestSpecBuilder(token);
//        dataBaseConnection();
    }

    private void generateToken() {
        System.out.println("generate token");
        token = "sdfdsfsdfsdf";
    }

//    @Override
//    public void dataBaseConnection() {
//        database = "databaseConnection";
//        System.out.println("users DataBase");
//    }

}
