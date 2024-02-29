package com.vasiliy.project.repository;

import com.vasiliy.project.entity.records.InflowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InflowEntryRepository extends JpaRepository<InflowRecord, Long> {

}
