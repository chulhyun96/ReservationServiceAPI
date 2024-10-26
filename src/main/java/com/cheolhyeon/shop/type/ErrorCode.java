package com.cheolhyeon.shop.type;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USERNAME_NOT_FOUND("해당 유저는 존재 하지 않습니다."),
    MANAGER_NOT_FOUND("해당 점주는 존재 하지 않습니다."),
    ALREADY_EXIST("해당 아이디는 이미 존재하는 아이디 입니다."),
    NOT_FOUND_MEMBER("해당 유저는 등록되어 있지 않습니다."),
    NOT_MATCH_PASSWORD("비밀번호가 틀렸습니다");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

}
