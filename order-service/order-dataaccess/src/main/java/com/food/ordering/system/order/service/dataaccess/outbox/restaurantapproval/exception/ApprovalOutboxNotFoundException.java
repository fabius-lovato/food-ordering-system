package com.food.ordering.system.order.service.dataaccess.outbox.restaurantapproval.exception;

public class ApprovalOutboxNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1452791995705373930L;

    public ApprovalOutboxNotFoundException(String message) {
        super(message);
    }
}
