package com.food.ordering.system.customer.service.domain.exception;

import com.food.ordering.system.domain.exception.DomainException;

public class CustomerDomainException extends DomainException {

    private static final long serialVersionUID = 6293197788577331784L;

    public CustomerDomainException(String message) {
        super(message);
    }
}
