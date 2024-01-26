package com.food.ordering.system.dataaccess.restaurant.exception;

public class RestaurantDataAccessException extends RuntimeException{

    private static final long serialVersionUID = -1927971182413070643L;

    public RestaurantDataAccessException(String message) {
        super(message);
    }
}
