package com.optimissa.BookShelfApi.data.providers.impl.dto.error;

public class NoDtoAnnonationFound extends RuntimeException {

    public NoDtoAnnonationFound() {
    }

    public NoDtoAnnonationFound(String message) {
        super(message);
    }

    public NoDtoAnnonationFound(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDtoAnnonationFound(Throwable cause) {
        super(cause);
    }

    public NoDtoAnnonationFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
