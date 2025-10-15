package com.nuevospa.taskmanager.config;

public final class PublicRoutes {

    private PublicRoutes() {}

    public static final String[] RUTAS_PUBLICAS = {
            "/auth/**",
            "/h2-console/**",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-ui.html"
    };

    public static boolean esRutaPublica(String path) {
        for (String ruta : RUTAS_PUBLICAS) {
            String regex = ruta.replace("**", ".*");  // Convertir Ant pattern a regex
            if (path.matches(regex)) {
                return true;
            }
        }
        return false;
    }
}
