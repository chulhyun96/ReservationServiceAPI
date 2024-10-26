package com.cheolhyeon.shop.dto;

import com.cheolhyeon.shop.type.LoginStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SignIn {
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Request {
        private String username;
        private String password;
        private LoginStatus loginStatus;

    }
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Response {
        private String username;
        private LoginStatus loginStatus;
    }
}
