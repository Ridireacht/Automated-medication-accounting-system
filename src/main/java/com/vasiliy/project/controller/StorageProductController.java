package com.vasiliy.project.controller;

import com.vasiliy.project.dto.InflowRequest;
import com.vasiliy.project.dto.OutflowRequest;
import com.vasiliy.project.dto.info.ProductDTO;
import com.vasiliy.project.dto.info.UpdateRequest;
import com.vasiliy.project.exception.CustomBadRequestException;
import com.vasiliy.project.exception.CustomValidationException;
import com.vasiliy.project.service.StorageProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/storage")
public class StorageProductController {

  private final StorageProductService storageProductService;


  @PostMapping
  public ResponseEntity<String> inflowStorageProduct(@RequestBody @Valid InflowRequest inflowRequest) {
    storageProductService.addNewStorageProduct(inflowRequest);
    return ResponseEntity.ok().body("{}");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> outflowStorageProduct(@PathVariable("id") Long storageProductId, @RequestBody @Valid OutflowRequest outflowRequest) {
    if (outflowRequest.getType() == null || !outflowRequest.typeMatchesAny(new String[] {"sold", "writtenOff"})) {
      throw new CustomBadRequestException();
    }

    if (outflowRequest.getType().equals("sold")) {
      if (outflowRequest.getSoldPrice() == null) {
        throw new CustomBadRequestException();
      } else if (outflowRequest.getSoldPrice() <= 0.0) {
        throw new CustomValidationException("цена продажи должна быть больше 0");
      }
    }

    if(outflowRequest.getType().equals("sold")) {
      storageProductService.sellStorageProduct(storageProductId, outflowRequest);
    } else {
      storageProductService.writeOffStorageProduct(storageProductId, outflowRequest);
    }

    return ResponseEntity.ok().body("{}");
  }
}
