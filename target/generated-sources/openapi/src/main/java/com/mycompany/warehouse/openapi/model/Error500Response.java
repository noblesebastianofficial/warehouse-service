package com.mycompany.warehouse.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Error500Response
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T19:42:14.392951+02:00[Europe/Amsterdam]")@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

public class Error500Response   {
  @JsonProperty("error")
  @Valid
  private List<Object> error = null;

  public Error500Response error(List<Object> error) {
    this.error = error;
    return this;
  }

  public Error500Response addErrorItem(Object errorItem) {
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


  public List<Object> getError() {
    return error;
  }

  public void setError(List<Object> error) {
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
    Error500Response error500Response = (Error500Response) o;
    return Objects.equals(this.error, error500Response.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error500Response {\n");
    
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

