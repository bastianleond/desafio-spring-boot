package com.nuevospa.taskmanager.repository.impl;

import com.nuevospa.taskmanager.entity.EstadoTarea;
import com.nuevospa.taskmanager.repository.EstadoTareaRepository;
import com.nuevospa.taskmanager.repository.impl.jpa.EstadoTareaJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class EstadoTareaRepositoryJPAImpl implements EstadoTareaRepository {

    private final EstadoTareaJPARepository estadoTareaJPARepository;

    @Override
    public EstadoTarea guardar(EstadoTarea estadoTarea) {
        return estadoTareaJPARepository.save(estadoTarea);
    }

    @Override
    public Optional<EstadoTarea> buscarPorId(Long id) {
        return estadoTareaJPARepository.findById(id);
    }
}
