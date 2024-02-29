package com.vasiliy.project.repository;

import com.vasiliy.project.entity.records.InflowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InflowRecordRepository extends JpaRepository<InflowRecord, Long> {

}
