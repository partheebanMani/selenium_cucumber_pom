package com.partheeban.apps;

import com.partheeban.utility.PropertiesConfig;
import com.partheeban.utility.RestAssuredUtility;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.experimental.ExtensionMethod;


@Getter
@ExtensionMethod(RestAssuredUtility.class)
public class Employee {

    private final RequestSpecification employeeSpecification;

    public Employee() {
        System.out.println("employee constructor called");
        employeeSpecification = PropertiesConfig.PROPERTIES_CONFIG.EmployeeBaseUrl().getRequestSpecBuilder();
    }
}
