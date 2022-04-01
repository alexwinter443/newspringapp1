package com.gcu.util;

/**
 * Custom API Exception
 */
public class APIException extends RuntimeException {
    /**
     * Deafult Constructor
     */
    public APIException() {
        super();
    }

    /**
     * Non-default constructor
     * @param e Wrapped exception
     * @param message Custom exception message
     */
    public APIException(Throwable e, String message) {
        super(message, e);
    }
}
