package com.mycompany.warehouse.repository;

import com.mycompany.warehouse.model.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {

}
