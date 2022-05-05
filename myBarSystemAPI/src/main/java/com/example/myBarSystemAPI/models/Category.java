package com.example.myBarSystemAPI.models;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "product_types", nullable = false)
    private ProductType productType;

    @NotNull
    @Column(name = "titles", nullable = false)
    private String title;
}
