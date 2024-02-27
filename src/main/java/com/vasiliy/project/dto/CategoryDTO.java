package com.vasiliy.project.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {

  @Size(min = 7, message = "Название категории должно содержать минимум 7 символов")
  private String name;
}
