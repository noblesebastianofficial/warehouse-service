package com.mycompany.warehouse.mapper;

import com.mycompany.warehouse.model.Box;
import com.mycompany.warehouse.model.Product;
import com.mycompany.warehouse.openapi.model.BoxDto;
import com.mycompany.warehouse.openapi.model.ProductDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-22T19:42:16+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
@Component
public class DataMapperImpl implements DataMapper {

    @Override
    public ProductDto mapToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto.ProductDtoBuilder productDto = ProductDto.builder();

        String locationCode = productBoxLocationCode( product );
        if ( locationCode != null ) {
            productDto.shelfCode( locationCode );
        }
        Long boxId = productBoxBoxId( product );
        if ( boxId != null ) {
            productDto.boxId( boxId );
        }
        if ( product.getName() != null ) {
            productDto.name( product.getName() );
        }
        if ( product.getDescription() != null ) {
            productDto.description( product.getDescription() );
        }
        if ( product.getPrice() != null ) {
            productDto.price( product.getPrice() );
        }

        return productDto.build();
    }

    @Override
    public Product mapToProductModel(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        if ( productDto.getName() != null ) {
            product.setName( productDto.getName() );
        }
        if ( productDto.getDescription() != null ) {
            product.setDescription( productDto.getDescription() );
        }
        if ( productDto.getPrice() != null ) {
            product.setPrice( productDto.getPrice() );
        }

        return product;
    }

    @Override
    public BoxDto mapToBoxDto(Box box) {
        if ( box == null ) {
            return null;
        }

        BoxDto.BoxDtoBuilder boxDto = BoxDto.builder();

        if ( box.getBoxId() != null ) {
            boxDto.boxId( box.getBoxId() );
        }
        if ( box.getBoxCode() != null ) {
            boxDto.boxCode( box.getBoxCode() );
        }
        if ( box.getLocationCode() != null ) {
            boxDto.locationCode( box.getLocationCode() );
        }

        return boxDto.build();
    }

    @Override
    public Box mapToBoxModel(BoxDto boxDto) {
        if ( boxDto == null ) {
            return null;
        }

        Box box = new Box();

        if ( boxDto.getBoxCode() != null ) {
            box.setBoxCode( boxDto.getBoxCode() );
        }
        if ( boxDto.getLocationCode() != null ) {
            box.setLocationCode( boxDto.getLocationCode() );
        }

        return box;
    }

    private String productBoxLocationCode(Product product) {
        if ( product == null ) {
            return null;
        }
        Box box = product.getBox();
        if ( box == null ) {
            return null;
        }
        String locationCode = box.getLocationCode();
        if ( locationCode == null ) {
            return null;
        }
        return locationCode;
    }

    private Long productBoxBoxId(Product product) {
        if ( product == null ) {
            return null;
        }
        Box box = product.getBox();
        if ( box == null ) {
            return null;
        }
        Long boxId = box.getBoxId();
        if ( boxId == null ) {
            return null;
        }
        return boxId;
    }
}
