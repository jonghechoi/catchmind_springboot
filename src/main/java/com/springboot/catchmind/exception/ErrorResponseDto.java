package com.springboot.catchmind.exception;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class ErrorResponseDto {
    private final int status;
    private final String message;
}
