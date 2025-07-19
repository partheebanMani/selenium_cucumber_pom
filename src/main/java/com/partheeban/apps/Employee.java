package com.partheeban.apps;

import com.partheeban.utility.RestAssuredUtility;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.experimental.ExtensionMethod;

import static com.partheeban.utility.PropertiesConfig.PROPERTIES_CONFIG;

/**
 * Employee application module for API operations.
 */
@Getter
@ExtensionMethod(RestAssuredUtility.class)
public class Employee {

    private final RequestSpecification employeeSpecification;

    /**
     * Initializes the Employee API specification.
     */
    public Employee() {
        System.out.println("employee constructor called");
        employeeSpecification = PROPERTIES_CONFIG.EmployeeBaseUrl().getRequestSpecBuilder();
    }

//    @Override
//    public  dataBaseConnection() {
//        System.out.println("data Base connection");
//    }

}
