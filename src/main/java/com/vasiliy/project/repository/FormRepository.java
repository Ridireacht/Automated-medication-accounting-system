package com.vasiliy.project.repository;

import com.vasiliy.project.entity.info.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

}
