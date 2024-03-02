package com.vasiliy.project.dto.info;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PredictionDataDTO {

  private Integer weeksAnalyzed;
  private Integer monthsAnalyzed;
  private Integer nextWeekOutflowPrediction;
  private Integer nextMonthOutflowPrediction;
}
