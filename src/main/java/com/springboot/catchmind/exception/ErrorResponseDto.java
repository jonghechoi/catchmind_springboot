package com.springboot.catchmind.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ErrorResponseDto {
    private int status;

    private String message;

}
