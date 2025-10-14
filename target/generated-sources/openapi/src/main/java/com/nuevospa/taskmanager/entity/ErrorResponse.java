package com.nuevospa.taskmanager.entity;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * ErrorResponse
 */
@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-13T22:13:05.474109-03:00[America/Santiago]", comments = "Generator version: 7.16.0")
public class ErrorResponse {

  private @Nullable String mensaje;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime timestamp;

  private @Nullable String detalles;

  private @Nullable Integer codigo;

  public ErrorResponse mensaje(@Nullable String mensaje) {
    this.mensaje = mensaje;
    return this;
  }

  /**
   * Mensaje de error descriptivo
   * @return mensaje
   */
  
  @Schema(name = "mensaje", example = "Error en la solicitud", description = "Mensaje de error descriptivo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("mensaje")
  public @Nullable String getMensaje() {
    return mensaje;
  }

  public void setMensaje(@Nullable String mensaje) {
    this.mensaje = mensaje;
  }

  public ErrorResponse timestamp(@Nullable OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Fecha y hora del error
   * @return timestamp
   */
  @Valid 
  @Schema(name = "timestamp", example = "2025-10-13T10:30Z", description = "Fecha y hora del error", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timestamp")
  public @Nullable OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(@Nullable OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public ErrorResponse detalles(@Nullable String detalles) {
    this.detalles = detalles;
    return this;
  }

  /**
   * Detalles adicionales del error
   * @return detalles
   */
  
  @Schema(name = "detalles", example = "El campo 'titulo' es obligatorio", description = "Detalles adicionales del error", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("detalles")
  public @Nullable String getDetalles() {
    return detalles;
  }

  public void setDetalles(@Nullable String detalles) {
    this.detalles = detalles;
  }

  public ErrorResponse codigo(@Nullable Integer codigo) {
    this.codigo = codigo;
    return this;
  }

  /**
   * Código HTTP del error
   * @return codigo
   */
  
  @Schema(name = "codigo", example = "400", description = "Código HTTP del error", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("codigo")
  public @Nullable Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(@Nullable Integer codigo) {
    this.codigo = codigo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.mensaje, errorResponse.mensaje) &&
        Objects.equals(this.timestamp, errorResponse.timestamp) &&
        Objects.equals(this.detalles, errorResponse.detalles) &&
        Objects.equals(this.codigo, errorResponse.codigo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mensaje, timestamp, detalles, codigo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    sb.append("    mensaje: ").append(toIndentedString(mensaje)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    detalles: ").append(toIndentedString(detalles)).append("\n");
    sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
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

