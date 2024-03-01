package com.vasiliy.project.controller;

import com.vasiliy.project.dto.info.CategoryDTO;
import com.vasiliy.project.dto.info.UpdateRequest;
import com.vasiliy.project.exception.CustomBadRequestException;
import com.vasiliy.project.exception.CustomValidationException;
import com.vasiliy.project.service.CategoryService;
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
@RequestMapping("/categories")
public class CategoryController {

  private final CategoryService categoryService;


  @PostMapping
  public ResponseEntity<String> addCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
    categoryService.addCategory(categoryDTO);
    return ResponseEntity.ok().body("{}");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateCategory(@PathVariable("id") Long categoryId, @RequestBody UpdateRequest updateRequest) {
    if (updateRequest.getType() == null || !updateRequest.typeMatchesAny(new String[] {"name"})) {
      throw new CustomBadRequestException();
    }

    if (updateRequest.getValue() == null || updateRequest.getValue().isBlank()) {
      throw new CustomValidationException("поле не должно быть пустым");
    }

    categoryService.updateCategory(categoryId, updateRequest);
    return ResponseEntity.ok().body("{}");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId) {
    categoryService.deleteCategory(categoryId);
    return ResponseEntity.ok().body("{}");
  }
}
