package com.vasiliy.project.service;

import com.vasiliy.project.dto.InflowRequest;
import com.vasiliy.project.dto.SellRequest;
import com.vasiliy.project.dto.WriteOffRequest;
import com.vasiliy.project.entity.StorageProduct;
import java.util.List;

public interface StorageProductService {

  List<StorageProduct> getAllStorageProducts();

  Boolean addNewStorageProduct(InflowRequest inflowRequest);

  Boolean sellStorageProduct(SellRequest sellRequest);

  Boolean writeOffStorageProduct(WriteOffRequest writeOffRequest);
}
