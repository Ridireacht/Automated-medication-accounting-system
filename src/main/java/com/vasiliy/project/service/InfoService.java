package com.vasiliy.project.service;

import com.vasiliy.project.dto.CategoryDTO;
import com.vasiliy.project.dto.ProductDTO;
import com.vasiliy.project.dto.SupplierDTO;
import com.vasiliy.project.entity.info.Product;
import com.vasiliy.project.entity.info.Supplier;
import java.util.List;

public interface InfoService {

  public List<Product> getAllCategories();

  public Boolean addCategory(CategoryDTO categoryDTO);

  public Boolean modifyCategory(Long categoryId, CategoryDTO categoryDTO);

  public Boolean deleteCategory(Long categoryId);

  public List<Product> getAllProducts();

  public Boolean addProduct(ProductDTO productDTO);

  public Boolean modifyProduct(Long productId, ProductDTO productDTO);

  public Boolean deleteProduct(Long productId);

  public List<Supplier> getAllSuppliers();

  public Boolean addSupplier(ProductDTO productDTO);

  public Boolean modifySupplier(Long supplierId, SupplierDTO supplierDTO);

  public Boolean deleteSupplier(Long supplierId);
}
