package com.vasiliy.project.entity;

import com.vasiliy.project.entity.info.Product;
import com.vasiliy.project.entity.info.Supplier;
import com.vasiliy.project.entity.records.InflowRecord;
import com.vasiliy.project.entity.records.SoldRecord;
import com.vasiliy.project.entity.records.WrittenOffRecord;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "storage_products")
public class StorageProduct {

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

  @Column(name = "expires_at")
  private LocalDateTime expiresAt;
  

  @OneToMany(mappedBy = "storageProduct", cascade = CascadeType.ALL)
  private List<InflowRecord> inflowRecords;

  @OneToMany(mappedBy = "storageProduct", cascade = CascadeType.ALL)
  private List<SoldRecord> soldRecords;

  @OneToMany(mappedBy = "storageProduct", cascade = CascadeType.ALL)
  private List<WrittenOffRecord> writtenOffRecords;
}
