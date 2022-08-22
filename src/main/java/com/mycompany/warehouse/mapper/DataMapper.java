package com.mycompany.warehouse.mapper;

import com.mycompany.warehouse.model.Box;
import com.mycompany.warehouse.model.Product;
import com.mycompany.warehouse.openapi.model.BoxDto;
import com.mycompany.warehouse.openapi.model.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
/**
 * DataMapper contains the mapstruct methods to map.
 *
 * @author Noble Sebastian.
 * @version 1.0.1.0
 */

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DataMapper {
    @Mapping(target = "shelfCode", source = "box.locationCode")
    @Mapping(target = "boxId", source = "box.boxId")
    ProductDto mapToProductDto(Product product);

    Product mapToProductModel(ProductDto productDto);

    BoxDto mapToBoxDto(Box box);

    @Mapping(target = "boxId", ignore = true)
    Box mapToBoxModel(BoxDto boxDto);
}
