package com.cheolhyeon.shop.service;

import com.cheolhyeon.shop.domain.Member;
import com.cheolhyeon.shop.dto.SignIn;
import com.cheolhyeon.shop.dto.SignUp;
import com.cheolhyeon.shop.exception.AuthException;
import com.cheolhyeon.shop.repository.ManagerRepository;
import com.cheolhyeon.shop.type.ErrorCode;
import com.cheolhyeon.shop.type.UserRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
    private final ManagerRepository managerRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Member(점주, 고객) 회원가입
     * @return Member
     */
    @Transactional
    public Member register(SignUp.Request request) {
        if (managerRepository.existsByUsername(request.getUsername())) {
            throw new AuthException(ErrorCode.ALREADY_EXIST);
        }
        UserRole role = UserRole.getUserRole(request.getUserRoleAsString());
        request.setUpAdminInfo(passwordEncoder,role);
        return managerRepository.save(Member.fromRequest(request));
    }

    /**
     * Member(점주, 고객) 로그인
     * @return Member
     */
    public Member signin(SignIn.Request request) {
        Member member = managerRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AuthException(ErrorCode.NOT_FOUND_MEMBER));
        if (!isPasswordMatches(request, member)) {
            throw new AuthException(ErrorCode.NOT_MATCH_PASSWORD);
        }
        return member;
    }

    private boolean isPasswordMatches(SignIn.Request request, Member member) {
        return passwordEncoder.matches(request.getPassword(), member.getPassword());
    }
}
