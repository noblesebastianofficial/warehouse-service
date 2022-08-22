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
 * SearchRequestDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-22T19:42:14.392951+02:00[Europe/Amsterdam]")@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

public class SearchRequestDto   {
  @JsonProperty("searchKey")
  private String searchKey;

  @JsonProperty("offset")
  private Integer offset;

  @JsonProperty("limit")
  private Integer limit;

  public SearchRequestDto searchKey(String searchKey) {
    this.searchKey = searchKey;
    return this;
  }

  /**
   * Get searchKey
   * @return searchKey
  */
  @ApiModelProperty(example = "table", required = true, value = "")
  @NotNull


  public String getSearchKey() {
    return searchKey;
  }

  public void setSearchKey(String searchKey) {
    this.searchKey = searchKey;
  }

  public SearchRequestDto offset(Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Get offset
   * @return offset
  */
  @ApiModelProperty(example = "0", value = "")


  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public SearchRequestDto limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Get limit
   * @return limit
  */
  @ApiModelProperty(example = "5", value = "")


  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchRequestDto searchRequestDto = (SearchRequestDto) o;
    return Objects.equals(this.searchKey, searchRequestDto.searchKey) &&
        Objects.equals(this.offset, searchRequestDto.offset) &&
        Objects.equals(this.limit, searchRequestDto.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(searchKey, offset, limit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchRequestDto {\n");
    
    sb.append("    searchKey: ").append(toIndentedString(searchKey)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
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

