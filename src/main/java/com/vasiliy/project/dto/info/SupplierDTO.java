package com.vasiliy.project.dto.info;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDTO {

  @NotBlank
  private String name;

  @Pattern(regexp = "\\+\\d{11}")
  private String phoneNumber;

  @NotBlank
  private String address;
}
