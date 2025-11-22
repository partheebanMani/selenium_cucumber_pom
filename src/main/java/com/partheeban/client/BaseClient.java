package com.partheeban.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintStream;

@Slf4j
public abstract class BaseClient {

    protected final RequestSpecification requestSpecification;

    protected BaseClient() {

        Logger logger = LogManager.getLogger(this.getClass());
        PrintStream logStream = new Log4jPrintStream(logger);

        RestAssuredConfig restAssuredConfig = RestAssuredConfig.config()
                .logConfig(LogConfig.logConfig()
                        .defaultStream(logStream)   // Send logs to Log4j
                        .enablePrettyPrinting(true));

        requestSpecification = new RequestSpecBuilder()
                .addFilter(new RequestLoggingFilter(LogDetail.URI, logStream))
                .addFilter(new RequestLoggingFilter(LogDetail.HEADERS, logStream))
                .addFilter(new RequestLoggingFilter(LogDetail.BODY, logStream))
                .addFilter(new ResponseLoggingFilter(LogDetail.STATUS, logStream))
                .addFilter(new ResponseLoggingFilter(LogDetail.HEADERS, logStream))
                .addFilter(new ResponseLoggingFilter(LogDetail.BODY, logStream))
                .setConfig(restAssuredConfig)
                .build();
    }
}
