package com.cheolhyeon.shop.exception;

import com.cheolhyeon.shop.dto.ErrorResponse;
import com.cheolhyeon.shop.type.AuthStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AuthException.class)
    public ErrorResponse handleSignUpException(AuthException e) {
        log.error("[ERROR] = {}{}", e.getErrorCode(), e.getMessage());
        return new ErrorResponse(e.getMessage(), AuthStatus.FAIL, HttpStatus.BAD_REQUEST.value());
    }
}
