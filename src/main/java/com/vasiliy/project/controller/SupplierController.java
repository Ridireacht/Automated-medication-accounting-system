package com.vasiliy.project.controller;

import com.vasiliy.project.dto.SupplierDTO;
import com.vasiliy.project.service.SupplierService;
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
@RequestMapping("/suppliers")
public class SupplierController {

  private final SupplierService supplierService;


  @PostMapping
  public ResponseEntity<String> addSupplier(@Valid @RequestBody SupplierDTO supplierDTO) {
    supplierService.addSupplier(supplierDTO);
    return ResponseEntity.ok().body("{}");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateSupplier(@PathVariable("id") Long supplierId, @Valid @RequestBody SupplierDTO supplierDTO) {
    supplierService.updateSupplier(supplierId, supplierDTO);
    return ResponseEntity.ok().body("{}");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteSupplier(@PathVariable("id") Long supplierId) {
    supplierService.deleteSupplier(supplierId);
    return ResponseEntity.ok().body("{}");
  }
}
