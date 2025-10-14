package com.nuevospa.taskmanager.repository.impl.jpa;

import com.nuevospa.taskmanager.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioJPARepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
