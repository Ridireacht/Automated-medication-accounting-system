package com.vasiliy.project.controller;

import com.vasiliy.project.dto.CategoryDTO;
import com.vasiliy.project.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

  private final CategoryService categoryService;


  @PutMapping("/{id}")
  public ResponseEntity<?> updateCategory(@PathVariable("id") Long categoryId, @Valid @RequestBody CategoryDTO categoryDTO) {
    if(categoryService.modifyCategory(categoryId, categoryDTO)) {
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.badRequest().build();
    }
  }
}
