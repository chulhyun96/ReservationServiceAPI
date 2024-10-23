package com.cheolhyeon.shop.domain;

import com.cheolhyeon.shop.dto.SignUp;
import com.cheolhyeon.shop.type.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private Long id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private UserRole role;

    public static User fromRequest(SignUp.Request request) {
        return User.builder()
                .name(request.getName())
                .password(request.getPassword())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
    }

    public void setUpRoleAndPassword(PasswordEncoder passwordEncoder, UserRole role) {
        this.role = role;
        this.password = passwordEncoder.encode(password);
    }
}
