package com.vasiliy.project.service.impl;

import com.vasiliy.project.entity.info.Category;
import com.vasiliy.project.repository.CategoryRepository;
import com.vasiliy.project.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;


  @Override
  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }
}
