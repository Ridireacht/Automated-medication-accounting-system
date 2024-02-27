package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.ProductDTO;
import com.vasiliy.project.dto.SupplierDTO;
import com.vasiliy.project.entity.info.Category;
import com.vasiliy.project.entity.info.Supplier;
import com.vasiliy.project.mapper.SupplierMapper;
import com.vasiliy.project.repository.SupplierRepository;
import com.vasiliy.project.service.SupplierService;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {
  
  private final SupplierRepository supplierRepository;

  private final SupplierMapper supplierMapper;


  @Override
  public List<Supplier> getAllSuppliers() {
    return supplierRepository.findAll();
  }

  @Override
  @Transactional
  public Boolean addSupplier(SupplierDTO supplierDTO) {
    Supplier supplier = supplierMapper.mapDTOtoSupplier(supplierDTO);
    supplierRepository.save(supplier);

    return true;
  }

  @Override
  @Transactional
  public Boolean modifySupplier(Long supplierId, SupplierDTO supplierDTO) {
    if (supplierRepository.existsById(supplierId)) {
      Supplier supplier = supplierMapper.mapDTOtoSupplier(supplierDTO);
      supplier.setId(supplierId);

      supplierRepository.save(supplier);

      return true;
    }

    return false;
  }

  @Override
  @Transactional
  public Boolean deleteSupplier(Long supplierId) {
    if (supplierRepository.existsById(supplierId)) {
      supplierRepository.deleteById(supplierId);
      return true;
    }

    return false;
  }
}
