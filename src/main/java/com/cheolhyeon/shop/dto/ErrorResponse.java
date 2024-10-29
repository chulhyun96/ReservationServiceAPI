package com.cheolhyeon.shop.dto;

import com.cheolhyeon.shop.type.AuthStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private final String message;
    private final AuthStatus status;
    private final int code;
}
