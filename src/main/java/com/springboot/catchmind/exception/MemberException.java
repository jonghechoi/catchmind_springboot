package com.springboot.catchmind.exception;

public class MemberException extends RuntimeException {

    private final MemberErrorCode memberErrorCode;

    public MemberException(String message, MemberErrorCode memberErrorCode) {
        super(message);
        this.memberErrorCode = memberErrorCode;
    }

    public MemberException(MemberErrorCode memberErrorCode) {
        super(memberErrorCode.getMessage());
        this.memberErrorCode = memberErrorCode;
    }

    public MemberErrorCode getMemberErrorCode() {
        return memberErrorCode;
    }

}