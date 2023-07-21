package com.springboot.catchmind.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler{
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponseDto> handleBusinessException(BusinessException e) {
        ErrorCode errorCode = e.getErrorCode();
        log.info(errorCode.getMessage());
        //ErrorResponseDto response = ErrorResponseDto.of(errorCode);
        return new ResponseEntity<>(/*response*/ HttpStatus.valueOf(errorCode.getStatus()));
    }

}