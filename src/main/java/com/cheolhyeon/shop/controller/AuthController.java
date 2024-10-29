package com.cheolhyeon.shop.controller;

import com.cheolhyeon.shop.dto.SignUp;
import com.cheolhyeon.shop.dto.SignIn;
import com.cheolhyeon.shop.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/signup")
    public ResponseEntity<?> singUp(@RequestBody SignUp.Request request) {
        return ResponseEntity.ok().body(
                SignUp.Response.fromEntity(authService.register(request))
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignIn.Request request) {
        return ResponseEntity.ok().body(
                SignIn.Response.fromEntity(authService.signin(request))
        );
    }
}
