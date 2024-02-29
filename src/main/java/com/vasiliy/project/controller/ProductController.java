package com.vasiliy.project.controller;

import com.vasiliy.project.dto.ProductDTO;
import com.vasiliy.project.dto.UpdateRequest;
import com.vasiliy.project.exception.CustomBadRequestException;
import com.vasiliy.project.exception.CustomValidationException;
import com.vasiliy.project.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    if (updateRequest.getType() == null || !updateRequest.typeMatchesAny(new String[] {"name", "categoryId", "unitOfMeasure", "expirationDays", "isVital"})) {
      throw new CustomBadRequestException();
    }

    if (updateRequest.getValue() == null || updateRequest.getValue().isBlank()) {
      throw new CustomValidationException("поле не должно быть пустым");
    }

    if (updateRequest.getType().equals("expirationDays")) {
      try {
        Long.parseLong(updateRequest.getValue());
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
