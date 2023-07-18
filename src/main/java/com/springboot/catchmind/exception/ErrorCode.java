package com.springboot.catchmind.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    /* Common */
    INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C002", " Invalid Input Value"),
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),

    /* Member Error */
    NOT_MATCHED_ID(403, "C001","ID가 일치하지 않습니다"),
    NOT_MATCHED_PASSWORD(400, "C002","비밀번호가 일치하지 않습니다"),
    EMAIL_DUPLICATED(409, "C003","이메일이 중복되었습니다");

    private int status;
    private final String code;
    private final String message;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
