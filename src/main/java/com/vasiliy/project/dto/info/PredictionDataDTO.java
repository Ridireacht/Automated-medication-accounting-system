package com.vasiliy.project.dto.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PredictionDataDTO {

  private Integer weeksAnalyzed;
  private Integer monthsAnalyzed;
  private Integer nextWeekOutflowPrediction;
  private Integer nextMonthOutflowPrediction;

  private List<String> labels;
  private List<Integer> outflowValues;
}
