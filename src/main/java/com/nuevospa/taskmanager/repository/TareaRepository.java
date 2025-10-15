package com.nuevospa.taskmanager.repository;

import com.nuevospa.taskmanager.entity.Tarea;

import java.util.List;
import java.util.Optional;

public interface TareaRepository {

    Tarea guardar(Tarea tarea);

    List<Tarea> buscarPorUsuarioId(Long usuarioId);

    Optional<Tarea> buscarPorIdYPorUsuarioId(Long tareaId, Long usuarioId);

    Optional<Tarea> buscarPorId(Long id);

    void eliminar(Tarea tarea);
}
