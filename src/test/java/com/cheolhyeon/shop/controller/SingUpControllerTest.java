package com.cheolhyeon.shop.controller;

import com.cheolhyeon.shop.domain.Member;
import com.cheolhyeon.shop.dto.SignUpAdmin;
import com.cheolhyeon.shop.service.SingUpService;
import com.cheolhyeon.shop.type.UserRole;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class SingUpControllerTest {
    @Autowired
    WebApplicationContext context;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    @DisplayName("회원가입 성공")
    void signin_success() throws Exception {
        //given
        final String url = "/signin";
        SignUpAdmin.Request managerA = SignUpAdmin.Request.builder()
                .username("managerA")
                .password("1234")
                .phone("010342342345")
                .email("test@naver.com")
                .userRole(UserRole.ADMIN)
                .build();

        String requestBody = mapper.writeValueAsString(managerA);
        //when
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));
        //then
        result.andExpect(status().isOk());
    }
}