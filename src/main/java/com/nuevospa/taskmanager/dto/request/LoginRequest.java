package com.nuevospa.taskmanager.dto.request;

import jakarta.validation.constraints.*;

public record LoginRequest(
        @NotNull(message = "El email es obligatorio")
        @NotBlank(message = "El email no puede venir vacio")
        @Email(message = "El email no es válido")
        @Size(min = 3, max = 100, message = "El email debe tener entre 3 y 100 caracteres")
        String email,
        @NotNull(message = "La contraseña es obligatorio")
        @NotBlank(message = "La contraseña no puede ser vacia")
        @Size(min = 6, max = 100, message = "La contraseña debe tener entre 6 y 100 caracteres")
        String password
) {
}
