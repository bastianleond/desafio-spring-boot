package com.nuevospa.taskmanager.init;

import com.nuevospa.taskmanager.entity.EstadoTarea;
import com.nuevospa.taskmanager.entity.Usuario;
import com.nuevospa.taskmanager.repository.EstadoTareaRepository;
import com.nuevospa.taskmanager.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final EstadoTareaRepository estadoTareaRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        usuariosLoader();
        estadoTareasLoader();


    }

    private void usuariosLoader() {
        Usuario usuario = Usuario.builder()
                .email("bastianleond@gmail.com")
                .password(passwordEncoder.encode("user123"))
                .nombre("Bastián")
                .apellido("León")
                .activo(true)
                .fechaCreacion(LocalDateTime.now())
                .tareas(new ArrayList<>())
                .build();

        Usuario usuarioInactivo = Usuario.builder()
                .email("inactivo@gmail.com")
                .password(passwordEncoder.encode("inactivo123"))
                .nombre("Usuario")
                .apellido("Inactivo")
                .activo(false)
                .fechaCreacion(LocalDateTime.now())
                .tareas(new ArrayList<>())
                .build();

        List<Usuario> usuariosAInsertar = List.of(usuario, usuarioInactivo);
        usuariosAInsertar.forEach(usuarioRepository::guardar);
    }

    private void estadoTareasLoader() {

        EstadoTarea pendiente = EstadoTarea.builder()
                .nombre("Pendiente")
                .descripcion("Tarea creada pero no iniciada")
                .orden(1)
                .build();

        EstadoTarea enProgreso = EstadoTarea.builder()
                .nombre("En Progreso")
                .descripcion("Tarea en desarrollo")
                .orden(2)
                .build();

        EstadoTarea completada = EstadoTarea.builder()
                .nombre("Completada")
                .descripcion("Tarea finalizada exitosamente")
                .orden(3)
                .build();

        EstadoTarea cancelada = EstadoTarea.builder()
                .nombre("Cancelada")
                .descripcion("Tarea cancelada o descartada")
                .orden(4)
                .build();

        List<EstadoTarea> estados = List.of(pendiente, enProgreso, completada, cancelada);
        estados.forEach(estadoTareaRepository::guardar);

    }
}
