package com.vasiliy.project.service;

import java.time.LocalDateTime;
import java.util.List;

public interface PredictionService {

  List<Integer> collectOutflowData(Long storageProductId, Long numberOfLastWeeks);

  Boolean isDateBetween(LocalDateTime dateTime, LocalDateTime startDate, LocalDateTime endDate);
}