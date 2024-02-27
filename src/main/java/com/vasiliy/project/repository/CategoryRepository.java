package com.vasiliy.project.repository;

import com.vasiliy.project.entity.info.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Long, Category> {

}
