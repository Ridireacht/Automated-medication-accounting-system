package com.vasiliy.project.repository;

import com.vasiliy.project.entity.records.SoldRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldEntryRepository extends JpaRepository<SoldRecord, Long> {

}
