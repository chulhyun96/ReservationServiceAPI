package com.cheolhyeon.shop.dto;

import com.cheolhyeon.shop.type.SignUpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class SignUp {
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Request {
        private String name;
        private String password;
        private String email;
        private String phone;
    }
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Response {
        private String name;
        private String email;
        private SignUpStatus status;
    }
}
