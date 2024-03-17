package com.vasiliy.project.repository;

import com.vasiliy.project.entity.info.AccountingType;
import com.vasiliy.project.entity.info.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingTypeRepository extends JpaRepository<AccountingType, Long> {

}
