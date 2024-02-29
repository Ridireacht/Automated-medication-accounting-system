package com.vasiliy.project.service;

import com.vasiliy.project.dto.CategoryDTO;
import com.vasiliy.project.dto.UpdateRequest;
import com.vasiliy.project.entity.info.Category;
import java.util.List;

public interface CategoryService {
  List<Category> getAllCategories();

  Boolean addCategory(CategoryDTO categoryDTO);

  Boolean updateCategory(Long categoryId, UpdateRequest updateRequest);

  Boolean deleteCategory(Long categoryId);
}
