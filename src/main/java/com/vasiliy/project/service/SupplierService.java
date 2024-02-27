package com.vasiliy.project.service;

import com.vasiliy.project.dto.ProductDTO;
import com.vasiliy.project.dto.SupplierDTO;
import com.vasiliy.project.entity.info.Supplier;
import java.util.List;

public interface SupplierService {
  List<Supplier> getAllSuppliers();

  Boolean addSupplier(SupplierDTO supplierDTO);

  Boolean modifySupplier(Long supplierId, SupplierDTO supplierDTO);

  Boolean deleteSupplier(Long supplierId);
}
