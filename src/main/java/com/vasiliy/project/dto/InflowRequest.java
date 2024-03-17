package com.vasiliy.project.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class InflowRequest {

  @NotNull
  private Long productId;

  @NotNull
  private Long supplierId;

  @NotNull
  @Min(value = 1, message = "значение должно быть больше нуля")
  private Long quantity;

  @NotNull
  @Min(value = 1, message = "значение должно быть больше нуля")
  private Double priceBought;

  @NotNull
  private LocalDateTime manufacturedOn;
}
