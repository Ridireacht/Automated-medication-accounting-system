package com.vasiliy.project.mapper;

import com.vasiliy.project.dto.ProductDTO;
import com.vasiliy.project.entity.info.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper {

  @Mapping(target = "category", expression = "java(categoryRepository.findById(productDTO.getCategoryId()).get())")
  Product mapDTOtoProduct(ProductDTO productDTO);
}
