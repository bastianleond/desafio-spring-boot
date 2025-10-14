package com.nuevospa.taskmanager.mapper;

import com.nuevospa.taskmanager.dto.response.UsuarioResponse;
import com.nuevospa.taskmanager.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioResponse toResponse(Usuario usuario){
        if (usuario == null){
            return null;
        }
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .email(usuario.getEmail())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .build();
    }

}
