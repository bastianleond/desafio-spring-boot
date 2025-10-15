package com.nuevospa.taskmanager.repository.impl;

import com.nuevospa.taskmanager.entity.Usuario;
import com.nuevospa.taskmanager.repository.UsuarioRepository;
import com.nuevospa.taskmanager.repository.impl.jpa.UsuarioJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UsuarioRepositoryJPAImpl implements UsuarioRepository {

    private final UsuarioJPARepository usuarioJPARepository;

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioJPARepository.findByEmail(email);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioJPARepository.save(usuario);
    }
}
