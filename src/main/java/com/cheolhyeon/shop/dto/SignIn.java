package com.cheolhyeon.shop.dto;

import com.cheolhyeon.shop.domain.Member;
import com.cheolhyeon.shop.type.AuthStatus;
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
    }
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Response {
        private String username;
        private AuthStatus authStatus;

        public static Response fromEntity(Member member) {
            return Response.builder()
                    .username(member.getUsername())
                    .authStatus(AuthStatus.SUCCESS)
                    .build();
        }
    }
}
