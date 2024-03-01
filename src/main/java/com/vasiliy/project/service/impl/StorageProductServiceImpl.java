package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.InflowRequest;
import com.vasiliy.project.dto.OutflowRequest;
import com.vasiliy.project.entity.StorageProduct;
import com.vasiliy.project.entity.records.InflowRecord;
import com.vasiliy.project.entity.records.SoldRecord;
import com.vasiliy.project.entity.records.WrittenOffRecord;
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
  public List<InflowRecord> getAllInflowRecords() {
    return inflowRecordRepository.findAll();
  }

  @Override
  public List<SoldRecord> getAllSoldRecords() {
    return soldRecordRepository.findAll();
  }

  @Override
  public List<WrittenOffRecord> getAllWrittenOffRecords() {
    return writtenOffRecordRepository.findAll();
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
    inflowRecord.setPriceBought(inflowRequest.getPriceBought());

    inflowRecordRepository.save(inflowRecord);

    return true;
  }

  @Override
  @Transactional
  public Boolean sellStorageProduct(Long storageProductId, OutflowRequest sellRequest) {
    StorageProduct storageProduct = storageProductRepository.findById(storageProductId).get();
    storageProduct.setQuantity(storageProduct.getQuantity() - sellRequest.getQuantity());
    storageProductRepository.save(storageProduct);

    SoldRecord soldRecord = new SoldRecord();
    soldRecord.setStorageProduct(storageProduct);
    soldRecord.setQuantity(sellRequest.getQuantity());
    soldRecord.setPriceSold(sellRequest.getPriceSold());
    soldRecord.setSoldAt(LocalDateTime.now());

    soldRecordRepository.save(soldRecord);

    return true;
  }

  @Override
  @Transactional
  public Boolean writeOffStorageProduct(Long storageProductId, OutflowRequest writeOffRequest) {
    StorageProduct storageProduct = storageProductRepository.findById(storageProductId).get();
    storageProduct.setQuantity(storageProduct.getQuantity() - writeOffRequest.getQuantity());
    storageProductRepository.save(storageProduct);

    WrittenOffRecord writtenOffRecord = new WrittenOffRecord();
    writtenOffRecord.setStorageProduct(storageProduct);
    writtenOffRecord.setQuantity(writeOffRequest.getQuantity());
    writtenOffRecord.setWrittenOffAt(LocalDateTime.now());

    writtenOffRecordRepository.save(writtenOffRecord);

    return true;
  }
}
