package com.vasiliy.project.dto;

import com.vasiliy.project.entity.info.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

  private String name;
  private String unitOfMeasure;
  private Category category;
  private Boolean isVital;
}
