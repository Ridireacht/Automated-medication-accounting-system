package com.vasiliy.project.entity.entries;

import com.vasiliy.project.entity.info.Product;
import com.vasiliy.project.entity.enums.Status;
import com.vasiliy.project.entity.info.Supplier;
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
@Table(name = "storage_records")
public class StorageEntry {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne
  @JoinColumn(name = "supplier_id")
  private Supplier supplier;

  private Long quantity;

  @Column(name = "purchase_price")
  private Double purchasePrice;

  private Status status;

  @Column(name = "arrived_at")
  private LocalDateTime arrivedAt;

  @Column(name = "expire_at")
  private LocalDateTime expireAt;
}
