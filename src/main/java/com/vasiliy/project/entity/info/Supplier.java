package com.vasiliy.project.entity.info;

import com.vasiliy.project.entity.StorageProduct;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "suppliers")
public class Supplier {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(name = "phone_number")
  private String phoneNumber;

  private String address;


  @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
  private List<StorageProduct> storageProducts;
}
