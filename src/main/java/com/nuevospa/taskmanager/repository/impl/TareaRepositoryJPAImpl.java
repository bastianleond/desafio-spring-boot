package com.nuevospa.taskmanager.repository.impl;

import com.nuevospa.taskmanager.entity.Tarea;
import com.nuevospa.taskmanager.repository.TareaRepository;
import com.nuevospa.taskmanager.repository.impl.jpa.TareaJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TareaRepositoryJPAImpl implements TareaRepository {

    private final TareaJPARepository tareaJPARepository;

    @Override
    public Tarea guardar(Tarea tarea) {
        return tareaJPARepository.save(tarea);
    }

    @Override
    public List<Tarea> buscarPorUsuarioId(Long usuarioId) {
        return tareaJPARepository.findByUsuarioId(usuarioId);
    }

    @Override
    public Optional<Tarea> buscarPorIdYPorUsuarioId(Long tareaId, Long usuarioId) {
        return tareaJPARepository.findByIdAndUsuarioId(tareaId, usuarioId);
    }

    @Override
    public Optional<Tarea> buscarPorId(Long id) {
        return tareaJPARepository.findById(id);
    }

    @Override
    public void eliminar(Tarea tarea) {
        tareaJPARepository.delete(tarea);
    }

}
