package com.vasiliy.project.repository;

import com.vasiliy.project.entity.info.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Long, Supplier> {

}
