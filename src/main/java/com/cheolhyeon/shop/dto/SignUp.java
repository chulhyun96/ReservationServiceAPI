package com.cheolhyeon.shop.dto;

import com.cheolhyeon.shop.domain.Member;
import com.cheolhyeon.shop.type.SignUpStatus;
import com.cheolhyeon.shop.type.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.file.attribute.UserPrincipal;


public class SignUp {
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Request {
        private String username;
        private String password;
        private String email;
        private String phone;

        @Enumerated(EnumType.STRING)
        private UserRole userRole;

        public void setUpAdminInfo(PasswordEncoder passwordEncoder, UserRole role) {
            this.password = passwordEncoder.encode(password);
            this.userRole = role;
        }
        public String getUserRoleAsString() {
            return userRole.name().toLowerCase();
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

    public static SignUp.Response toResponse(Member saveMember) {
        return SignUp.Response.builder()
                .name(saveMember.getUsername())
                .email(saveMember.getEmail())
                .status(SignUpStatus.SUCCESS)
                .build();
    }
}
