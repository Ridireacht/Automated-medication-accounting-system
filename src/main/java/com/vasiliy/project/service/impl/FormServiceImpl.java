package com.vasiliy.project.service.impl;

import com.vasiliy.project.entity.info.Form;
import com.vasiliy.project.repository.FormRepository;
import com.vasiliy.project.service.FormService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FormServiceImpl implements FormService {

    private final FormRepository formRepository;


    @Override
    public List<Form> getAllForms() {
        return formRepository.findAll();
    }
}
