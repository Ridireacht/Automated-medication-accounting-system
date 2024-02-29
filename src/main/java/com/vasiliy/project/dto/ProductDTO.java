package com.vasiliy.project.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

  @NotBlank
  private String name;

  @NotNull
  private Long categoryId;

  @NotBlank
  private String unitOfMeasure;

  @Min(value = 1, message = "значение должно быть больше нуля")
  private Long expirationDays;

  @NotNull
  private Boolean isVital;
}
