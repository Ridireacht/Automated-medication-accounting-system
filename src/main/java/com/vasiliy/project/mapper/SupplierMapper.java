package com.vasiliy.project.mapper;

import com.vasiliy.project.dto.SupplierDTO;
import com.vasiliy.project.entity.info.Supplier;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SupplierMapper {

  Supplier mapDTOtoSupplier(SupplierDTO supplierDTO);
}
