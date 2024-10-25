package com.cheolhyeon.shop.controller;

import com.cheolhyeon.shop.dto.SignUpAdmin;
import com.cheolhyeon.shop.service.SingUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SingUpController {
    private final SingUpService singUpService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignUpAdmin.Request request) {
        return ResponseEntity.ok().body(
                SignUpAdmin.toResponse(singUpService.register(request))
        );
    }
}
