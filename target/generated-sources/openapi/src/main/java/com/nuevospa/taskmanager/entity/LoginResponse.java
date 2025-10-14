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
 * LoginResponse
 */
@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-13T22:13:05.474109-03:00[America/Santiago]", comments = "Generator version: 7.16.0")
public class LoginResponse {

  private String token;

  private String tipo;

  public LoginResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LoginResponse(String token, String tipo) {
    this.token = token;
    this.tipo = tipo;
  }

  public LoginResponse token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Token JWT para autenticación
   * @return token
   */
  @NotNull 
  @Schema(name = "token", example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY5...", description = "Token JWT para autenticación", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public LoginResponse tipo(String tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Tipo de token
   * @return tipo
   */
  @NotNull 
  @Schema(name = "tipo", example = "Bearer", description = "Tipo de token", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tipo")
  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginResponse loginResponse = (LoginResponse) o;
    return Objects.equals(this.token, loginResponse.token) &&
        Objects.equals(this.tipo, loginResponse.tipo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, tipo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginResponse {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
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

