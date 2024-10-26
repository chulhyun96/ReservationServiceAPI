package com.cheolhyeon.shop.exception;

import com.cheolhyeon.shop.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public ErrorResponse handleSignUpException(AuthException e) {
        log.error("[ERROR] = {}{}", e.getErrorCode(), e.getMessage());
        return new ErrorResponse(e.getErrorCode(), e.getMessage());
    }
}
