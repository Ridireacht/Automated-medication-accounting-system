package com.vasiliy.project.entity.info;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category {

  public Category(String code, String name) {
    this.code = code;
    this.name = name;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String code;

  private String name;


  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private List<Product> products;
}
