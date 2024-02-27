package com.vasiliy.project.mapper;

import com.vasiliy.project.dto.ProductDTO;
import com.vasiliy.project.entity.info.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper {

  Product mapDTOtoProduct(ProductDTO productDTO);

  ProductDTO mapProductToDTO(Product product);
}
