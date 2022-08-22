package com.mycompany.warehouse.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.mycompany.warehouse.openapi.model.BadRequestError;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BadRequest400Response
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T19:42:14.392951+02:00[Europe/Amsterdam]")@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

public class BadRequest400Response   {
  @JsonProperty("error")
  @Valid
  private List<BadRequestError> error = null;

  public BadRequest400Response error(List<BadRequestError> error) {
    this.error = error;
    return this;
  }

  public BadRequest400Response addErrorItem(BadRequestError errorItem) {
    if (this.error == null) {
      this.error = new ArrayList<>();
    }
    this.error.add(errorItem);
    return this;
  }

  /**
   * Get error
   * @return error
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<BadRequestError> getError() {
    return error;
  }

  public void setError(List<BadRequestError> error) {
    this.error = error;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BadRequest400Response badRequest400Response = (BadRequest400Response) o;
    return Objects.equals(this.error, badRequest400Response.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BadRequest400Response {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

