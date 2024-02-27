package com.vasiliy.project.controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

  @GetMapping
  public String getCategories(Model model) {
    model.addAttribute("pageTitle", "Привет, мир!");
    model.addAttribute("message", "Это страница, созданная с использованием Thymeleaf.");
    return "categories";
  }
}
