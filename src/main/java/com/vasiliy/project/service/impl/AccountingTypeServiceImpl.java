package com.vasiliy.project.service.impl;

import com.vasiliy.project.entity.info.AccountingType;
import com.vasiliy.project.repository.AccountingTypeRepository;
import com.vasiliy.project.service.AccountingTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AccountingTypeServiceImpl implements AccountingTypeService {

    private final AccountingTypeRepository accountingTypeRepository;

    @Override
    public List<AccountingType> getAllAccountingTypes() {
        return accountingTypeRepository.findAll();
    }
}
