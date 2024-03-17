package com.vasiliy.project.entity.records;

import com.vasiliy.project.entity.StorageProduct;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
