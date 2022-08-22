package com.mycompany.warehouse.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.warehouse.BaseUnitTest;
import com.mycompany.warehouse.model.Product;
import com.mycompany.warehouse.openapi.model.BoxDto;
import com.mycompany.warehouse.openapi.model.ProductDto;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductServiceTest extends BaseUnitTest {

    private BoxDto boxDto ;
    @BeforeEach
    public void setUp() {
        boxDto=createBox();
    }

    @Test
    @Transactional
    void createProduct_product_shouldReturnCreatedProductList()  {
        // Given
        ProductDto productDto = getProductDto();
        // When
        ProductDto productDtoResponse = this.productService.createProduct(productDto);
        // Then
        assertThat(productDtoResponse.getBoxId())
            .isNotNull();
        assertThat(productDtoResponse.getName())
            .isEqualTo("Test products");
        assertThat(productDtoResponse.getDescription())
            .isEqualTo("test basic product");
        assertThat(productDtoResponse.getPrice())
            .isEqualTo(6.00);
        assertThat(productDtoResponse.getShelfCode())
            .isEqualTo("shelf1");

    }


    @Test
    @Transactional
    void localSearchProduct_productList_shouldReturnDefaultCreatedProductList()  {
        // Given
        ProductDto productDto = getProductDto();
        // When
        this.productService.createProduct(productDto);

        List<ProductDto> productDtoResponseList=this.productService.localSearchProduct(productDto.getName(),0,5,new RuntimeException());
        // Then
        assertThat(productDtoResponseList)
            .isNotEmpty();
       assertThat(productDtoResponseList.get(0).getBoxId())
            .isNotNull();
        assertThat(productDtoResponseList.get(0).getName())
            .isEqualTo("product1");
        assertThat(productDtoResponseList.get(0).getDescription())
            .isEqualTo("basic product");
        assertThat(productDtoResponseList.get(0).getPrice())
            .isEqualTo(6.00);
        assertThat(productDtoResponseList.get(0).getShelfCode())
            .isEqualTo("shelf11");

    }


    @Test
    void searchProduct_productList_shouldReturnDefaultCreatedProductList()  {
        // Given
        Product product=new Product();
        product.setName("Search item 1");
        product.setPrice(6.00);
        product.setDescription("Search item 1 Description");
        this.productRepository.save(product);
        // When

        List<ProductDto> productDtoResponseList=this.productService.searchProduct("Search",0,5);
        // Then
        assertThat(productDtoResponseList)
            .isNotEmpty();

    }

    private ProductDto getProductDto() {
        return ProductDto.builder().name("Test products").description("test basic product").price(6.00).boxId(boxDto.getBoxId())
            .build();
    }
    private BoxDto createBox(){
        return this.boxService.createBox(getBoxDtoDto());
    }
}