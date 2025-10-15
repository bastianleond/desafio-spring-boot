package com.nuevospa.taskmanager.service;

import com.nuevospa.taskmanager.dto.request.TareaRequest;
import com.nuevospa.taskmanager.dto.response.TareaResponse;
import com.nuevospa.taskmanager.entity.EstadoTarea;
import com.nuevospa.taskmanager.entity.Tarea;
import com.nuevospa.taskmanager.entity.Usuario;
import com.nuevospa.taskmanager.exception.business.RecursoNotFoundException;
import com.nuevospa.taskmanager.exception.business.UnauthorizedException;
import com.nuevospa.taskmanager.helper.AuthenticationHelper;
import com.nuevospa.taskmanager.mapper.TareaMapper;
import com.nuevospa.taskmanager.repository.EstadoTareaRepository;
import com.nuevospa.taskmanager.repository.TareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TareaService {

    private final TareaRepository tareaRepository;
    private final TareaMapper tareaMapper;
    private final AuthenticationHelper authenticationHelper;
    private final EstadoTareaRepository estadoTareaRepository;

    @Transactional(readOnly = true)
    public List<TareaResponse> obtenerTareas() {

        Usuario usuario = authenticationHelper.getUsuarioAutenticado();

        List<Tarea> tareas = tareaRepository.buscarPorUsuarioId(usuario.getId());

        return tareas.stream().map(tareaMapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public TareaResponse buscarTareaPorId(Long tareaId) {
        Usuario usuario = authenticationHelper.getUsuarioAutenticado();
        Tarea tarea = tareaRepository.buscarPorIdYPorUsuarioId(tareaId, usuario.getId())
                .orElseThrow(() -> new RecursoNotFoundException("No se encontro la tarea: " + tareaId + " vinculada al usuario: " + usuario.getNombre()));

        return tareaMapper.toResponse(tarea);
    }


    @Transactional
    public TareaResponse crearTarea(TareaRequest request) {
        Usuario usuario = authenticationHelper.getUsuarioAutenticado();
        EstadoTarea estado = estadoTareaRepository.buscarPorId(request.estadoId())
                .orElseThrow(() -> new RecursoNotFoundException("Estado no encontrado con ID: " + request.estadoId()));

        Tarea tarea = tareaMapper.toEntity(request, estado, usuario);
        Tarea tareaGuardada = tareaRepository.guardar(tarea);

        return tareaMapper.toResponse(tareaGuardada);
    }


    @Transactional
    public TareaResponse ActualizarTarea(TareaRequest request, Long tareaId) {
        Usuario usuarioAutenticado = authenticationHelper.getUsuarioAutenticado();

        Tarea tareaExistente = tareaRepository.buscarPorIdYPorUsuarioId(tareaId, usuarioAutenticado.getId())
                .orElseThrow(() -> new RecursoNotFoundException("La tarea no se encuentra o no esta asociada al usuario"));

        if (!tareaExistente.getUsuario().getId().equals(usuarioAutenticado.getId())) {
            throw new UnauthorizedException("No tienes permiso para actualizar esta tarea");
        }

        EstadoTarea nuevoEstado = estadoTareaRepository.buscarPorId(request.estadoId())
                .orElseThrow(() -> new RecursoNotFoundException("Estado no encontrado con ID: " + request.estadoId()));

        tareaExistente.setTitulo(request.titulo());
        tareaExistente.setDescripcion(request.descripcion());
        tareaExistente.setEstado(nuevoEstado);
        tareaExistente.setFechaVencimiento(request.fechaVencimiento());
        tareaExistente.setFechaActualizacion(LocalDateTime.now());

        Tarea tareaActualizada = tareaRepository.guardar(tareaExistente);
        return tareaMapper.toResponse(tareaActualizada);
    }



}
