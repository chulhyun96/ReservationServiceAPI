package com.cheolhyeon.shop.exception;

import com.cheolhyeon.shop.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class AuthException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;

    public AuthException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
