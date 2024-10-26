package com.cheolhyeon.shop.dto;

import com.cheolhyeon.shop.type.ErrorCode;
import com.cheolhyeon.shop.type.SignUpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private final ErrorCode errorCode;
    private final String message;
    private final SignUpStatus status = SignUpStatus.FAIL;
}
