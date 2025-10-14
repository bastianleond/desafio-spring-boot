package com.nuevospa.taskmanager.exception.business;

import com.nuevospa.taskmanager.enums.ApiErrorCode;
import com.nuevospa.taskmanager.exception.BaseApiException;
import org.springframework.http.HttpStatus;

public class CredentialNotMatchException extends BaseApiException {

    public CredentialNotMatchException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, ApiErrorCode.CREDENCIALES_INVALIDAS);
    }
}
