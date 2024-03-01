package com.vasiliy.project.controller;

import com.vasiliy.project.dto.info.SupplierDTO;
import com.vasiliy.project.dto.info.UpdateRequest;
import com.vasiliy.project.exception.CustomBadRequestException;
import com.vasiliy.project.exception.CustomValidationException;
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
  public ResponseEntity<String> addSupplier(@RequestBody @Valid SupplierDTO supplierDTO) {
    supplierService.addSupplier(supplierDTO);
    return ResponseEntity.ok().body("{}");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateSupplier(@PathVariable("id") Long supplierId, @RequestBody UpdateRequest updateRequest) {
    if (updateRequest.getType() == null || !updateRequest.typeMatchesAny(new String[] {"name", "phoneNumber", "address"})) {
      throw new CustomBadRequestException();
    }

    if (updateRequest.getValue() == null || updateRequest.getValue().isBlank()) {
      throw new CustomValidationException("поле не должно быть пустым");
    }

    if (updateRequest.getType().equals("phoneNumber") && !updateRequest.getValue().matches("\\+\\d{11}")) {
      throw new CustomValidationException("введённая строка не соответствует формату телефонного номера");
    }

    supplierService.updateSupplier(supplierId, updateRequest);
    return ResponseEntity.ok().body("{}");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteSupplier(@PathVariable("id") Long supplierId) {
    supplierService.deleteSupplier(supplierId);
    return ResponseEntity.ok().body("{}");
  }
}
