package com.mycompany.warehouse.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.mycompany.warehouse.BaseIntegrationIT;
import com.mycompany.warehouse.openapi.model.BoxDto;
import com.mycompany.warehouse.openapi.model.ProductDto;
import com.mycompany.warehouse.openapi.model.SearchRequestDto;
import java.util.concurrent.ThreadLocalRandom;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductControllerIntegrationTest extends BaseIntegrationIT {
    private static final String API_ROOT = "/products";

    private BoxDto boxDto ;

    @BeforeEach
    public void setUp() {
        boxDto=createBox();
    }
    @Test
    void createProduct_product_isCreated() throws Exception{
        // Given
        ProductDto productDto = getProductDto();
        // When
        mockMvc.perform(post(API_ROOT )
            .contentType(APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(productDto)))
        //Then
        .andExpect(status().isCreated());
    }
    @Test
    void createProduct_product_isBadRequest() throws Exception{
        // Given
        ProductDto productDto = getProductDto();
        productDto.setBoxId(null);
        // When
        mockMvc.perform(post(API_ROOT)
            .contentType(APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(productDto)))
        //Then
        .andExpect(status().isBadRequest());
    }

    @Test
    void createProduct_product_isNotFoundBoxId() throws Exception{
        // Given
        ProductDto productDto = getProductDto();
        productDto.setBoxId(ThreadLocalRandom.current().nextLong(100));
        // When
        mockMvc.perform(post(API_ROOT)
            .contentType(APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(productDto)))
            //Then
            .andExpect(status().isNotFound());
    }

    @Test
    void createProduct_product_isNotFound () throws Exception{
        // Given
        ProductDto productDto = getProductDto();
        productDto.setBoxId(null);
        // When
        mockMvc.perform(post(API_ROOT+"/test")
            .contentType(APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(productDto)))
            //Then
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void searchProduct_productList_isSuccessful() throws Exception{
        // Given
        ProductDto productDto = getProductDto();
        this.productService.createProduct(productDto);
        SearchRequestDto searchRequestDto=getSearchRequestDto(productDto.getName());
        // When
        mockMvc.perform(get(API_ROOT+"/search")
            .contentType(APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(searchRequestDto)))
            //Then
            .andExpect(status().isOk());
    }

    @Test
    void searchProduct_productList_isBadRequest() throws Exception{
        // Given
        SearchRequestDto searchRequestDto=new SearchRequestDto();

        // When
        mockMvc.perform(get(API_ROOT+"/search")
            .contentType(APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(searchRequestDto)))
            //Then
            .andExpect(status().isBadRequest());
    }

    @Test
    void searchProduct_productList_isNotFound() throws Exception{
        // Given
        SearchRequestDto searchRequestDto=getSearchRequestDto("test");

        // When
        mockMvc.perform(get(API_ROOT+"/search/bash")
            .contentType(APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(searchRequestDto)))
            //Then
            .andExpect(status().isNotFound());
    }


    private ProductDto getProductDto() {
        return ProductDto.builder().name("test products").description("test basic product").price(6.00).boxId(boxDto.getBoxId())
            .shelfCode("shelf1").build();
    }

    private SearchRequestDto getSearchRequestDto(String searchKey) {
        return SearchRequestDto.builder().searchKey(searchKey).build();
    }


    private BoxDto createBox(){
        return this.boxService.createBox(getBoxDtoDto());
    }
}
