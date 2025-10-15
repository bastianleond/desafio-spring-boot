package com.nuevospa.taskmanager.security;

import com.nuevospa.taskmanager.config.PublicRoutes;
import com.nuevospa.taskmanager.entity.Usuario;
import com.nuevospa.taskmanager.repository.UsuarioRepository;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        try {
            String bearerToken = request.getHeader("Authorization");

            if (bearerToken == null || !bearerToken.startsWith("Bearer ")) {
                filterChain.doFilter(request, response);
                return;
            }

            String token = bearerToken.substring(7);

            if (!jwtTokenProvider.validarToken(token)) {
                filterChain.doFilter(request, response);
                return;
            }

            String email = jwtTokenProvider.getEmailFromToken(token);
            if (SecurityContextHolder.getContext().getAuthentication() != null) {
                filterChain.doFilter(request, response);
                return;
            }

            Usuario usuario = usuarioRepository.buscarPorEmail(email)
                    .orElse(null);

            if (usuario == null) {
                filterChain.doFilter(request, response);
                return;
            }

            if (!usuario.getActivo()) {
                filterChain.doFilter(request, response);
                return;
            }

            // FIN VALIDACIONES DE NEGOCIO

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            email,
                            null,
                            Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
                    );

            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authentication);


        } catch (JwtException jwtException) {
            log.error("Error al procesar token JWT: {}", jwtException.getMessage());
        } catch (Exception exception) {
            log.error("Error inesperado en JwtAuthenticationFilter -> Once per filter: ", exception);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return PublicRoutes.esRutaPublica(path);
    }
}
