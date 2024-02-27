package com.vasiliy.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "inflow_records")
public class InflowEntry {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Прописать связь
  private Product product;

  // Прописать связь
  private Supplier supplier;

  private Long quantity;

  @Column(name = "purchase_price")
  private Double purchasePrice;

  @Column(name = "time_of_operation")
  private LocalDateTime time;
}
