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
 * NotFoundError
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T19:42:14.392951+02:00[Europe/Amsterdam]")@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

public class NotFoundError   {
  @JsonProperty("code")
  private String code;

  @JsonProperty("message")
  private String message;

  public NotFoundError code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  */
  @ApiModelProperty(example = "404 NOT_FOUND", value = "")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public NotFoundError message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */
  @ApiModelProperty(example = "The object you're trying to find doesn't seem to exist.", value = "")


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
    NotFoundError notFoundError = (NotFoundError) o;
    return Objects.equals(this.code, notFoundError.code) &&
        Objects.equals(this.message, notFoundError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotFoundError {\n");
    
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

