package com.nuevospa.taskmanager.repository;

import com.nuevospa.taskmanager.entity.EstadoTarea;

import java.util.Optional;

public interface EstadoTareaRepository {

    EstadoTarea guardar(EstadoTarea estadoTarea);
    Optional<EstadoTarea> buscarPorId(Long id);
}
