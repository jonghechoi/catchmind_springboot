//package com.springboot.catchmind.exception;
//
//public class BusinessException extends RuntimeException {
//
//    private final CommonErrorCode commonErrorCode;
//
//    public BusinessException(String message, CommonErrorCode commonErrorCode) {
//        super(message);
//        this.commonErrorCode = commonErrorCode;
//    }
//
//    public BusinessException(CommonErrorCode commonErrorCode) {
//        super(commonErrorCode.getMessage());
//        this.commonErrorCode = commonErrorCode;
//    }
//
//    public CommonErrorCode getErrorCode() {
//        return commonErrorCode;
//    }
//}

package com.springboot.catchmind.exception;

public class BusinessException extends RuntimeException {
    private final ErrorCode objectErrorCode;

    public BusinessException(String message, ErrorCode objectErrorCode) {
        super(message);
        this.objectErrorCode = objectErrorCode;
    }

    public BusinessException(ErrorCode objectErrorCode) {
        super(objectErrorCode.getMessage());
        this.objectErrorCode = objectErrorCode;
    }

    public ErrorCode getErrorCode() {
        return objectErrorCode;
    }
}

