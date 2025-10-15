package com.nuevospa.taskmanager.repository.impl.jpa;

import com.nuevospa.taskmanager.entity.EstadoTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface EstadoTareaJPARepository extends JpaRepository<EstadoTarea, Long> {


}
