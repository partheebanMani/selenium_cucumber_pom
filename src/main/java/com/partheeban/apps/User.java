package com.partheeban.apps;

import com.partheeban.client.UserClient;
import com.partheeban.utility.RestAssuredUtility;
import lombok.Getter;
import lombok.experimental.ExtensionMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User application module for API operations.
 */
@Getter
@ExtensionMethod(RestAssuredUtility.class)
public class User {

    private static final Logger log = LoggerFactory.getLogger(User.class);

    public UserClient client;
    private String token;
    private final String database = null;

    /**
     * Initializes the User API specification and token.
     */
    public User() {
        if (StringUtils.isBlank(token)) {
            generateToken();
        }
        client = new UserClient(token);
    }

    /**
     * Generates a user token.
     */
    private void generateToken() {
        log.info("Generating user token...");
        token = "sdfdsfsdfsdf";
    }
}
