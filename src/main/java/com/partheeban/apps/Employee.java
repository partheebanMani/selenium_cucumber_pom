package com.partheeban.apps;

import com.partheeban.utility.PropertiesConfig;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;


@Getter
public class Employee {

    private RequestSpecification employeeSpecification;

    public Employee() {
        System.out.println("employee constructor called");
        RestAssured.baseURI = PropertiesConfig.PROPERTIES_CONFIG.EmployeeBaseUrl();
        employeeSpecification = RestAssured.given();
    }
}
