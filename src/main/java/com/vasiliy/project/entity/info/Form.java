package com.vasiliy.project.entity.info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "forms")
public class Form {

    public Form() {
    }

    public Form(String name) {
        this.name = name;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
    private List<Product> products;

}
