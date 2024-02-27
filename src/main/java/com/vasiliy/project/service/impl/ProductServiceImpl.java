package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.ProductDTO;
import com.vasiliy.project.entity.info.Product;
import com.vasiliy.project.mapper.ProductMapper;
import com.vasiliy.project.repository.ProductRepository;
import com.vasiliy.project.service.ProductService;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  private final ProductMapper productMapper;


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
}
