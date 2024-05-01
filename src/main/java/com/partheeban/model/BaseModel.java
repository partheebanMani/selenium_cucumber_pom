package com.partheeban.model;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseModel {

    protected ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    public String toJsonString() {
        String jsonString = null;
        try {
            jsonString = OBJECT_MAPPER.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public String toJsonStringWithPrettyPrinter() {
        String jsonString = null;
        try {
            jsonString = OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;

    }
}
