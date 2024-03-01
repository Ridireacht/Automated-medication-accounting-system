package com.vasiliy.project.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutflowRequest {

  @NotNull
  private String type;

  @NotNull
  @Min(value = 1, message = "значение должно быть больше нуля")
  private Long quantity;

  private Long soldPrice;
}
