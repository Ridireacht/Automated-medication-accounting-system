package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.InflowRequest;
import com.vasiliy.project.dto.OutflowRequest;
import com.vasiliy.project.entity.StorageProduct;
import com.vasiliy.project.entity.records.InflowRecord;
import com.vasiliy.project.mapper.StorageProductMapper;
import com.vasiliy.project.repository.InflowRecordRepository;
import com.vasiliy.project.repository.SoldRecordRepository;
import com.vasiliy.project.repository.StorageProductRepository;
import com.vasiliy.project.repository.WrittenOffRecordRepository;
import com.vasiliy.project.service.StorageProductService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
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

  private final StorageProductMapper storageProductMapper;


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
    StorageProduct storageProduct = storageProductMapper.mapInflowRequestToProduct(inflowRequest);
    storageProduct = storageProductRepository.save(storageProduct);

    InflowRecord inflowRecord = new InflowRecord();
    inflowRecord.setStorageProduct(storageProduct);
    inflowRecord.setQuantity(inflowRequest.getQuantity());
    inflowRecord.setWrittenAt(LocalDateTime.now());
    inflowRecord.setPriceBought(inflowRequest.getBoughtPrice());

    inflowRecordRepository.save(inflowRecord);

    return true;
  }

  @Override
  @Transactional
  public Boolean sellStorageProduct(Long storageProductId, OutflowRequest sellRequest) {


    return true;
  }

  @Override
  @Transactional
  public Boolean writeOffStorageProduct(Long storageProductId, OutflowRequest writeOffRequest) {


    return true;
  }
}
