package com.mycompany.warehouse.service;

import com.mycompany.warehouse.openapi.model.ProductDto;
import java.util.List;
/**
 * ProductService class contains method declaration for the product service methods.
 *
 * @author Noble Sebastian.
 * @version 1.0.1.0
 */

public interface ProductService {

    List<ProductDto> searchProduct(String terms, Integer offset, Integer limit);

    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> localSearchProduct(String terms, Integer offset, Integer limit, RuntimeException re);

}
