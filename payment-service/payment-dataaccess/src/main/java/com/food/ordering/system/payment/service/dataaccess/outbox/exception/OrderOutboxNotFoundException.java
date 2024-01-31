package com.food.ordering.system.payment.service.dataaccess.outbox.exception;

public class OrderOutboxNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -57860820110735139L;

    public OrderOutboxNotFoundException(String message) {
        super(message);
    }
}
