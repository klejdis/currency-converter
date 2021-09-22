package com.kj.currencyconverter.services.currencyconverter.exceptions;

public class RateNullException extends Exception{
    public RateNullException() {
    }

    public RateNullException(String message) {
        super(message);
    }

    public RateNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public RateNullException(Throwable cause) {
        super(cause);
    }

    public RateNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
