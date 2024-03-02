package com.vasiliy.project.service;

import com.vasiliy.project.dto.info.PredictionDataDTO;
import java.util.List;

public interface PredictionService {

  List<Integer> collectOutflowData(Long productId, Integer numberOfLastWeeks);

  PredictionDataDTO getPredictionDTO(Long productId, Integer numberOfLastWeeks);

  Integer getNextWeekPrediction(List<Integer> weekOutflowValues);

  Integer getNextMonthPrediction(List<Integer> monthOutflowValues);
}