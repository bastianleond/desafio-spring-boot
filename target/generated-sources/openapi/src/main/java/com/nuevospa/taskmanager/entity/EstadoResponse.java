package com.nuevospa.taskmanager.entity;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * EstadoResponse
 */
@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-13T22:13:05.474109-03:00[America/Santiago]", comments = "Generator version: 7.16.0")
public class EstadoResponse {

  private @Nullable Long id;

  private @Nullable String nombre;

  private @Nullable String descripcion;

  public EstadoResponse id(@Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * ID del estado
   * @return id
   */
  
  @Schema(name = "id", example = "1", description = "ID del estado", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Long getId() {
    return id;
  }

  public void setId(@Nullable Long id) {
    this.id = id;
  }

  public EstadoResponse nombre(@Nullable String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Nombre del estado
   * @return nombre
   */
  
  @Schema(name = "nombre", example = "Pendiente", description = "Nombre del estado", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nombre")
  public @Nullable String getNombre() {
    return nombre;
  }

  public void setNombre(@Nullable String nombre) {
    this.nombre = nombre;
  }

  public EstadoResponse descripcion(@Nullable String descripcion) {
    this.descripcion = descripcion;
    return this;
  }

  /**
   * Descripción del estado
   * @return descripcion
   */
  
  @Schema(name = "descripcion", example = "Tarea creada pero no iniciada", description = "Descripción del estado", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("descripcion")
  public @Nullable String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(@Nullable String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EstadoResponse estadoResponse = (EstadoResponse) o;
    return Objects.equals(this.id, estadoResponse.id) &&
        Objects.equals(this.nombre, estadoResponse.nombre) &&
        Objects.equals(this.descripcion, estadoResponse.descripcion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, descripcion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EstadoResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
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

