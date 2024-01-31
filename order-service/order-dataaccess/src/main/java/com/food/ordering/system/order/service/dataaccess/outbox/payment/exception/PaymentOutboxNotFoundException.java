package com.food.ordering.system.order.service.dataaccess.outbox.payment.exception;

public class PaymentOutboxNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -9129400021910663770L;

    public PaymentOutboxNotFoundException(String message) {
        super(message);
    }
}
