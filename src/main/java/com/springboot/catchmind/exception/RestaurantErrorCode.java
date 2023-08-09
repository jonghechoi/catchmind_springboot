package com.springboot.catchmind.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public enum RestaurantErrorCode implements ErrorCode{
    /* Restaurant error */
    PARSING_FAILED(501, "R001", "Parsing failed");

    private final int status;
    private final String code;
    private final String message;
}
