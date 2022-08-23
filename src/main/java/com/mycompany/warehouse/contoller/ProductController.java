package com.mycompany.warehouse.contoller;

import com.mycompany.warehouse.openapi.api.ProductsApi;
import com.mycompany.warehouse.openapi.model.ProductDto;
import com.mycompany.warehouse.service.ProductService;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * ProductController contains the API methods for Product.
 *
 * @author Noble Sebastian.
 * @version 1.0.1.0
 */

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductsApi {

    @NotNull
    private final ProductService productService;


    /**
     * earchProduct method provides api to search the given search key.
     * @param searchKey Search term
     * @param offset offset value
     * @param limit limit value
     * @return ResponseEntity List ProductDto contains the list of products corresponding to the search key
     */
    @Override
    public ResponseEntity<List<ProductDto>> searchProduct(
         @RequestParam String searchKey, @RequestParam Integer offset, @RequestParam Integer limit) {
        return ResponseEntity.ok(productService.searchProduct(searchKey,
            offset, limit));

    }

    /**
     * createProduct method creates the Product for the given Product details.
     * @param productDto contains the Product details as input request
     * @return ResponseEntity ProductDto contains the newly created Product details.
     */
    @Override
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(this.productService.createProduct(productDto), HttpStatus.CREATED);
    }
}
