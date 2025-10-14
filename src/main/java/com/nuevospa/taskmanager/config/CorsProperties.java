package com.nuevospa.taskmanager.config;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@Component
@ConfigurationProperties(prefix = "cors")
public class CorsProperties {

    @NotEmpty(message = "La propiedad 'cors.allowed-origins' no puede estar vacía.")
    private String[] allowedOrigins;
}
