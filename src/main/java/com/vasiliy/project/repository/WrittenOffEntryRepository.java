package com.vasiliy.project.repository;

import com.vasiliy.project.entity.entries.WrittenOffEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WrittenOffEntryRepository extends JpaRepository<Long, WrittenOffEntry> {

}
