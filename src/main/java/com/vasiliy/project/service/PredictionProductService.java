package com.vasiliy.project.service;

import com.vasiliy.project.dto.info.PredictionDataDTO;

import java.util.List;

public interface PredictionProductService {

  List<Integer> collectOutflowValues(Long productId, Integer numberOfLastWeeks);

  PredictionDataDTO getPredictionDTO(Long productId, Integer numberOfLastWeeks);

  Double getNextWeekPrediction(List<Integer> weekOutflowValues);

  Double getNextMonthPrediction(List<Integer> monthOutflowValues);
}