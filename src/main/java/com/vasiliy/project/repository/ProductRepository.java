package com.vasiliy.project.repository;

import com.vasiliy.project.entity.info.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  boolean existsById(Long productId);
}
