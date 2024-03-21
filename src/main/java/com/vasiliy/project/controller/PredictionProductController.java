package com.vasiliy.project.controller;

import com.vasiliy.project.dto.info.PredictionDataDTO;
import com.vasiliy.project.exception.CustomBadRequestException;
import com.vasiliy.project.repository.ProductRepository;
import com.vasiliy.project.service.PredictionProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/prediction-product")
public class PredictionProductController {

  private final PredictionProductService predictionProductService;

  private final ProductRepository productRepository;


  @GetMapping("/{id}")
  public PredictionDataDTO getPredictionResponse(@PathVariable("id") Long productId) {
    if (!productRepository.existsById(productId)) {
      throw new CustomBadRequestException();
    }

    return predictionProductService.getPredictionDTO(productId, 12);
  }
}
