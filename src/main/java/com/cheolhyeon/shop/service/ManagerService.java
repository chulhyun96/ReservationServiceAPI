package com.cheolhyeon.shop.service;

import com.cheolhyeon.shop.domain.User;
import com.cheolhyeon.shop.dto.SignUp;
import com.cheolhyeon.shop.exception.AlreadyExistException;
import com.cheolhyeon.shop.repository.ManagerRepository;
import com.cheolhyeon.shop.type.ErrorCode;
import com.cheolhyeon.shop.type.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ManagerService {
    private final ManagerRepository managerRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원 가입 하기
     * @param request
     * @return SignUp.Response
     */
    public User register(SignUp.Request request) {
        if (managerRepository.existsByUsername(request.getName()) {
            throw new AlreadyExistException(ErrorCode.USERNAME_NOT_FOUND);
        }
        User savedUser = managerRepository.save(User.fromRequest(request));
        savedUser.setUpRoleAndPassword(passwordEncoder, UserRole.ADMIN);
        return savedUser;
    }
}
