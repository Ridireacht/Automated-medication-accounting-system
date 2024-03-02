package com.vasiliy.project.service.impl;

import com.vasiliy.project.entity.records.SoldRecord;
import com.vasiliy.project.entity.records.WrittenOffRecord;
import com.vasiliy.project.repository.SoldRecordRepository;
import com.vasiliy.project.repository.WrittenOffRecordRepository;
import com.vasiliy.project.service.PredictionService;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
        }
      }

      for (WrittenOffRecord obj : writtenOffRecords) {
        if (obj.getWrittenOffAt().toLocalDate().equals(counter.toLocalDate())) {
          currentOutflowValue += obj.getQuantity();
        }
      }

      outflowValues.add(currentOutflowValue);
      counter = startDate.plusDays(1);
    }


    return outflowValues;
  }

  @Override
  public Boolean isDateBetween(LocalDateTime dateTime, LocalDateTime startDate, LocalDateTime endDate) {
    return !dateTime.isBefore(startDate) && !dateTime.isAfter(endDate);
  }
}
