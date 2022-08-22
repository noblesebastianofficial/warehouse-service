package com.mycompany.warehouse.service;

import com.mycompany.warehouse.mapper.DataMapper;
import com.mycompany.warehouse.model.Box;
import com.mycompany.warehouse.model.Product;
import com.mycompany.warehouse.openapi.model.ProductDto;
import com.mycompany.warehouse.repository.BoxRepository;
import com.mycompany.warehouse.repository.ProductRepository;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
/**
 * ProductServiceImpl class contains implementations for the product service methods.
 *
 * @author Noble Sebastian.
 * @version 1.0.1.0
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final DataMapper dataMapper;

    @NotNull
    private final ProductRepository productRepository;

    @NotNull
    private final BoxRepository boxRepository;

    /**
     * searchProduct method returns list of the products which is associated with the search term.
     * @param searchTerm search keyword
     * @param offset page offset
     * @param limit page limit
     * @return List ProductDto list of products associated with the given search term
     */
    @Override
    @Retry(name = "productSearch", fallbackMethod = "localSearchProduct")
    public List<ProductDto> searchProduct(String searchTerm, Integer offset, Integer limit) {
        log.debug("A  search is initiated (The search keyword is '{}'", searchTerm);
        return productRepository.search(searchTerm, limit, offset).stream().map(dataMapper::mapToProductDto)
            .collect(Collectors.toList());
    }

    /**
     * createProduct method creates product and add the product to box.
     * @param productDto details of the product
     * @return ProductDto details of the created product with box id
     */
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        final Box box = boxRepository.findById(productDto.getBoxId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "could not find wanted category"));
        Product product = dataMapper.mapToProductModel(productDto);
        product.setBox(box);
        Product savedProduct = this.productRepository.save(product);
        log.debug("A new product is saved(The name of the product is '{}'", product.getName());
        return dataMapper.mapToProductDto(savedProduct);
    }

    /**
     * localSearchProduct is the method returns dummy product which get invokes if the searchProduct is
     * failed due to internal server error after maxRetryAttempts mentioned in the configuration. Current config
     * value is 3
     * @param searchTerm search key
     * @param offset offset value
     * @param limit page limit
     * @param re RuntimeException
     * @return List ProductDto contains the dummy product list
     */
    @Override
    public List<ProductDto> localSearchProduct(String searchTerm, Integer offset, Integer limit, RuntimeException re) {
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(ProductDto.builder().name("product1").description("basic product").price(6.00).boxId(1L)
            .shelfCode("shelf11").build());
        log.debug("A default product is returned for the search key (The search keyword is '{}'", searchTerm);
        return productDtoList;
    }

}
