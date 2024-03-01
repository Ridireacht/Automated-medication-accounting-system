package com.vasiliy.project.controller;

import com.vasiliy.project.service.CategoryService;
import com.vasiliy.project.service.ProductService;
import com.vasiliy.project.service.StorageProductService;
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
  private final ProductService productService;
  private final StorageProductService storageProductService;


  @GetMapping("/home")
  public String getHome() {
    return "home";
  }

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

  @GetMapping("/products")
  public String getProducts(Model model) {
    model.addAttribute("categories", categoryService.getAllCategories());
    model.addAttribute("products", productService.getAllProducts());
    return "products";
  }

  @GetMapping("/storage")
  public String getStorage(Model model) {
    model.addAttribute("storageProducts", storageProductService.getAllStorageProducts());
    return "storage";
  }
}
