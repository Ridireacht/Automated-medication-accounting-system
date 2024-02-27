package com.vasiliy.project.entity.entries;

import com.vasiliy.project.entity.info.Product;
import com.vasiliy.project.entity.info.Supplier;
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
@Table(name = "written_off_records")
public class WrittenOffEntry {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Прописать связь
  private Product product;

  // Прописать связь
  private Supplier supplier;

  private Long quantity;

  @Column(name = "writtenOffAt")
  private LocalDateTime writtenOffAt;
}
