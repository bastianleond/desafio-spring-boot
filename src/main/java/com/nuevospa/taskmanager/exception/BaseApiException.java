package com.nuevospa.taskmanager.exception;

import com.nuevospa.taskmanager.enums.ApiErrorCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
public class BaseApiException extends RuntimeException {

    private HttpStatusCode httpStatusCode;
    private ApiErrorCode apiErrorCode;

    public BaseApiException(String message, HttpStatusCode httpStatusCode, ApiErrorCode apiErrorCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
        this.apiErrorCode = apiErrorCode;

    }
}
