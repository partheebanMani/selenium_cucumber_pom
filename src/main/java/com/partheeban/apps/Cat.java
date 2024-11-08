package com.partheeban.apps;

import com.partheeban.utility.PropertiesConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Cat extends BaseApps {


    private static final Logger log = LoggerFactory.getLogger(Cat.class);
    Connection connection = null;

    @Override
    public Connection dataBaseConnection() {

        try {
            connection = DriverManager.getConnection(PropertiesConfig.PROPERTIES_CONFIG.catDataBaseUrl(),
                    PropertiesConfig.PROPERTIES_CONFIG.catDatabaseUserName(),
                    PropertiesConfig.PROPERTIES_CONFIG.catDatabasePassword()
            );


        } catch (Exception e) {
            log.info("Exception occurred during database connection");
        }

        return connection;
    }

    public synchronized Connection getDataBaseConnection() {

        if (connection == null) {
            dataBaseConnection();
        }

        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                log.info("Database connection closed successfully.");
            } catch (SQLException e) {
                log.error("Error closing database connection: {}", e.getMessage());
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            closeConnection(); // Close connection in finalize to clean up resources
        } finally {
            super.finalize(); // Call the superclass's finalize method
        }
    }


}
