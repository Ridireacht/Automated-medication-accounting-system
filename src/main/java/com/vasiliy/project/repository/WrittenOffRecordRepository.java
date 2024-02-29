package com.vasiliy.project.repository;

import com.vasiliy.project.entity.records.WrittenOffRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WrittenOffRecordRepository extends JpaRepository<WrittenOffRecord, Long> {

}
