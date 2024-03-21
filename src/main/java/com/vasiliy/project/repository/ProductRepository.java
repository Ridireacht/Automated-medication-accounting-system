package com.vasiliy.project.repository;

import com.vasiliy.project.entity.info.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  boolean existsById(Long productId);


  @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
  List<Product> findProductsByCategoryId(@Param("categoryId") Long categoryId);
}
