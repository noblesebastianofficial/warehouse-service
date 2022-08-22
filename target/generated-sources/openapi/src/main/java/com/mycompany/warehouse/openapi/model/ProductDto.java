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
 * ProductDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T19:42:14.392951+02:00[Europe/Amsterdam]")@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

public class ProductDto   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("boxId")
  private Long boxId;

  @JsonProperty("shelfCode")
  private String shelfCode;

  public ProductDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "table", required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @ApiModelProperty(example = "Green table", value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductDto price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @ApiModelProperty(example = "5.0", required = true, value = "")
  @NotNull


  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public ProductDto boxId(Long boxId) {
    this.boxId = boxId;
    return this;
  }

  /**
   * Get boxId
   * @return boxId
  */
  @ApiModelProperty(example = "1", required = true, value = "")
  @NotNull


  public Long getBoxId() {
    return boxId;
  }

  public void setBoxId(Long boxId) {
    this.boxId = boxId;
  }

  public ProductDto shelfCode(String shelfCode) {
    this.shelfCode = shelfCode;
    return this;
  }

  /**
   * Get shelfCode
   * @return shelfCode
  */
  @ApiModelProperty(example = "shelf1", value = "")


  public String getShelfCode() {
    return shelfCode;
  }

  public void setShelfCode(String shelfCode) {
    this.shelfCode = shelfCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductDto productDto = (ProductDto) o;
    return Objects.equals(this.name, productDto.name) &&
        Objects.equals(this.description, productDto.description) &&
        Objects.equals(this.price, productDto.price) &&
        Objects.equals(this.boxId, productDto.boxId) &&
        Objects.equals(this.shelfCode, productDto.shelfCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, price, boxId, shelfCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductDto {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    boxId: ").append(toIndentedString(boxId)).append("\n");
    sb.append("    shelfCode: ").append(toIndentedString(shelfCode)).append("\n");
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

