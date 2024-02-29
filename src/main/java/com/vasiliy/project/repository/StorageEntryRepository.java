package com.vasiliy.project.repository;

import com.vasiliy.project.entity.StorageProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageEntryRepository extends JpaRepository<StorageProduct, Long> {

}
