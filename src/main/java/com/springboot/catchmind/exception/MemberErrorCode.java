package com.springboot.catchmind.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {
    /* Member Error */
    NOT_MATCHED_ID(403, "C001","ID가 일치하지 않습니다"),
    NOT_MATCHED_PASSWORD(400, "C002","비밀번호가 일치하지 않습니다"),
    EMAIL_DUPLICATED(409, "C003","이메일이 중복되었습니다");

    private int status;
    private final String code;
    private final String message;

    MemberErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}