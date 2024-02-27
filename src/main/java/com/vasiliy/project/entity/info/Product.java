package com.vasiliy.project.entity.info;

import com.vasiliy.project.entity.info.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(name = "unit_of_measure")
  private String unitOfMeasure;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @Column(name = "is_vital")
  private Boolean isVital;
}
