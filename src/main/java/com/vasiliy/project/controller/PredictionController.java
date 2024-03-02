package com.vasiliy.project.controller;

import com.vasiliy.project.dto.info.PredictionDataDTO;
import com.vasiliy.project.exception.CustomBadRequestException;
import com.vasiliy.project.repository.ProductRepository;
import com.vasiliy.project.service.PredictionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/prediction")
public class PredictionController {

  private final PredictionService predictionService;

  private final ProductRepository productRepository;


  @GetMapping("/{id}")
  public PredictionDataDTO getPredictionResponse(@PathVariable("id") Long productId) {
    if (!productRepository.existsById(productId)) {
      throw new CustomBadRequestException();
    }

    return predictionService.getPredictionDTO(productId, 12);
  }
}
