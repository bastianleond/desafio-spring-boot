package com.nuevospa.taskmanager.exception.business;

import com.nuevospa.taskmanager.enums.ApiErrorCode;
import com.nuevospa.taskmanager.exception.BaseApiException;
import org.springframework.http.HttpStatus;

public class RecursoNotFoundException extends BaseApiException {
    public RecursoNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND, ApiErrorCode.RECURSO_NO_ENCONTRADO);
    }
}
