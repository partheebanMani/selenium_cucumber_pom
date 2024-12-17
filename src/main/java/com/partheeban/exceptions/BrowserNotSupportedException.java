package com.partheeban.exceptions;

public class BrowserNotSupportedException extends RuntimeException {

    public BrowserNotSupportedException(String message) {
        super(message);
    }
}
