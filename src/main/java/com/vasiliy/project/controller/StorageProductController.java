package com.vasiliy.project.controller;

import com.vasiliy.project.dto.InflowRequest;
import com.vasiliy.project.dto.OutflowRequest;
import com.vasiliy.project.exception.CustomBadRequestException;
import com.vasiliy.project.exception.CustomValidationException;
import com.vasiliy.project.service.StorageProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
      if (outflowRequest.getPriceSold() == null) {
        throw new CustomBadRequestException();
      } else if (outflowRequest.getPriceSold() <= 0.0) {
        throw new CustomValidationException("цена продажи должна быть больше 0");
      }
    }

    if (outflowRequest.getQuantity() > storageProductService.getRemainingQuantityOfStorageProduct(storageProductId)) {
      throw new CustomValidationException("количество не должно превышать того, что на складе");
    }

    if(outflowRequest.getType().equals("sold")) {
      storageProductService.sellStorageProduct(storageProductId, outflowRequest);
    } else {
      storageProductService.writeOffStorageProduct(storageProductId, outflowRequest);
    }

    return ResponseEntity.ok().body("{}");
  }
}
