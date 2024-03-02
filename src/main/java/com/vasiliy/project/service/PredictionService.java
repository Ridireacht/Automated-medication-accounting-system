package com.vasiliy.project.service;

import com.vasiliy.project.dto.info.PredictionDataDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface PredictionService {

  List<Integer> collectOutflowData(Long productId, Long numberOfLastWeeks);

  PredictionDataDTO getPredictionDTO(Long productId, Long numberOfLastWeeks);

  Integer getNextWeekPrediction(List<Integer> weekOutflowValues);

  Integer getNextMonthPrediction(List<Integer> monthOutflowValues);

  Boolean isDateBetween(LocalDateTime dateTime, LocalDateTime startDate, LocalDateTime endDate);
}