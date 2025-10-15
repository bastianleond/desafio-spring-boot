package com.nuevospa.taskmanager.dto.response;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record TareaResponse(
        Long id,
        String titulo,
        String descripcion,
        Long usuarioId,
        LocalDateTime fechaCreacion,
        LocalDate fechaVencimiento,
        LocalDateTime fechaActualizacion,
        EstadoTareaResponse estado
) {
}
