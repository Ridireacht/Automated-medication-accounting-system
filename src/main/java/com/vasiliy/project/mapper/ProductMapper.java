package com.vasiliy.project.mapper;

import com.vasiliy.project.dto.info.ProductDTO;
import com.vasiliy.project.entity.info.Product;
import com.vasiliy.project.repository.CategoryRepository;
import com.vasiliy.project.repository.FormRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class ProductMapper {

  @Autowired
  protected CategoryRepository categoryRepository;

  @Autowired
  protected FormRepository formRepository;


  @Mapping(target = "category", expression = "java(categoryRepository.findById(productDTO.getCategoryId()).get())")
  @Mapping(target = "form", expression = "java(formRepository.findById(productDTO.getFormId()).get())")
  public abstract Product mapDTOtoProduct(ProductDTO productDTO);
}
