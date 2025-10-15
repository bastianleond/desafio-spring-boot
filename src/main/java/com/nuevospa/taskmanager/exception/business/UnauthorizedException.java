package com.nuevospa.taskmanager.exception.business;

import com.nuevospa.taskmanager.enums.ApiErrorCode;
import com.nuevospa.taskmanager.exception.BaseApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class UnauthorizedException extends BaseApiException {

    public UnauthorizedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, ApiErrorCode.NO_AUTORIZADO);
    }
}
