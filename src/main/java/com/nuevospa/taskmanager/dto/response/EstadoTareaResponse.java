package com.nuevospa.taskmanager.dto.response;

import lombok.Builder;

@Builder
public record EstadoTareaResponse(
        Long id,
        String nombre,
        String descripcion
) {
}
