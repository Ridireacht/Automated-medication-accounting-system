package com.vasiliy.project.repository;

import com.vasiliy.project.entity.StorageProduct;
import com.vasiliy.project.entity.records.SoldRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldRecordRepository extends JpaRepository<SoldRecord, Long> {

}
