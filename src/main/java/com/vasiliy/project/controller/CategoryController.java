package com.vasiliy.project.controller;

import com.vasiliy.project.dto.CategoryDTO;
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
  public ResponseEntity<String> addCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
    categoryService.addCategory(categoryDTO);
    return ResponseEntity.ok().body("{}");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateCategory(@PathVariable("id") Long categoryId, @Valid @RequestBody CategoryDTO categoryDTO) {
    categoryService.updateCategory(categoryId, categoryDTO);
    return ResponseEntity.ok().body("{}");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId) {
    categoryService.deleteCategory(categoryId);
    return ResponseEntity.ok().body("{}");
  }
}
