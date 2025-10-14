package com.nuevospa.taskmanager.exception;

import com.nuevospa.taskmanager.dto.response.ErrorResponse;
import com.nuevospa.taskmanager.enums.ApiErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();

        ex.getFieldErrors().forEach(fieldError -> errores.put(fieldError.getField(), fieldError.getDefaultMessage()));

        ErrorResponse error = ErrorResponse.builder()
                .mensaje("Solicitud Inválida")
                .timestamp(OffsetDateTime.now())
                .url(request.getRequestURI())
                .codigoHttp(HttpStatus.BAD_REQUEST.value())
                .codigoApi(ApiErrorCode.VALIDACIONES)
                .validaciones(errores)
                .build();

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(BaseApiException.class)
    public ResponseEntity<ErrorResponse> handleBaseApiException(BaseApiException ex, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .mensaje(ex.getMessage())
                .timestamp(OffsetDateTime.now())
                .url(request.getRequestURI())
                .codigoHttp(HttpStatus.BAD_REQUEST.value())
                .codigoApi(ex.getApiErrorCode())
                .validaciones(null)
                .build();

        return ResponseEntity.status(ex.getHttpStatusCode()).body(error);
    }

}
