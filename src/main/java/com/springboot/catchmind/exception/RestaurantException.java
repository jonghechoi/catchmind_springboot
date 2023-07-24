package com.springboot.catchmind.exception;

import java.text.ParseException;

public class RestaurantException extends ParseException {
    private final RestaurantErrorCode restaurantErrorCode;

    public RestaurantException(String message, RestaurantErrorCode restaurantErrorCode) {
        super(message);
        this.restaurantErrorCode = restaurantErrorCode;
    }

    public RestaurantException(RestaurantErrorCode restaurantErrorCode) {
        super(restaurantErrorCode.getMessage());
        this.restaurantErrorCode = restaurantErrorCode;
    }

    public RestaurantErrorCode getErrorCode() {
        return restaurantErrorCode;
    }
}
