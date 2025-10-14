package com.nuevospa.taskmanager.dto.response;

import lombok.Builder;

@Builder
public record LoginResponse(
        String token,
        String tipo,
        UsuarioResponse usuario
){
}
