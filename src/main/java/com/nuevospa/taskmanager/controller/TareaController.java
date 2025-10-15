package com.nuevospa.taskmanager.controller;

import com.nuevospa.taskmanager.dto.request.TareaRequest;
import com.nuevospa.taskmanager.dto.response.TareaResponse;
import com.nuevospa.taskmanager.service.TareaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
@RequiredArgsConstructor
public class TareaController {

    private final TareaService tareaService;

    @GetMapping("")
    public ResponseEntity<List<TareaResponse>> obtenerTodasLasTareas() {
        return ResponseEntity.ok().body(tareaService.obtenerTareas());
    }


    @GetMapping("/{id}")
    public ResponseEntity<TareaResponse> buscarPorId(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok().body(tareaService.buscarTareaPorId(id));
    }

    @PostMapping("")
    public ResponseEntity<TareaResponse> crearTarea(
            @Valid @RequestBody TareaRequest request
    ) {
        return ResponseEntity.ok().body(tareaService.crearTarea(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TareaResponse> actualizarTarea(
            @PathVariable Long id,
            @Valid @RequestBody TareaRequest request
    ) {
        return ResponseEntity.ok().body(tareaService.actualizarTarea(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(
            @PathVariable Long id
    ) {
        tareaService.eliminarTarea(id);
        return ResponseEntity.noContent().build();
    }


}
