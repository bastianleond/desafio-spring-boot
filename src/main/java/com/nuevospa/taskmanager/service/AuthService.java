package com.nuevospa.taskmanager.service;

import com.nuevospa.taskmanager.dto.request.LoginRequest;
import com.nuevospa.taskmanager.dto.response.LoginResponse;
import com.nuevospa.taskmanager.entity.Usuario;
import com.nuevospa.taskmanager.exception.business.CredentialNotMatchException;
import com.nuevospa.taskmanager.mapper.UsuarioMapper;
import com.nuevospa.taskmanager.repository.UsuarioRepository;
import com.nuevospa.taskmanager.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UsuarioMapper usuarioMapper;

    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest request) {
        Usuario usuario = usuarioRepository.buscarPorEmail(request.email())
                .orElseThrow(() -> new CredentialNotMatchException("Las credenciales no coinciden con nuestros registros"));

        if (!usuario.getActivo()) {
            throw new CredentialNotMatchException("Usuario inactivo. Contacte al administrador.");
        }

        if (!passwordEncoder.matches(request.password(), usuario.getPassword())) {
            throw new CredentialNotMatchException("Las credenciales no coinciden con nuestros registros");
        }

        String token = jwtTokenProvider.generarToken(usuario.getEmail(), usuario.getId());

        return LoginResponse.builder()
                .token(token)
                .tipo("Bearer")
                .usuario(usuarioMapper.toResponse(usuario))
                .build();


    }

}
