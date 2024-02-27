package com.vasiliy.project.entity.entries;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "selling_records")
public class SellingEntry {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "storage_record_id")
  private StorageEntry storageEntry;

  private Long quantity;

  @Column(name = "selling_price")
  private Double sellingPrice;
}
