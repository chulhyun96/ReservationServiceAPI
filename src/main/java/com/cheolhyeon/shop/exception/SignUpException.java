package com.cheolhyeon.shop.exception;

import com.cheolhyeon.shop.type.ErrorCode;

public class SignUpException extends RuntimeException {
    public SignUpException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
