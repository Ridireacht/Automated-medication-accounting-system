package com.vasiliy.project.controller;

import com.vasiliy.project.service.StorageProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/storage")
public class StorageProductController {

  private final StorageProductService storageProductService;



}
