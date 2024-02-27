package com.vasiliy.project.repository;

import com.vasiliy.project.entity.entries.StorageEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageEntryRepository extends JpaRepository<Long, StorageEntry> {

}
