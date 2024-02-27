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

@Controller
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

  private final CategoryService categoryService;


  @GetMapping
  public String getCategories(Model model) {
    model.addAttribute("categories", categoryService.getAllCategories());
    return "categories";
  }

  @PutMapping("/{id}")
  @ResponseBody
  public ResponseEntity<?> updateCategory(@PathVariable("id") Long categoryId, @Valid @RequestBody CategoryDTO categoryDTO) {
    if(categoryService.modifyCategory(categoryId, categoryDTO)) {
      return ResponseEntity.ok("{}");
    } else {
      return ResponseEntity.badRequest().build();
    }
  }
}
