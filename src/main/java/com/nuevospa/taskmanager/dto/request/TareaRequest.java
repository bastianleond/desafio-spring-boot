package com.nuevospa.taskmanager.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record TareaRequest(

        @NotNull(message = "El titulo es obligatorio")
        @NotBlank(message = "El titulo no puede ser vacío")
        String titulo,

        String descripcion,

        @NotNull(message = "El estado es obligatorio")
        @Positive(message = "El estadoId debe ser positivo")
        Long estadoId,

        @FutureOrPresent(message = "La fecha de vencimiento debe ser hoy o futura")
        LocalDate fechaVencimiento

) {

}
