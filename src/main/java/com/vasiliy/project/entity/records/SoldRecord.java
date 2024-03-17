package com.vasiliy.project.entity.records;

import com.vasiliy.project.entity.StorageProduct;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "sold_records")
public class SoldRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "storage_product_id")
  private StorageProduct storageProduct;

  private Long quantity;

  @Column(name = "price_sold")
  private Double priceSold;

  @Column(name = "sold_at")
  private LocalDateTime soldAt;
}
