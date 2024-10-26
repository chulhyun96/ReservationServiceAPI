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
public class SignUpException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;

    public SignUpException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
