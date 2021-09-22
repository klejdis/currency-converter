package com.kj.currencyconverter.services.exceptions;

public class RateProviderNotSupportedException extends Exception{
    public RateProviderNotSupportedException() {
    }

    public RateProviderNotSupportedException(String message) {
        super(message);
    }

    public RateProviderNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RateProviderNotSupportedException(Throwable cause) {
        super(cause);
    }

    public RateProviderNotSupportedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
