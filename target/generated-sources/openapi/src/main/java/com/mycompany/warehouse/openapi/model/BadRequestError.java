package com.mycompany.warehouse.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BadRequestError
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T19:42:14.392951+02:00[Europe/Amsterdam]")@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

public class BadRequestError   {
  @JsonProperty("code")
  private String code;

  @JsonProperty("message")
  private String message;

  public BadRequestError code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  */
  @ApiModelProperty(example = "403 FORBIDDEN", value = "")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public BadRequestError message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */
  @ApiModelProperty(example = "The request the user made is incorrect or corrupt, and the server can't understand it.", value = "")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BadRequestError badRequestError = (BadRequestError) o;
    return Objects.equals(this.code, badRequestError.code) &&
        Objects.equals(this.message, badRequestError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BadRequestError {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

