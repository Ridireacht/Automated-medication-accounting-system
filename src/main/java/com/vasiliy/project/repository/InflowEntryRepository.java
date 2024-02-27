package com.vasiliy.project.repository;

import com.vasiliy.project.entity.entries.InflowEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InflowEntryRepository extends JpaRepository<InflowEntry, Long> {

}
