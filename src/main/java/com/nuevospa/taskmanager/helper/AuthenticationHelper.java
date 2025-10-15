package com.nuevospa.taskmanager.helper;


import com.nuevospa.taskmanager.entity.Usuario;
import com.nuevospa.taskmanager.exception.business.UnauthorizedException;
import com.nuevospa.taskmanager.exception.business.RecursoNotFoundException;
import com.nuevospa.taskmanager.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticationHelper {

    private final UsuarioRepository usuarioRepository;

    public String getEmailUsuarioAutenticado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UnauthorizedException("No estas autorizado para realizar esta acción");
        }
        return (String) authentication.getPrincipal();
    }

    public Usuario getUsuarioAutenticado() {
        String email = getEmailUsuarioAutenticado();

        return usuarioRepository.buscarPorEmail(email)
                .orElseThrow(() -> new RecursoNotFoundException("Usuario no encontrado: " + email));
    }

    public Long getIdUsuarioAutenticado() {
        return getUsuarioAutenticado().getId();
    }

}
