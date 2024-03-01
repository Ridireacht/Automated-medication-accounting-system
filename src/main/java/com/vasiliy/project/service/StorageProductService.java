package com.vasiliy.project.service;

import com.vasiliy.project.dto.InflowRequest;
import com.vasiliy.project.dto.OutflowRequest;
import com.vasiliy.project.entity.StorageProduct;
import java.util.List;

public interface StorageProductService {

  List<StorageProduct> getAllStorageProducts();

  Boolean addNewStorageProduct(InflowRequest inflowRequest);

  Boolean sellStorageProduct(OutflowRequest sellRequest);

  Boolean writeOffStorageProduct(OutflowRequest writeOffRequest);
}
