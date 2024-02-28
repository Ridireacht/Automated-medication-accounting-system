package com.vasiliy.project.controller;

import com.vasiliy.project.service.CategoryService;
import com.vasiliy.project.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PageController {

  private final CategoryService categoryService;
  private final SupplierService supplierService;


  @GetMapping("/categories")
  public String getCategories(Model model) {
    model.addAttribute("categories", categoryService.getAllCategories());
    return "categories";
  }

  @GetMapping("/suppliers")
  public String getSuppliers(Model model) {
    model.addAttribute("suppliers", supplierService.getAllSuppliers());
    return "suppliers";
  }
}
