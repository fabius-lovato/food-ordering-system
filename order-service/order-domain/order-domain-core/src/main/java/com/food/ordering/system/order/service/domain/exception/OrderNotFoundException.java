package com.food.ordering.system.order.service.domain.exception;

import com.food.ordering.system.domain.exception.DomainException;

public class OrderNotFoundException extends DomainException {

    /**
     * 
     */
    private static final long serialVersionUID = -2916474115783615694L;

    public OrderNotFoundException(String message) {
        super(message);

    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}