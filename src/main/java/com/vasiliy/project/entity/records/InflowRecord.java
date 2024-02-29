package com.vasiliy.project.entity.records;

import com.vasiliy.project.entity.StorageProduct;
import com.vasiliy.project.entity.info.Product;
import com.vasiliy.project.entity.info.Supplier;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "inflow_records")
public class InflowRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "storage_product_id")
  private StorageProduct storageProduct;

  private Long quantity;

  @Column(name = "price_bought")
  private Double priceBought;

  @Column(name = "written_at")
  private LocalDateTime writtenAt;
}
