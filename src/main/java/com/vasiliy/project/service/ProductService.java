package com.vasiliy.project.service;

import com.vasiliy.project.dto.info.ProductDTO;
import com.vasiliy.project.dto.info.UpdateRequest;
import com.vasiliy.project.entity.info.Product;

import java.util.List;

public interface ProductService {
  List<Product> getAllProducts();

  Boolean addProduct(ProductDTO productDTO);

  Boolean updateProduct(Long productId, UpdateRequest updateRequest);

  Boolean deleteProduct(Long productId);
}
