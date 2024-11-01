package com.partheeban.model;


import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel {

    private String name;
    private Double salary;
    private int age;

    public User getPOJO(String jsonString) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(jsonString, User.class);
    }

    public List<User> getPOJOList(String jsonString) throws JsonProcessingException {
        return Arrays.asList(OBJECT_MAPPER.readValue(jsonString, User[].class));
    }


}
