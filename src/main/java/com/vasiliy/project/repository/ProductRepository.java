package com.vasiliy.project.repository;

import com.vasiliy.project.entity.info.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Long, Product> {

}
