package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.ProductDTO;
import com.vasiliy.project.entity.info.Category;
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
    Product product = productMapper.mapDTOtoProduct(productDTO);
    productRepository.save(product);

    return true;
  }

  @Override
  @Transactional
  public Boolean modifyProduct(Long productId, ProductDTO productDTO) {
    if (productRepository.existsById(productId)) {
      Product product = productMapper.mapDTOtoProduct(productDTO);
      product.setId(productId);

      productRepository.save(product);

      return true;
    }

    return false;
  }

  @Override
  @Transactional
  public Boolean deleteProduct(Long productId) {
    if (productRepository.existsById(productId)) {
      productRepository.deleteById(productId);
      return true;
    }

    return false;
  }
}
