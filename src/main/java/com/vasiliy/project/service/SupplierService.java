package com.vasiliy.project.service;

import com.vasiliy.project.dto.info.SupplierDTO;
import com.vasiliy.project.dto.info.UpdateRequest;
import com.vasiliy.project.entity.info.Supplier;
import java.util.List;

public interface SupplierService {
  List<Supplier> getAllSuppliers();

  Boolean addSupplier(SupplierDTO supplierDTO);

  Boolean updateSupplier(Long supplierId, UpdateRequest updateRequest);

  Boolean deleteSupplier(Long supplierId);
}
