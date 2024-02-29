package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.ProductDTO;
import com.vasiliy.project.dto.UpdateRequest;
import com.vasiliy.project.entity.info.Product;
import com.vasiliy.project.mapper.ProductMapper;
import com.vasiliy.project.repository.CategoryRepository;
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
  private final CategoryRepository categoryRepository;

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
  public Boolean updateProduct(Long productId, UpdateRequest updateRequest) {
    if (productRepository.existsById(productId)) {
      Product product = productRepository.findById(productId).get();

      switch (updateRequest.getType()) {
        case "name" -> product.setName(updateRequest.getValue());
        case "categoryId" -> product.setCategory(categoryRepository.findById(Long.valueOf(updateRequest.getValue())).get());
        case "unitOfMeasure" -> product.setUnitOfMeasure(updateRequest.getValue());
        case "expirationDays" -> product.setExpirationDays(Long.valueOf(updateRequest.getValue()));
        case "isVital" -> product.setIsVital(updateRequest.getValue().equals("true"));
      }

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
