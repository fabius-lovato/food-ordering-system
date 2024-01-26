package com.food.ordering.system.order.service.dataaccess.restaurant.exception;

public class RestaurantDataAccessException extends RuntimeException {

    private static final long serialVersionUID = -8055180938839456758L;

    public RestaurantDataAccessException(String message) {
        super(message);
    }
}
