package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.InflowRequest;
import com.vasiliy.project.dto.OutflowRequest;
import com.vasiliy.project.entity.StorageProduct;
import com.vasiliy.project.repository.InflowRecordRepository;
import com.vasiliy.project.repository.SoldRecordRepository;
import com.vasiliy.project.repository.StorageProductRepository;
import com.vasiliy.project.repository.WrittenOffRecordRepository;
import com.vasiliy.project.service.StorageProductService;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StorageProductServiceImpl implements StorageProductService {

  private final StorageProductRepository storageProductRepository;
  private final InflowRecordRepository inflowRecordRepository;
  private final SoldRecordRepository soldRecordRepository;
  private final WrittenOffRecordRepository writtenOffRecordRepository;

  
  @Override
  public List<StorageProduct> getAllStorageProducts() {
    return null;
  }

  @Override
  @Transactional
  public Boolean addNewStorageProduct(InflowRequest inflowRequest) {
    return null;
  }

  @Override
  @Transactional
  public Boolean sellStorageProduct(OutflowRequest sellRequest) {
    return null;
  }

  @Override
  @Transactional
  public Boolean writeOffStorageProduct(OutflowRequest writeOffRequest) {
    return null;
  }
}
