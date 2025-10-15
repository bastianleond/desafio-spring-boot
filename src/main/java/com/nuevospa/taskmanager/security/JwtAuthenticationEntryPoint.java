package com.nuevospa.taskmanager.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nuevospa.taskmanager.dto.response.ErrorResponse;
import com.nuevospa.taskmanager.enums.ApiErrorCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.OffsetDateTime;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

     private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        ErrorResponse errorResponse = ErrorResponse.builder()
        .mensaje("No estas autorizado para realizar esta acción")
        .timestamp(OffsetDateTime.now())
        .url(request.getRequestURI())
        .codigoHttp(HttpServletResponse.SC_FORBIDDEN)
        .codigoApi(ApiErrorCode.NO_AUTORIZADO)
        .validaciones(null)
        .build();

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
        response.getWriter().flush();
    }
}
