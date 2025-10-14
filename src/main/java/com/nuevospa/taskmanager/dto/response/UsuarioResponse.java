package com.nuevospa.taskmanager.dto.response;

import lombok.Builder;

@Builder
public record UsuarioResponse (
        Long id,
        String email,
        String nombre,
        String apellido
){
}
