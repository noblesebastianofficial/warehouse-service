package com.mycompany.warehouse.repository;

import com.mycompany.warehouse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, SearchRepository {

}
