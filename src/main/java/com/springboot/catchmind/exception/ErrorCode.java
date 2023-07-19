package com.springboot.catchmind.exception;

public interface ErrorCode {
    int getStatus();
    String getCode();
    String getMessage();
}
