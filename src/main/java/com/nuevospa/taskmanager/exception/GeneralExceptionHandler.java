package com.nuevospa.taskmanager.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.nuevospa.taskmanager.dto.response.ErrorResponse;
import com.nuevospa.taskmanager.enums.ApiErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDate;
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

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoResourceFound(
            NoResourceFoundException ex,
            HttpServletRequest request) {

        ErrorResponse error = ErrorResponse.builder()
                .mensaje("Ruta no se encuentra")
                .timestamp(OffsetDateTime.now())
                .url(request.getRequestURI())
                .codigoHttp(HttpStatus.NOT_FOUND.value())
                .codigoApi(ApiErrorCode.RECURSO_NO_ENCONTRADO)
                .validaciones(null)
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(BaseApiException.class)
    public ResponseEntity<ErrorResponse> handleBaseApiException(BaseApiException ex, HttpServletRequest request) {
        ErrorResponse error = ErrorResponse.builder()
                .mensaje(ex.getMessage())
                .timestamp(OffsetDateTime.now())
                .url(request.getRequestURI())
                .codigoHttp(ex.getHttpStatusCode().value())
                .codigoApi(ex.getApiErrorCode())
                .validaciones(null)
                .build();

        return ResponseEntity.status(ex.getHttpStatusCode()).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleJsonParseError(
            HttpMessageNotReadableException ex,
            HttpServletRequest request) {

        String mensajeDetallado = "JSON mal formado";
        Map<String, String> validaciones = new HashMap<>();

        Throwable causaRaiz = ex.getMostSpecificCause();

        // FECHAS
        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException ife = (InvalidFormatException) ex.getCause();

            if (ife.getTargetType() != null && ife.getTargetType().equals(LocalDate.class)) {
                String campoConError = ife.getPath().isEmpty() ? "fecha"
                        : ife.getPath().get(0).getFieldName();
                String valorInvalido = ife.getValue().toString();

                mensajeDetallado = "Formato de fecha inválido";
                validaciones.put(campoConError,
                        String.format("Fecha inválida '%s'. Formato esperado: YYYY-MM-DD (ejemplo: 2025-10-20)",
                                valorInvalido));

            } else {
                // OTROS
                String campoConError = ife.getPath().isEmpty() ? "campo"
                        : ife.getPath().get(0).getFieldName();
                validaciones.put(campoConError,
                        String.format("Valor inválido. Tipo esperado: %s",
                                ife.getTargetType().getSimpleName()));
            }
        } else if (causaRaiz.getMessage().contains("JSON")) {
            mensajeDetallado = "Error de sintaxis JSON";
            validaciones.put("json", "Revisa la estructura del JSON enviado");
        }

        ErrorResponse error = ErrorResponse.builder()
                .mensaje(mensajeDetallado)
                .timestamp(OffsetDateTime.now())
                .url(request.getRequestURI())
                .codigoHttp(HttpStatus.BAD_REQUEST.value())
                .codigoApi(ApiErrorCode.PETICION)
                .validaciones(validaciones.isEmpty() ? null : validaciones)
                .build();

        return ResponseEntity.badRequest().body(error);
    }

}
