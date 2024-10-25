package com.cheolhyeon.shop.service;

import com.cheolhyeon.shop.domain.Member;
import com.cheolhyeon.shop.dto.SignUpAdmin;
import com.cheolhyeon.shop.exception.SignUpException;
import com.cheolhyeon.shop.repository.ManagerRepository;
import com.cheolhyeon.shop.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SingUpService {
    private final ManagerRepository managerRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 매장 점주 회원가입
     * @param request
     * @return Member
     */
    @Transactional
    public Member register(SignUpAdmin.Request request) {
        if (managerRepository.existsByUsername(request.getUsername())) {
            throw new SignUpException(ErrorCode.ALREADY_EXIST);
        }
        request.setUpAdminInfo(passwordEncoder);
        return managerRepository.save(Member.fromRequest(request));
    }
}
