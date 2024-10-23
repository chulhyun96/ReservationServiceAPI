package com.cheolhyeon.shop.type;

public enum ErrorCode {
    USERNAME_NOT_FOUND("해당 유저는 존재 하지 않습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
