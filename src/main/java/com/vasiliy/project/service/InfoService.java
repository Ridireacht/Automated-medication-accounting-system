package com.vasiliy.project.service;

import com.vasiliy.project.dto.ProductDTO;
import com.vasiliy.project.dto.SupplierDTO;
import com.vasiliy.project.entity.info.Product;
import com.vasiliy.project.entity.info.Supplier;
import java.util.List;

public interface InfoService {

  List<Product> getAllProducts();

  Boolean addProduct(ProductDTO productDTO);

  Boolean modifyProduct(Long productId, ProductDTO productDTO);

  Boolean deleteProduct(Long productId);

  List<Supplier> getAllSuppliers();

  Boolean addSupplier(ProductDTO productDTO);

  Boolean modifySupplier(Long supplierId, SupplierDTO supplierDTO);

  Boolean deleteSupplier(Long supplierId);
}
