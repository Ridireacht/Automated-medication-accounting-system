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
  public Long getRemainingQuantityOfStorageProduct(Long storageProductId) {
    return storageProductRepository.findById(storageProductId).get().getQuantity();
  }

  @Override
  public List<StorageProduct> getAllStorageProducts() {
    return storageProductRepository.findAll();
  }

  @Override
  @Transactional
  public Boolean addNewStorageProduct(InflowRequest inflowRequest) {
    return null;
  }

  @Override
  @Transactional
  public Boolean sellStorageProduct(Long storageProductId, OutflowRequest sellRequest) {
    return null;
  }

  @Override
  @Transactional
  public Boolean writeOffStorageProduct(Long storageProductId, OutflowRequest writeOffRequest) {
    return null;
  }
}
