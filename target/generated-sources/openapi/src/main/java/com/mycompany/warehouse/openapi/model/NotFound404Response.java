package com.mycompany.warehouse.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.mycompany.warehouse.openapi.model.NotFoundError;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * NotFound404Response
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T19:42:14.392951+02:00[Europe/Amsterdam]")@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

public class NotFound404Response   {
  @JsonProperty("error")
  @Valid
  private List<NotFoundError> error = null;

  public NotFound404Response error(List<NotFoundError> error) {
    this.error = error;
    return this;
  }

  public NotFound404Response addErrorItem(NotFoundError errorItem) {
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

  public List<NotFoundError> getError() {
    return error;
  }

  public void setError(List<NotFoundError> error) {
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
    NotFound404Response notFound404Response = (NotFound404Response) o;
    return Objects.equals(this.error, notFound404Response.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotFound404Response {\n");
    
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

