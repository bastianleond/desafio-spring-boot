package com.nuevospa.taskmanager.entity;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
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
 * TareaRequest
 */
@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-13T22:13:05.474109-03:00[America/Santiago]", comments = "Generator version: 7.16.0")
public class TareaRequest {

  private String titulo;

  private String descripcion;

  private Long estadoId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate fechaVencimiento;

  public TareaRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TareaRequest(String titulo, String descripcion, Long estadoId) {
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.estadoId = estadoId;
  }

  public TareaRequest titulo(String titulo) {
    this.titulo = titulo;
    return this;
  }

  /**
   * Título de la tarea
   * @return titulo
   */
  @NotNull @Size(min = 3, max = 100) 
  @Schema(name = "titulo", example = "Implementar API First", description = "Título de la tarea", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("titulo")
  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public TareaRequest descripcion(String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * Descripción detallada de la tarea
   * @return descripcion
   */
  @NotNull @Size(min = 5, max = 500) 
  @Schema(name = "descripcion", example = "Crear el archivo openapi.yml y configurar el plugin de generación de código", description = "Descripción detallada de la tarea", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("descripcion")
  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public TareaRequest estadoId(Long estadoId) {
    this.estadoId = estadoId;
    return this;
  }

  /**
   * ID del estado de la tarea (1=Pendiente, 2=En Progreso, 3=Completada)
   * @return estadoId
   */
  @NotNull 
  @Schema(name = "estadoId", example = "1", description = "ID del estado de la tarea (1=Pendiente, 2=En Progreso, 3=Completada)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("estadoId")
  public Long getEstadoId() {
    return estadoId;
  }

  public void setEstadoId(Long estadoId) {
    this.estadoId = estadoId;
  }

  public TareaRequest fechaVencimiento(@Nullable LocalDate fechaVencimiento) {
    this.fechaVencimiento = fechaVencimiento;
    return this;
  }

  /**
   * Fecha de vencimiento de la tarea (opcional)
   * @return fechaVencimiento
   */
  @Valid 
  @Schema(name = "fechaVencimiento", example = "2025-10-20", description = "Fecha de vencimiento de la tarea (opcional)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fechaVencimiento")
  public @Nullable LocalDate getFechaVencimiento() {
    return fechaVencimiento;
  }

  public void setFechaVencimiento(@Nullable LocalDate fechaVencimiento) {
    this.fechaVencimiento = fechaVencimiento;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TareaRequest tareaRequest = (TareaRequest) o;
    return Objects.equals(this.titulo, tareaRequest.titulo) &&
        Objects.equals(this.descripcion, tareaRequest.descripcion) &&
        Objects.equals(this.estadoId, tareaRequest.estadoId) &&
        Objects.equals(this.fechaVencimiento, tareaRequest.fechaVencimiento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(titulo, descripcion, estadoId, fechaVencimiento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TareaRequest {\n");
    sb.append("    titulo: ").append(toIndentedString(titulo)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
    sb.append("    estadoId: ").append(toIndentedString(estadoId)).append("\n");
    sb.append("    fechaVencimiento: ").append(toIndentedString(fechaVencimiento)).append("\n");
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

