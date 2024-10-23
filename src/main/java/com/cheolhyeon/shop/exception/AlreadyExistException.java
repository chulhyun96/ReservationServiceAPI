package com.cheolhyeon.shop.exception;

import com.cheolhyeon.shop.type.ErrorCode;

public class AlreadyExistException extends RuntimeException {

    public AlreadyExistException(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }
}
