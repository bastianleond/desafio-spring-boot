package com.nuevospa.taskmanager.repository.impl.jpa;

import com.nuevospa.taskmanager.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TareaJPARepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByUsuarioId(Long usuarioId);

    Optional<Tarea> findByIdAndUsuarioId(Long tareaId, Long usuarioId);
}
