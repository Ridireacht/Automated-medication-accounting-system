package com.vasiliy.project.mapper;

import com.vasiliy.project.dto.CategoryDTO;
import com.vasiliy.project.entity.info.Category;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper {

  Category mapDTOtoCategory(CategoryDTO categoryDTO);

  CategoryDTO mapCategoryToDTO(Category category);
}
