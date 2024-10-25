package com.cheolhyeon.shop.type;

public enum ErrorCode {
    USERNAME_NOT_FOUND("해당 유저는 존재 하지 않습니다."),
    ALREADY_EXIST("해당 이름은 이미 존재하는 이름입니다."),
    MANAGER_NOT_FOUND("해당 점주는 존재 하지 않습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
