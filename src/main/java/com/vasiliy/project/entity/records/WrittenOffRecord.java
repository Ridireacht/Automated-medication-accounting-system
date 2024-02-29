package com.vasiliy.project.entity.records;

import com.vasiliy.project.entity.StorageProduct;
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
@Table(name = "written_off_records")
public class WrittenOffRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "storage_product_id")
  private StorageProduct storageProduct;

  private Long quantity;

  @Column(name = "written_off_at")
  private LocalDateTime writtenOffAt;
}
