package com.vasiliy.project.entity.info;

import com.vasiliy.project.entity.StorageProduct;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

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
