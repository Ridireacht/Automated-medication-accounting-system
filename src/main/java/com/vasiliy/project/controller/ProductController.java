package com.vasiliy.project.controller;

import com.vasiliy.project.dto.info.ProductDTO;
import com.vasiliy.project.dto.info.UpdateRequest;
import com.vasiliy.project.exception.CustomBadRequestException;
import com.vasiliy.project.exception.CustomValidationException;
import com.vasiliy.project.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;


  @PostMapping
  public ResponseEntity<String> addProduct(@RequestBody @Valid ProductDTO productDTO) {
    productService.addProduct(productDTO);
    return ResponseEntity.ok().body("{}");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateProduct(@PathVariable("id") Long productId, @RequestBody UpdateRequest updateRequest) {
    if (updateRequest.getType() == null || !updateRequest.typeMatchesAny(new String[] {"name", "categoryId", "formId", "expirationDays", "isVital", "isPrescriptive"})) {
      throw new CustomBadRequestException();
    }

    if (updateRequest.getValue() == null || updateRequest.getValue().isBlank()) {
      throw new CustomValidationException("поле не должно быть пустым");
    }

    if (updateRequest.getType().equals("expirationDays")) {
      try {
        Long value = Long.parseLong(updateRequest.getValue());

        if (value <= 0) {
          throw new CustomValidationException("значение должно быть больше нуля");
        }
      } catch (NumberFormatException e) {
        throw new CustomValidationException("введённое значение не является числовым");
      }
    }

    productService.updateProduct(productId, updateRequest);
    return ResponseEntity.ok().body("{}");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId) {
    productService.deleteProduct(productId);
    return ResponseEntity.ok().body("{}");
  }
}
