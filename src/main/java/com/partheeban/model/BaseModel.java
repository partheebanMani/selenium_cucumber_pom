package com.partheeban.model;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//using this Base model class, TEMPLATE METHOD PATTERN has been implemented in the USer class
public abstract class BaseModel {

    private static final Logger log = LoggerFactory.getLogger(BaseModel.class);
    protected ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    public String toJsonString() {
        String jsonString = null;
        try {
            jsonString = OBJECT_MAPPER.writeValueAsString(this);
        } catch (Exception e) {
            log.error("Error serializing object to JSON", e);
        }
        return jsonString;
    }

    public String toJsonStringWithPrettyPrinter() {
        String jsonString = null;
        try {
            jsonString = OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (Exception e) {
            log.error("Error serializing object to pretty JSON", e);
        }
        return jsonString;
    }

    public byte[] toByteArray() {
        byte[] bytes = null;
        try {
            bytes = OBJECT_MAPPER.writeValueAsBytes(this);
        } catch (Exception e) {
            log.error("Error serializing object to byte array", e);
        }
        return bytes;
    }

}
