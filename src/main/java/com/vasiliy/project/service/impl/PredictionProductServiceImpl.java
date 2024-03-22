package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.info.PredictionDataDTO;
import com.vasiliy.project.entity.records.SoldRecord;
import com.vasiliy.project.entity.records.WrittenOffRecord;
import com.vasiliy.project.repository.SoldRecordRepository;
import com.vasiliy.project.repository.WrittenOffRecordRepository;
import com.vasiliy.project.service.PredictionProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PredictionProductServiceImpl implements PredictionProductService {

  private final SoldRecordRepository soldRecordRepository;
  private final WrittenOffRecordRepository writtenOffRecordRepository;

  private final PredictionDataDTO predictionDataDTO = new PredictionDataDTO();


  @Override
  public List<Integer> collectOutflowValues(Long productId, Integer numberOfLastWeeks) {
    int dayDifference;
    List<Integer> outflowValues = new ArrayList<>();


    // Определяем временные пределы, в которых собираются данные
    LocalDateTime endDateTime = LocalDateTime.now().plusDays(1).truncatedTo(ChronoUnit.DAYS);
    LocalDateTime startDateTime = endDateTime.minusWeeks(numberOfLastWeeks).truncatedTo(ChronoUnit.DAYS);

    LocalDate startDate = startDateTime.toLocalDate();


    // Получаем записи о продажах конкретного товара в заданный период
    List<SoldRecord> soldRecords = soldRecordRepository.findAllByProductIdAndBetweenDates(productId, startDateTime, endDateTime);


    // Получаем записи о списаниях конкретного товара в заданный период
    List<WrittenOffRecord> writtenOffRecords = writtenOffRecordRepository.findAllByProductIdAndBetweenDates(productId, startDateTime, endDateTime);


    // Инициализируем список, заполненный нулями
    for (int i = 0; i < numberOfLastWeeks * 7; i++) {
      outflowValues.add(0);
    }


    // Проходимся по записям о продажах и дополняем список значениями
    for (SoldRecord obj : soldRecords) {
      dayDifference = (int) ChronoUnit.DAYS.between(startDate, obj.getSoldAt().toLocalDate());

      outflowValues.set(dayDifference, outflowValues.get(dayDifference) + obj.getQuantity().intValue());
    }

    // Проходимся по записям о списаниях и дополняем список значениями
    for (WrittenOffRecord obj : writtenOffRecords) {
      dayDifference = (int) ChronoUnit.DAYS.between(startDate, obj.getWrittenOffAt().toLocalDate());

      outflowValues.set(dayDifference, outflowValues.get(dayDifference) + obj.getQuantity().intValue());
    }


    // Удаляем лишние нули (от начала и до встречи первого ненулевого числа)
    if (soldRecords.isEmpty() && writtenOffRecords.isEmpty()) {
      return outflowValues;
    }


    // Сразу записываем результаты в респонс
    predictionDataDTO.setOutflowValues(outflowValues);


    LocalDate endDate = endDateTime.toLocalDate().minusDays(1);
    LocalDate currentDate = endDate.minusDays(outflowValues.size() - 1);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    while (!currentDate.isAfter(endDate)) {
      predictionDataDTO.getLabels().add(currentDate.format(formatter));
      currentDate = currentDate.plusDays(1);
    }


    return outflowValues;
  }

  @Override
  public PredictionDataDTO getPredictionDTO(Long productId, Integer numberOfLastWeeks) {
    int currentOutflowValue;
    List<Integer> weekOutflowValues = new ArrayList<>();
    List<Integer> monthOutflowValues = new ArrayList<>();

    predictionDataDTO.setLabels(new ArrayList<>());
    predictionDataDTO.setOutflowValues(new ArrayList<>());
    predictionDataDTO.setNextWeekOutflowPrediction(null);
    predictionDataDTO.setNextMonthOutflowPrediction(null);


    // Собираем данные о расходе товара за последние numberOfLastWeeks недель
    List<Integer> outflowValues = collectOutflowValues(productId, numberOfLastWeeks);


    // Если список пустой, то и анализировать нечего
    if (outflowValues.isEmpty()) {
      predictionDataDTO.setNextWeekOutflowPrediction(0.0);
      predictionDataDTO.setNextMonthOutflowPrediction(0.0);

      predictionDataDTO.setLabels(new ArrayList<>());
      predictionDataDTO.setOutflowValues(new ArrayList<>());

      return predictionDataDTO;
    }


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


    // Собираем список расхода товаров по месяцам.
    // Проход по месяцам
    for (int i = 0; i < weekOutflowValues.size() / 4; i++) {
      currentOutflowValue = 0;

      // Проход по неделям в месяце
      for (int j = 0; j < 4; j++) {
        currentOutflowValue += weekOutflowValues.get(i * 4 + j);
      }

      monthOutflowValues.add(currentOutflowValue);
    }


    // Проводим прогнозирование на следующую неделю
    predictionDataDTO.setNextWeekOutflowPrediction(getNextWeekPrediction(weekOutflowValues));


    // Проводим прогнозирование на следующий месяц (если накопилось данных хотя бы на месяц)
    if (!monthOutflowValues.isEmpty()) {
      predictionDataDTO.setNextMonthOutflowPrediction(getNextMonthPrediction(monthOutflowValues));
    } else {
      predictionDataDTO.setNextMonthOutflowPrediction(0.0);
    }


    return predictionDataDTO;
  }

  @Override
  public Double getNextWeekPrediction(List<Integer> weekOutflowValues) {
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
    return forecast;
  }

  @Override
  public Double getNextMonthPrediction(List<Integer> monthOutflowValues) {
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
    return forecast;
  }
}
