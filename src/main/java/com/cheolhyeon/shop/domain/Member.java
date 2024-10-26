package com.cheolhyeon.shop.domain;

import com.cheolhyeon.shop.dto.SignUp;
import com.cheolhyeon.shop.type.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String username;
    private String password;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public static Member fromRequest(SignUp.Request request) {
        return Member.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPassword())
                .role(request.getUserRole())
                .build();
    }
}
