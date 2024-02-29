package com.vasiliy.project.repository;

import com.vasiliy.project.entity.records.WrittenOffRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WrittenOffEntryRepository extends JpaRepository<WrittenOffRecord, Long> {

}
