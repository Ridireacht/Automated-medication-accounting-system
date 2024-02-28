package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.CategoryDTO;
import com.vasiliy.project.entity.info.Category;
import com.vasiliy.project.mapper.CategoryMapper;
import com.vasiliy.project.repository.CategoryRepository;
import com.vasiliy.project.service.CategoryService;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  private final CategoryMapper categoryMapper;


  @Override
  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  @Override
  @Transactional
  public Boolean addCategory(CategoryDTO categoryDTO) {
    Category category = categoryMapper.mapDTOtoCategory(categoryDTO);
    categoryRepository.save(category);

    return true;
  }

  @Override
  @Transactional
  public Boolean updateCategory(Long categoryId, CategoryDTO categoryDTO) {
    if (categoryRepository.existsById(categoryId)) {
      Category category = categoryMapper.mapDTOtoCategory(categoryDTO);
      category.setId(categoryId);

      categoryRepository.save(category);

      return true;
    }

    return false;
  }

  @Override
  @Transactional
  public Boolean deleteCategory(Long categoryId) {
    if (categoryRepository.existsById(categoryId)) {
      categoryRepository.deleteById(categoryId);
      return true;
    }

    return false;
  }
}
