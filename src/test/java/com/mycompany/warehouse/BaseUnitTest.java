package com.mycompany.warehouse;

import com.mycompany.warehouse.repository.BoxRepository;
import com.mycompany.warehouse.repository.ProductRepository;
import com.mycompany.warehouse.service.BoxService;
import com.mycompany.warehouse.service.ProductService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class BaseUnitTest extends BaseTest{

    @Autowired
    protected ProductService productService;

    @Autowired
    protected BoxService boxService;

    @Mock
    protected ProductRepository productRepository;

}
