package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.CategoryDTO;
import com.vasiliy.project.dto.ProductDTO;
import com.vasiliy.project.dto.SupplierDTO;
import com.vasiliy.project.entity.info.Category;
import com.vasiliy.project.entity.info.Product;
import com.vasiliy.project.entity.info.Supplier;
import com.vasiliy.project.mapper.CategoryMapper;
import com.vasiliy.project.mapper.ProductMapper;
import com.vasiliy.project.mapper.SupplierMapper;
import com.vasiliy.project.repository.CategoryRepository;
import com.vasiliy.project.repository.ProductRepository;
import com.vasiliy.project.repository.SupplierRepository;
import com.vasiliy.project.service.InfoService;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InfoServiceImpl implements InfoService {

  private final CategoryRepository categoryRepository;
  private final ProductRepository productRepository;
  private final SupplierRepository supplierRepository;

  private final CategoryMapper categoryMapper;
  private final ProductMapper productMapper;
  private final SupplierMapper supplierMapper;


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
  public Boolean modifyCategory(Long categoryId, CategoryDTO categoryDTO) {
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

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  @Transactional
  public Boolean addProduct(ProductDTO productDTO) {
    return null;
  }

  @Override
  @Transactional
  public Boolean modifyProduct(Long productId, ProductDTO productDTO) {
    return null;
  }

  @Override
  @Transactional
  public Boolean deleteProduct(Long productId) {
    return null;
  }

  @Override
  public List<Supplier> getAllSuppliers() {
    return supplierRepository.findAll();
  }

  @Override
  @Transactional
  public Boolean addSupplier(ProductDTO productDTO) {
    return null;
  }

  @Override
  @Transactional
  public Boolean modifySupplier(Long supplierId, SupplierDTO supplierDTO) {
    return null;
  }

  @Override
  @Transactional
  public Boolean deleteSupplier(Long supplierId) {
    return null;
  }
}
