package com.nuevospa.taskmanager.entity;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nuevospa.taskmanager.entity.EstadoResponse;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TareaResponse
 */
@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-13T22:13:05.474109-03:00[America/Santiago]", comments = "Generator version: 7.16.0")
public class TareaResponse {

  private @Nullable Long id;

  private @Nullable String titulo;

  private @Nullable String descripcion;

  private @Nullable EstadoResponse estado;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime fechaCreacion;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate fechaVencimiento;

  private @Nullable Long usuarioId;

  public TareaResponse id(@Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * ID único de la tarea
   * @return id
   */
  
  @Schema(name = "id", example = "1", description = "ID único de la tarea", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Long getId() {
    return id;
  }

  public void setId(@Nullable Long id) {
    this.id = id;
  }

  public TareaResponse titulo(@Nullable String titulo) {
    this.titulo = titulo;
    return this;
  }

  /**
   * Título de la tarea
   * @return titulo
   */
  
  @Schema(name = "titulo", example = "Implementar API First", description = "Título de la tarea", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("titulo")
  public @Nullable String getTitulo() {
    return titulo;
  }

  public void setTitulo(@Nullable String titulo) {
    this.titulo = titulo;
  }

  public TareaResponse descripcion(@Nullable String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * Descripción de la tarea
   * @return descripcion
   */
  
  @Schema(name = "descripcion", example = "Crear el archivo openapi.yml y configurar el plugin de generación de código", description = "Descripción de la tarea", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("descripcion")
  public @Nullable String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(@Nullable String descripcion) {
    this.descripcion = descripcion;
  }

  public TareaResponse estado(@Nullable EstadoResponse estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Get estado
   * @return estado
   */
  @Valid 
  @Schema(name = "estado", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("estado")
  public @Nullable EstadoResponse getEstado() {
    return estado;
  }

  public void setEstado(@Nullable EstadoResponse estado) {
    this.estado = estado;
  }

  public TareaResponse fechaCreacion(@Nullable OffsetDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
    return this;
  }

  /**
   * Fecha y hora de creación de la tarea
   * @return fechaCreacion
   */
  @Valid 
  @Schema(name = "fechaCreacion", example = "2025-10-13T10:30Z", description = "Fecha y hora de creación de la tarea", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fechaCreacion")
  public @Nullable OffsetDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(@Nullable OffsetDateTime fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public TareaResponse fechaVencimiento(@Nullable LocalDate fechaVencimiento) {
    this.fechaVencimiento = fechaVencimiento;
    return this;
  }

  /**
   * Fecha de vencimiento de la tarea
   * @return fechaVencimiento
   */
  @Valid 
  @Schema(name = "fechaVencimiento", example = "2025-10-20", description = "Fecha de vencimiento de la tarea", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fechaVencimiento")
  public @Nullable LocalDate getFechaVencimiento() {
    return fechaVencimiento;
  }

  public void setFechaVencimiento(@Nullable LocalDate fechaVencimiento) {
    this.fechaVencimiento = fechaVencimiento;
  }

  public TareaResponse usuarioId(@Nullable Long usuarioId) {
    this.usuarioId = usuarioId;
    return this;
  }

  /**
   * ID del usuario propietario de la tarea
   * @return usuarioId
   */
  
  @Schema(name = "usuarioId", example = "1", description = "ID del usuario propietario de la tarea", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("usuarioId")
  public @Nullable Long getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(@Nullable Long usuarioId) {
    this.usuarioId = usuarioId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TareaResponse tareaResponse = (TareaResponse) o;
    return Objects.equals(this.id, tareaResponse.id) &&
        Objects.equals(this.titulo, tareaResponse.titulo) &&
        Objects.equals(this.descripcion, tareaResponse.descripcion) &&
        Objects.equals(this.estado, tareaResponse.estado) &&
        Objects.equals(this.fechaCreacion, tareaResponse.fechaCreacion) &&
        Objects.equals(this.fechaVencimiento, tareaResponse.fechaVencimiento) &&
        Objects.equals(this.usuarioId, tareaResponse.usuarioId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, titulo, descripcion, estado, fechaCreacion, fechaVencimiento, usuarioId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TareaResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    titulo: ").append(toIndentedString(titulo)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("    fechaCreacion: ").append(toIndentedString(fechaCreacion)).append("\n");
    sb.append("    fechaVencimiento: ").append(toIndentedString(fechaVencimiento)).append("\n");
    sb.append("    usuarioId: ").append(toIndentedString(usuarioId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

