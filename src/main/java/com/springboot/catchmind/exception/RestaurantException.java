package com.springboot.catchmind.exception;

import java.io.Serializable;
import java.text.ParseException;

public class RestaurantException extends ParseException implements Serializable {
    //private final RestaurantErrorCode restaurantErrorCode;
    private String message;
    private int errorOffset;

    public RestaurantException(String message, int errorOffset) {
        super(message, errorOffset);
        this.message = message;
        this.errorOffset = errorOffset;
        System.out.println("message : " + message + " errorOffSet : " + errorOffset);
        //this.restaurantErrorCode = restaurantErrorCode;
    }

    public int getErrorOffset(){
        return errorOffset;
    }
//    public RestaurantException(RestaurantErrorCode restaurantErrorCode) {
//        super(restaurantErrorCode.getMessage());
//        this.restaurantErrorCode = restaurantErrorCode;
//    }

//    public RestaurantErrorCode getErrorCode() {
//        return restaurantErrorCode;
//    }
}
