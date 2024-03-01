package com.vasiliy.project.mapper;

import com.vasiliy.project.dto.info.ProductDTO;
import com.vasiliy.project.entity.info.Product;
import com.vasiliy.project.repository.CategoryRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class ProductMapper {

  @Autowired
  protected CategoryRepository categoryRepository;


  @Mapping(target = "category", expression = "java(categoryRepository.findById(productDTO.getCategoryId()).get())")
  public abstract Product mapDTOtoProduct(ProductDTO productDTO);
}
