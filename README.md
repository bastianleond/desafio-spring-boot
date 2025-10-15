# Task Manager API - NUEVO SPA

API RESTful para gestión de tareas con autenticación JWT, desarrollada con metodología **API First**.

---

## 🚀 Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.5.6** (última versión estable)
- **Spring Security** con autenticación JWT
- **Spring Data JPA** con patrón Repository
- **H2 Database** (base de datos en memoria)
- **OpenAPI 3.0** (Swagger) - Metodología API First
- **Maven** como gestor de dependencias
- **Bean Validation** (Jakarta Validation)
- **Lombok** para reducción de código boilerplate
- **JJWT 0.12.6** para generación y validación de tokens JWT

---

## 📐 Arquitectura y Patrones

### Metodología API First
Este proyecto fue desarrollado utilizando **API First**, donde primero se diseñó el contrato de la API en `openapi.yml` y luego se generó automáticamente el código Java (interfaces y DTOs) mediante el plugin `openapi-generator-maven-plugin`.


### Patrones Implementados
- **Repository Pattern**: Abstracción de la capa de persistencia
- **DTO Pattern**: Separación entre entidades JPA y objetos de transferencia
- **Service Layer**: Lógica de negocio centralizada
- **Exception Handler Global**: Manejo centralizado de errores con `@RestControllerAdvice`
- **JWT Authentication Filter**: Filtro personalizado para validación de tokens

### Estructura del Proyecto
```
com.nuevospa.taskmanager/
├── config/          # Configuraciones (Security, JWT, CORS)
├── controller/      # Controladores REST
├── dto/             # DTOs personalizados (request/response)
├── entity/          # Entidades JPA (Usuario, Tarea, EstadoTarea)
├── enums/           # Enumeraciones (ApiErrorCode)
├── exception/       # Excepciones personalizadas y handlers
├── helper/          # Helpers (AuthenticationHelper)
├── init/            # DataLoader - Carga inicial de datos
├── mapper/          # Mappers entre Entity y DTO
├── repository/      # Interfaces Repository (patrón Repository)
│   └── impl/        # Implementaciones JPA
├── security/        # JWT (TokenProvider, Filters, EntryPoints)
└── service/         # Servicios con lógica de negocio
```

---

## 🔐 Seguridad

### Spring Security + JWT
- **Autenticación stateless** con JSON Web Tokens
- **Filtro JWT** (`JwtAuthenticationFilter`) que intercepta todas las peticiones
- **AuthenticationEntryPoint** personalizado para errores 403
- **BCrypt** para encriptación de contraseñas
- **CORS** configurado para desarrollo

### Validaciones
- Validaciones declarativas con **Bean Validation** (`@NotNull`, `@NotBlank`, `@Size`, `@Email`, `@FutureOrPresent`)
- Validación automática de DTOs en controllers con `@Valid`
- Manejo centralizado de errores de validación en `GeneralExceptionHandler`

---

## 💾 Base de Datos

### Inicialización
- **`schema.sql`**: Define la estructura de tablas (DDL)
- **`DataLoader.java`** (package `init`): Carga datos iniciales (usuarios, estados, tareas) mediante `CommandLineRunner`

### Tablas
- `usuarios`: Almacena usuarios del sistema
- `estados_tarea`: Estados predefinidos (Pendiente, En Progreso, Completada, Cancelada)
- `tareas`: Tareas asociadas a usuarios con estado y fecha de vencimiento

### Acceso a H2 Console
```
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:taskmanagerdb
Username: sa
Password: (vacío)
```

---

## 🛠️ Instalación y Ejecución

### Requisitos Previos
- Java 17 o superior
- Maven 3.6+

### Clonar el Repositorio
```bash
git clone <repository-url>
cd task-manager
```

### Generar Código desde OpenAPI (API First)
El siguiente comando lee `src/main/resources/openapi.yml` y genera las interfaces de API y DTOs en `target/generated-sources/`:
```bash
mvn clean generate-sources
```

**Archivos generados:**
- Interfaces de API en `target/generated-sources/openapi/src/main/java/com/nuevospa/taskmanager/`
- DTOs en `target/generated-sources/openapi/src/main/java/com/nuevospa/taskmanager/entity/`

### Compilar el Proyecto
```bash
mvn clean install
```

### Ejecutar la Aplicación
```bash
mvn spring-boot:run
```

La aplicación estará disponible en: **http://localhost:8080**

---

## 📚 Documentación de la API

### Swagger UI
```
http://localhost:8080/swagger-ui.html
```

### OpenAPI JSON
```
http://localhost:8080/v3/api-docs
```

### Colección Postman
En la raíz del proyecto encontrarás el archivo `task-manager.postman_collection.json` con ejemplos de todos los endpoints.

**Importar en Postman:**
1. Abrir Postman
2. Click en "Import"
3. Seleccionar el archivo JSON
4. Configurar la variable `{{baseUrl}}` = `http://localhost:8080`
5. Configurar la variable `{{authToken}}` = `eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJiYXN0a...` `(Obtener de /auth/login)`

---

## 🔑 Endpoints Principales

### Autenticación
```http
POST /auth/login
Content-Type: application/json

{
  "email": "bastianleond@gmail.com",
  "password": "user123"
}
```

**Response:** Token JWT válido por 24 horas

### Tareas (requieren autenticación)

#### Listar Tareas
```http
GET /tareas
Authorization: Bearer <token>
```

#### Buscar Tarea por ID
```http
GET /tareas/{id}
Authorization: Bearer <token>
```

#### Crear Tarea
```http
POST /tareas
Authorization: Bearer <token>
Content-Type: application/json

{
  "titulo": "Nueva tarea",
  "descripcion": "Descripción de la tarea",
  "estadoId": 1,
  "fechaVencimiento": "2025-12-31"
}
```

#### Actualizar Tarea
```http
PUT /tareas/{id}
Authorization: Bearer <token>
Content-Type: application/json

{
  "titulo": "Tarea actualizada",
  "descripcion": "Nueva descripción",
  "estadoId": 2,
  "fechaVencimiento": "2025-12-31"
}
```

#### Eliminar Tarea
```http
DELETE /tareas/{id}
Authorization: Bearer <token>
```

---

## 👥 Usuarios Precargados

| Email | Password      | Rol |
|-------|---------------|-----|
| `bastianleond@gmail.com` | `user123`     | Usuario |
| `inactivo@gmail.com` | `inactivo123` | Usuario |

- ***nota***: A pesar de poner ROL, existe solo 1 el ROLE_USER, no se hizo ROLE_ADMIN por temas de tiempo. 
---

## ⚙️ Configuración

### application.yml
Principales configuraciones:
```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:h2:mem:taskmanagerdb
  jpa:
    hibernate:
      ddl-auto: none

jwt:
  secret: <tu-clave-secreta>
  expiration: 86400000  # 24 horas

cors:
  allowed-origins: http://localhost # Obligatorio para funcionar.
```

---

## 🧪 Testing

### Flujo Completo de Prueba

1. **Hacer Login**
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"bastianleond@gmail.com","password":"user123"}'
```

2. **Copiar el token** del response

3. **Crear Tarea**
```bash
curl -X POST http://localhost:8080/tareas \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <token>" \
  -d '{
    "titulo": "Mi primera tarea",
    "descripcion": "Descripción",
    "estadoId": 1,
    "fechaVencimiento": "2025-12-31"
  }'
```

4. **Listar Tareas**
```bash
curl -X GET http://localhost:8080/tareas \
  -H "Authorization: Bearer <token>"
```

---

## 📊 Códigos de Error

| Código | Descripción |
|--------|-------------|
| `200` | Operación exitosa |
| `201` | Recurso creado |
| `204` | Recurso eliminado |
| `400` | Validación fallida o JSON mal formado |
| `401` | Credenciales inválidas |
| `403` | Sin autorización (token ausente/inválido o recurso ajeno) |
| `404` | Recurso no encontrado |
| `500` | Error interno del servidor |

### Estructura de Errores
```json
{
  "mensaje": "Descripción del error",
  "timestamp": "2025-10-14T23:30:00Z",
  "url": "/tareas",
  "codigoHttp": 400,
  "codigoApi": "VALIDACIONES",
  "validaciones": {
    "titulo": "El título debe tener entre 3 y 100 caracteres"
  }
}
```

---

## 🔧 Características Técnicas Destacadas

### API First
- Especificación OpenAPI como fuente de verdad
- Generación automática de código con `openapi-generator-maven-plugin`

### Seguridad
- JWT stateless con expiración configurable
- Filtro personalizado de autenticación
- Handlers personalizados para 403
- Encriptación BCrypt de contraseñas

### Validaciones
- Validaciones declarativas en DTOs
- Validación de fechas (`@FutureOrPresent`)
- Validación de formatos (`@Email`, `@Size`)
- Mensajes de error personalizados

### Persistencia
- Patrón Repository con abstracción limpia
- Transacciones con `@Transactional`
- Lazy loading configurado
- Schema SQL + DataLoader para datos iniciales

### Manejo de Errores
- Handler global con `@RestControllerAdvice`
- Manejo de Excepciones de Negocio con `BaseApiException`
- Respuestas de error consistentes
- Captura de excepciones de parseo JSON

---

## 📝 Notas Importantes

- La aplicación usa H2 en memoria, los datos se pierden al reiniciar
- El token JWT expira en 24 horas (configurable en `application.yml`)
- CORS está configurado para desarrollo
- La consola H2 está habilitada solo para desarrollo

---

## 👨‍💻 Autor

**Bastián León**
- Email: bastianleond@gmail.com
- Contacto: +56 9 45149109

---

## 📄 Licencia

Este proyecto fue desarrollado como desafío técnico para NUEVO SPA - Previred.