package com.cheolhyeon.shop.dto;

import com.cheolhyeon.shop.type.AuthStatus;
import com.cheolhyeon.shop.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private final ErrorCode errorCode;
    private final String message;
    private final AuthStatus status = AuthStatus.FAIL;
}
