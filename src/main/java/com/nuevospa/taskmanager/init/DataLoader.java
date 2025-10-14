package com.nuevospa.taskmanager.init;

import com.nuevospa.taskmanager.entity.Usuario;
import com.nuevospa.taskmanager.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        usuariosLoader();


    }

    private void usuariosLoader(){
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
}
