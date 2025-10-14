package com.nuevospa.taskmanager.dto.response;

import com.nuevospa.taskmanager.enums.ApiErrorCode;
import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.Map;

@Builder
public record ErrorResponse(
        String mensaje,
        OffsetDateTime timestamp,
        String url,
        Integer codigoHttp,
        ApiErrorCode codigoApi,
        Map<String, String> validaciones
) {
}
