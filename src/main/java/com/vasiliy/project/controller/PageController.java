package com.vasiliy.project.controller;

import com.vasiliy.project.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PageController {

  private final CategoryService categoryService;
  private final FormService formService;
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
    model.addAttribute("categories", categoryService.getAllCategoriesWithNbsp());
    model.addAttribute("forms", formService.getAllForms());
    model.addAttribute("products", productService.getAllProducts());
    return "products";
  }

  @GetMapping("/storage")
  public String getStorage(Model model) {
    model.addAttribute("products", productService.getAllProducts());
    model.addAttribute("suppliers", supplierService.getAllSuppliers());
    model.addAttribute("storageProducts", storageProductService.getAllStorageProducts());
    return "storage";
  }

  @GetMapping("/storage/inflow")
  public String getInflowRecords(Model model) {
    model.addAttribute("inflowRecords", storageProductService.getAllInflowRecords());
    return "inflow";
  }

  @GetMapping("/storage/sold")
  public String getSoldRecords(Model model) {
    model.addAttribute("soldRecords", storageProductService.getAllSoldRecords());
    return "sold";
  }

  @GetMapping("/storage/written-off")
  public String getWrittenOffRecords(Model model) {
    model.addAttribute("writtenOffRecords", storageProductService.getAllWrittenOffRecords());
    return "written-off";
  }

  @GetMapping("/prediction")
  public String getPrediction(Model model) {
    model.addAttribute("products", productService.getAllProducts());
    return "prediction";
  }
}
