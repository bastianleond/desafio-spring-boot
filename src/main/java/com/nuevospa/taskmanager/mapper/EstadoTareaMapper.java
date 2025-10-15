package com.nuevospa.taskmanager.mapper;

import com.nuevospa.taskmanager.dto.response.EstadoTareaResponse;
import com.nuevospa.taskmanager.entity.EstadoTarea;
import org.springframework.stereotype.Component;

@Component
public class EstadoTareaMapper {

    public EstadoTareaResponse toResponse(EstadoTarea estadoTarea) {
        return EstadoTareaResponse.builder()
                .id(estadoTarea.getId())
                .nombre(estadoTarea.getNombre())
                .descripcion(estadoTarea.getDescripcion())
                .build();
    }

}
