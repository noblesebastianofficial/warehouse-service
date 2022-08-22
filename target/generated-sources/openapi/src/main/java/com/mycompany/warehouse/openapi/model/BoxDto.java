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
 * BoxDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T19:42:14.392951+02:00[Europe/Amsterdam]")@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

public class BoxDto   {
  @JsonProperty("boxId")
  private Long boxId;

  @JsonProperty("boxCode")
  private String boxCode;

  @JsonProperty("locationCode")
  private String locationCode;

  public BoxDto boxId(Long boxId) {
    this.boxId = boxId;
    return this;
  }

  /**
   * Get boxId
   * @return boxId
  */
  @ApiModelProperty(example = "1", value = "")


  public Long getBoxId() {
    return boxId;
  }

  public void setBoxId(Long boxId) {
    this.boxId = boxId;
  }

  public BoxDto boxCode(String boxCode) {
    this.boxCode = boxCode;
    return this;
  }

  /**
   * Get boxCode
   * @return boxCode
  */
  @ApiModelProperty(example = "Box 1", required = true, value = "")
  @NotNull


  public String getBoxCode() {
    return boxCode;
  }

  public void setBoxCode(String boxCode) {
    this.boxCode = boxCode;
  }

  public BoxDto locationCode(String locationCode) {
    this.locationCode = locationCode;
    return this;
  }

  /**
   * Get locationCode
   * @return locationCode
  */
  @ApiModelProperty(example = "Shelf1", required = true, value = "")
  @NotNull


  public String getLocationCode() {
    return locationCode;
  }

  public void setLocationCode(String locationCode) {
    this.locationCode = locationCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BoxDto boxDto = (BoxDto) o;
    return Objects.equals(this.boxId, boxDto.boxId) &&
        Objects.equals(this.boxCode, boxDto.boxCode) &&
        Objects.equals(this.locationCode, boxDto.locationCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(boxId, boxCode, locationCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BoxDto {\n");
    
    sb.append("    boxId: ").append(toIndentedString(boxId)).append("\n");
    sb.append("    boxCode: ").append(toIndentedString(boxCode)).append("\n");
    sb.append("    locationCode: ").append(toIndentedString(locationCode)).append("\n");
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

