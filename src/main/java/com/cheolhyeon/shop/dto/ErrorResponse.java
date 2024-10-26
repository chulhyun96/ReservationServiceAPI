package com.cheolhyeon.shop.dto;

import com.cheolhyeon.shop.type.ErrorCode;
import com.cheolhyeon.shop.type.SignUpStatus;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private final ErrorCode errorCode;
    private final String message;
    private final SignUpStatus status;

    public ErrorResponse(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
        this.status = SignUpStatus.FAIL;
    }
}
