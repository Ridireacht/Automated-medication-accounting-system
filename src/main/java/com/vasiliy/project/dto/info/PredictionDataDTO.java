package com.vasiliy.project.dto.info;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PredictionDataDTO {

  private Double precision;
  private Long nextWeekOutflowPrediction;
  private Long nextMonthOutflowPrediction;
}
