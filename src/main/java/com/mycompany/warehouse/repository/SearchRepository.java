package com.mycompany.warehouse.repository;

import com.mycompany.warehouse.model.Product;
import java.util.List;

public interface SearchRepository {

    List<Product> search(String terms, Integer limit, Integer offset);
}
