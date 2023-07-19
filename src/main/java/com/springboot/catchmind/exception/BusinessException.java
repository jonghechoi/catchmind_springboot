package com.springboot.catchmind.exception;

public class BusinessException extends RuntimeException {

    private final CommonErrorCode commonErrorCode;

    public BusinessException(String message, CommonErrorCode commonErrorCode) {
        super(message);
        this.commonErrorCode = commonErrorCode;
    }

    public BusinessException(CommonErrorCode commonErrorCode) {
        super(commonErrorCode.getMessage());
        this.commonErrorCode = commonErrorCode;
        System.out.println("히히 에러당");
    }

    public CommonErrorCode getErrorCode() {
        return commonErrorCode;
    }

}
