package com.nuevospa.taskmanager.mapper;

import com.nuevospa.taskmanager.dto.request.TareaRequest;
import com.nuevospa.taskmanager.dto.response.TareaResponse;
import com.nuevospa.taskmanager.entity.EstadoTarea;
import com.nuevospa.taskmanager.entity.Tarea;
import com.nuevospa.taskmanager.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TareaMapper {

    private final EstadoTareaMapper estadoTareaMapper;

    public TareaResponse toResponse(Tarea tarea) {
        if (tarea == null) {
            return null;
        }
        return TareaResponse.builder()
                .id(tarea.getId())
                .titulo(tarea.getTitulo())
                .descripcion(tarea.getDescripcion())
                .usuarioId(tarea.getUsuario().getId())
                .fechaCreacion(tarea.getFechaCreacion())
                .fechaVencimiento(tarea.getFechaVencimiento())
                .fechaActualizacion(tarea.getFechaActualizacion())
                .estado(estadoTareaMapper.toResponse(tarea.getEstado()))
                .build();
    }

    public Tarea toEntity(TareaRequest request, EstadoTarea estado, Usuario usuario) {
        return Tarea.builder()
                .titulo(request.titulo())
                .descripcion(request.descripcion())
                .fechaCreacion(LocalDateTime.now())
                .fechaActualizacion(LocalDateTime.now())
                .fechaVencimiento(request.fechaVencimiento())
                .estado(estado)
                .usuario(usuario)
                .build();
    }
}
