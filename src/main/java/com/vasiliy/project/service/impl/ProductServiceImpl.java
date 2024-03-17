package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.info.ProductDTO;
import com.vasiliy.project.dto.info.UpdateRequest;
import com.vasiliy.project.entity.StorageProduct;
import com.vasiliy.project.entity.info.Product;
import com.vasiliy.project.mapper.ProductMapper;
import com.vasiliy.project.repository.*;
import com.vasiliy.project.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;
  private final FormRepository formRepository;
  private final AccountingTypeRepository accountingTypeRepository;
  private final StorageProductRepository storageProductRepository;

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
        case "formId" -> product.setForm(formRepository.findById(Long.valueOf(updateRequest.getValue())).get());
        case "accountingTypeId" -> product.setAccountingType(accountingTypeRepository.findById(Long.valueOf(updateRequest.getValue())).get());
        case "expirationDays" -> {
          List<StorageProduct> storageProducts = product.getStorageProducts();

          for (StorageProduct sp : storageProducts) {
            sp.setExpiresAt(sp.getExpiresAt().plusDays(-product.getExpirationDays()));
            sp.setExpiresAt(sp.getExpiresAt().plusDays(Long.parseLong(updateRequest.getValue())));
            storageProductRepository.save(sp);
          }

          product.setExpirationDays(Long.valueOf(updateRequest.getValue()));
        }
        case "isVital" -> product.setIsVital(updateRequest.getValue().equals("true"));
        case "isPrescriptive" -> product.setIsPrescriptive(updateRequest.getValue().equals("true"));
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
