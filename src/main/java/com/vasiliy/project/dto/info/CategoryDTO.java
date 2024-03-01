package com.vasiliy.project.dto.info;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {

  @NotBlank
  private String name;
}
