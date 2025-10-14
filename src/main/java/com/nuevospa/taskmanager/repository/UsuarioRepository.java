package com.nuevospa.taskmanager.repository;


import com.nuevospa.taskmanager.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> buscarPorEmail(String email);

    Usuario guardar(Usuario usuario);
}
