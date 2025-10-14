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
 * LoginRequest
 */
@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-10-13T22:13:05.474109-03:00[America/Santiago]", comments = "Generator version: 7.16.0")
public class LoginRequest {

  private String email;

  private String password;

  public LoginRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LoginRequest(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public LoginRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Correo de usuario
   * @return email
   */
  @NotNull @Size(min = 3, max = 50) 
  @Schema(name = "email", example = "tucorreo@gmail.com", description = "Correo de usuario", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LoginRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Contraseña del usuario
   * @return password
   */
  @NotNull @Size(min = 6, max = 100) 
  @Schema(name = "password", example = "user123", description = "Contraseña del usuario", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginRequest loginRequest = (LoginRequest) o;
    return Objects.equals(this.email, loginRequest.email) &&
        Objects.equals(this.password, loginRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginRequest {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append("*").append("\n");
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

