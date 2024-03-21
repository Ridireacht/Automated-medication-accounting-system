package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.info.PredictionDataDTO;
import com.vasiliy.project.repository.SoldRecordRepository;
import com.vasiliy.project.repository.WrittenOffRecordRepository;
import com.vasiliy.project.service.PredictionCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PredictionCategoryServiceImpl implements PredictionCategoryService {
    private final SoldRecordRepository soldRecordRepository;
    private final WrittenOffRecordRepository writtenOffRecordRepository;

    private final PredictionDataDTO predictionDataDTO = new PredictionDataDTO();


    @Override
    public List<Integer> collectOutflowValues(Long productId, Integer numberOfLastWeeks) {
        return null;
    }

    @Override
    public PredictionDataDTO getPredictionDTO(Long productId, Integer numberOfLastWeeks) {
        return null;
    }

    @Override
    public Integer getNextWeekPrediction(List<Integer> weekOutflowValues) {
        return null;
    }

    @Override
    public Integer getNextMonthPrediction(List<Integer> monthOutflowValues) {
        return null;
    }
}
