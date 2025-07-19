package com.partheeban.apps;

import java.sql.Connection;

/**
 * Abstract base class for application modules that require database connectivity.
 */
public abstract class BaseApps {

    /**
     * Establishes and returns a database connection.
     *
     * @return Connection to the database
     */
    public abstract Connection dataBaseConnection();
}
