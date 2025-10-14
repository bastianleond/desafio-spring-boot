
DROP TABLE IF EXISTS tareas;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS estados_tarea;

CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS estados_tarea (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(200),
    orden INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS tareas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion VARCHAR(500),
    estado_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    fecha_vencimiento DATE,
    CONSTRAINT fk_tarea_estado FOREIGN KEY (estado_id) REFERENCES estados_tarea (id),
    CONSTRAINT fk_tarea_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);

CREATE INDEX idx_tarea_usuario ON tareas (usuario_id);
CREATE INDEX idx_tarea_estado ON tareas (estado_id);
CREATE INDEX idx_tarea_fecha_vencimiento ON tareas (fecha_vencimiento);