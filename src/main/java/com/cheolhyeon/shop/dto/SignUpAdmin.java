package com.cheolhyeon.shop.dto;

import com.cheolhyeon.shop.domain.Member;
import com.cheolhyeon.shop.type.SignUpStatus;
import com.cheolhyeon.shop.type.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;


public class SignUpAdmin {
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Request {
        private String username;
        private String password;
        private String email;
        private String phone;
        private UserRole userRole;

        public void setUpAdminInfo(PasswordEncoder passwordEncoder) {
            this.password = passwordEncoder.encode(this.password);
            this.userRole = UserRole.ADMIN;
        }
    }
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Response {
        private String name;
        private String email;
        private SignUpStatus status;
    }

    public static SignUpAdmin.Response toResponse(Member saveMember) {
        return SignUpAdmin.Response.builder()
                .name(saveMember.getUsername())
                .email(saveMember.getEmail())
                .status(SignUpStatus.SUCCESS)
                .build();
    }
}
