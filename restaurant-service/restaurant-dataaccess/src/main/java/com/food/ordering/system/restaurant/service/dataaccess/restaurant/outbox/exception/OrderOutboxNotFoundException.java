package com.food.ordering.system.restaurant.service.dataaccess.restaurant.outbox.exception;

public class OrderOutboxNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2957259287387498858L;

    public OrderOutboxNotFoundException(String message) {
        super(message);
    }
}
