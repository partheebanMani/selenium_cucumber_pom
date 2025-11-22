package com.partheeban.client;

import org.apache.logging.log4j.Logger;

import java.io.OutputStream;
import java.io.PrintStream;

public class Log4jPrintStream extends PrintStream {

    private final Logger logger;

    public Log4jPrintStream(Logger logger) {
        super(new OutputStream() {
            @Override
            public void write(int b) {
                // No implementation required
            }
        });
        this.logger = logger;
    }

    @Override
    public void println(String x) {
        if (x != null && !x.trim().isEmpty()) {
            logger.info(x); // Send each Rest Assured log line into Log4j
        }
    }

    @Override
    public void print(String s) {
        if (s != null && !s.trim().isEmpty()) {
            logger.info(s);
        }
    }
}