package com.vasiliy.project.service.impl;

import com.vasiliy.project.dto.info.SupplierDTO;
import com.vasiliy.project.dto.info.UpdateRequest;
import com.vasiliy.project.entity.info.Supplier;
import com.vasiliy.project.mapper.SupplierMapper;
import com.vasiliy.project.repository.SupplierRepository;
import com.vasiliy.project.service.SupplierService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
  public Boolean updateSupplier(Long supplierId, UpdateRequest updateRequest) {
    if (supplierRepository.existsById(supplierId)) {
      Supplier supplier = supplierRepository.findById(supplierId).get();

      switch (updateRequest.getType()) {
        case "name" -> supplier.setName(updateRequest.getValue());
        case "phoneNumber" -> supplier.setPhoneNumber(updateRequest.getValue());
        case "address" -> supplier.setAddress(updateRequest.getValue());
      }

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
