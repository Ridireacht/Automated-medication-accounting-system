package com.vasiliy.project.repository;

import com.vasiliy.project.entity.entries.SoldEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldEntryRepository extends JpaRepository<SoldEntry, Long> {

}
