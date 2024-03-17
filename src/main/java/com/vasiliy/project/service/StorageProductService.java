package com.vasiliy.project.service;

import com.vasiliy.project.dto.InflowRequest;
import com.vasiliy.project.dto.OutflowRequest;
import com.vasiliy.project.entity.StorageProduct;
import com.vasiliy.project.entity.records.InflowRecord;
import com.vasiliy.project.entity.records.SoldRecord;
import com.vasiliy.project.entity.records.WrittenOffRecord;

import java.util.List;

public interface StorageProductService {

  Long getRemainingQuantityOfStorageProduct(Long storageProductId);

  List<StorageProduct> getAllStorageProducts();

  List<InflowRecord> getAllInflowRecords();

  List<SoldRecord> getAllSoldRecords();

  List<WrittenOffRecord> getAllWrittenOffRecords();

  Boolean addNewStorageProduct(InflowRequest inflowRequest);

  Boolean sellStorageProduct(Long storageProductId, OutflowRequest sellRequest);

  Boolean writeOffStorageProduct(Long storageProductId, OutflowRequest writeOffRequest);
}
