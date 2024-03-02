package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.info.PredictionDataDTO;
import com.vasiliy.project.entity.records.SoldRecord;
import com.vasiliy.project.entity.records.WrittenOffRecord;
import com.vasiliy.project.repository.SoldRecordRepository;
import com.vasiliy.project.repository.WrittenOffRecordRepository;
import com.vasiliy.project.service.PredictionService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PredictionServiceImpl implements PredictionService {

  private final SoldRecordRepository soldRecordRepository;
  private final WrittenOffRecordRepository writtenOffRecordRepository;


  @Override
  public List<Integer> collectOutflowData(Long productId, Long numberOfLastWeeks) {
    int currentOutflowValue;
    boolean hasOutflowedAlready = false;
    List<Integer> outflowValues = new ArrayList<>();


    // Определяем временные пределы, в которых собираются данные
    LocalDateTime endDate = LocalDateTime.now();
    LocalDateTime startDate = endDate.minusWeeks(numberOfLastWeeks);


    // Отсеиваем записи о продажах конкретного товара в заданный период
    List<SoldRecord> soldRecords = soldRecordRepository.findAll();
    soldRecords.removeIf(obj -> !obj.getStorageProduct().getProduct().getId().equals(productId));
    soldRecords.removeIf(obj -> !isDateBetween(obj.getSoldAt(), startDate, endDate));


    // Отсеиваем записи о списаниях конкретного товара в заданный период
    List<WrittenOffRecord> writtenOffRecords = writtenOffRecordRepository.findAll();
    writtenOffRecords.removeIf(obj -> !obj.getStorageProduct().getProduct().getId().equals(productId));
    writtenOffRecords.removeIf(obj -> !isDateBetween(obj.getWrittenOffAt(), startDate, endDate));


    // Цикл, собирающий данные о расходах товара за каждый день внутри периода
    LocalDateTime counter = startDate;
    while (!counter.isAfter(endDate)) {
      currentOutflowValue = 0;

      for (SoldRecord obj : soldRecords) {
        if (obj.getSoldAt().toLocalDate().equals(counter.toLocalDate())) {
          currentOutflowValue += obj.getQuantity();
          hasOutflowedAlready = true;
        }
      }

      for (WrittenOffRecord obj : writtenOffRecords) {
        if (obj.getWrittenOffAt().toLocalDate().equals(counter.toLocalDate())) {
          currentOutflowValue += obj.getQuantity();
          hasOutflowedAlready = true;
        }
      }

      if (!hasOutflowedAlready) {
        outflowValues.add(-1);
      } else {
        outflowValues.add(currentOutflowValue);
      }

      counter = startDate.plusDays(1);
    }


    return outflowValues;
  }

  @Override
  public PredictionDataDTO getPredictionDTO(Long productId, Long numberOfLastWeeks) {
    int currentOutflowValue;
    List<Integer> weekOutflowValues = new ArrayList<>();
    List<Integer> monthOutflowValues = new ArrayList<>();
    PredictionDataDTO predictionDataDTO = new PredictionDataDTO();


    // Собираем данные о расходе товара за последние numberOfLastWeeks недель
    List<Integer> outflowValues = collectOutflowData(productId, numberOfLastWeeks);


    // Удаляем лишние данные. Если ничего не осталось, значит, нечего анализировать - сразу возвращаем соответствующий результат.
    outflowValues.removeIf(element -> element.equals(-1));

    if (outflowValues.isEmpty()) {
      predictionDataDTO.setWeeksAnalyzed(0);
      predictionDataDTO.setMonthsAnalyzed(0);
      predictionDataDTO.setNextWeekOutflowPrediction(0);
      predictionDataDTO.setNextMonthOutflowPrediction(0);

      return predictionDataDTO;
    }


    // Добиваем число дней до кратного 7, если необходимо (т.к. метод использует недели)
    long missingDays = outflowValues.size() % 7;
    Collections.reverse(outflowValues);

    for (int i = 0; i < missingDays; i++) {
      outflowValues.add(0);
    }

    Collections.reverse(outflowValues);


    // Собираем список расхода товаров по неделям.
    // Проход по неделям
    for (int i = 0; i < outflowValues.size() / 7; i++) {
      currentOutflowValue = 0;

      // Проход по дням в неделе
      for (int j = 0; j < 7; j++) {
        currentOutflowValue += outflowValues.get(i * 7 + j);
      }

      weekOutflowValues.add(currentOutflowValue);
    }


    // Пытаемся собрать список расхода товаров по месяцам. Если недель меньше 4, то список будет пустым.
    // Проход по месяцам
    for (int i = 1; i <= weekOutflowValues.size() / 4; i++) {
      currentOutflowValue = 0;

      // Проход по неделям в месяце
      for (int j = 0; j < 4; j++) {
        currentOutflowValue += outflowValues.get((i-1) * 4 + j);
      }

      monthOutflowValues.add(currentOutflowValue);
    }


    // Указываем количество проанализированных недель и месяцев
    predictionDataDTO.setWeeksAnalyzed(weekOutflowValues.size());
    predictionDataDTO.setMonthsAnalyzed(monthOutflowValues.size());


    // Проводим прогнозирование на следующую неделю
    predictionDataDTO.setNextWeekOutflowPrediction(getNextWeekPrediction(weekOutflowValues));


    // Проводим прогнозирование на следующий месяц (если накопилось данных хотя бы на месяц)
    if (!monthOutflowValues.isEmpty()) {
      predictionDataDTO.setNextMonthOutflowPrediction(getNextMonthPrediction(monthOutflowValues));
    } else {
      predictionDataDTO.setNextMonthOutflowPrediction(0);
    }


    return predictionDataDTO;
  }

  @Override
  public Integer getNextWeekPrediction(List<Integer> weekOutflowValues) {
    int outflowValue;


    // Параметр сглаживания (чем выше, тем больший вес имеют более новые значения, и тем меньший - существующий прогноз)
    double alpha = 0.3;

    // Вычисляем начальное значение прогноза
    double forecast = weekOutflowValues.get(0);


    // Применяем метод экспоненциального сглаживания для прогнозирования на следующую неделю
    for (int i = 1; i < weekOutflowValues.size(); i++) {
      outflowValue = weekOutflowValues.get(i);
      forecast = alpha * outflowValue + (1 - alpha) * forecast;
    }


    // Проводим округление до целого значения в большую сторону
    return (int) Math.ceil(forecast);
  }

  @Override
  public Integer getNextMonthPrediction(List<Integer> monthOutflowValues) {
    int outflowValue;


    // Параметр сглаживания (чем выше, тем больший вес имеют более новые значения, и тем меньший - существующий прогноз)
    double alpha = 0.3;

    // Вычисляем начальное значение прогноза
    double forecast = monthOutflowValues.get(0);


    // Применяем метод экспоненциального сглаживания для прогнозирования на следующий месяц
    for (int i = 1; i < monthOutflowValues.size(); i++) {
      outflowValue = monthOutflowValues.get(i);
      forecast = alpha * outflowValue + (1 - alpha) * forecast;
    }


    // Проводим округление до целого значения в большую сторону
    return (int) Math.ceil(forecast);
  }

  @Override
  public Boolean isDateBetween(LocalDateTime dateTime, LocalDateTime startDate, LocalDateTime endDate) {
    return !dateTime.isBefore(startDate) && !dateTime.isAfter(endDate);
  }
}
