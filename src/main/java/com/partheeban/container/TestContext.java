package com.partheeban.container;


import io.cucumber.java.Scenario;
import io.restassured.response.Response;

public class TestContext {

    public Response response;
    public String jsonResponseString;

    public Scenario scenario;
}
