package com.mycompany.warehouse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.warehouse.service.BoxService;
import com.mycompany.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
public class BaseIntegrationIT extends BaseTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected ProductService productService;

    @Autowired
    protected BoxService boxService;


}
