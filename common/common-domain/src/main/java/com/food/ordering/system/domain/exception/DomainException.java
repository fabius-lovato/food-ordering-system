package com.food.ordering.system.domain.exception;

public class DomainException extends RuntimeException {

    private static final long serialVersionUID = 7791599155458944907L;

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
