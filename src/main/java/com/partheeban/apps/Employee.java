package com.partheeban.apps;

import com.partheeban.client.EmployeeClient;
import com.partheeban.utility.RestAssuredUtility;
import lombok.Getter;
import lombok.experimental.ExtensionMethod;

/**
 * Employee application module for API operations.
 */
@Getter
@ExtensionMethod(RestAssuredUtility.class)
public class Employee {

    public final EmployeeClient client;

    /**
     * Initializes the Employee API specification.
     */
    public Employee() {
        System.out.println("employee constructor called");
        this.client = new EmployeeClient();
    }

}
