package com.example.myBarSystemAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "subtypes", nullable = false)
    private String subtype;

    @NotNull
    @Column(name = "brands", nullable = false)
    private String brand;

    @NotNull
    @Column(name = "prices", nullable = false)
    private double price;

    @NotNull
    @Column(name = "quantities", nullable = false)
    private double quantity;

    @ManyToOne
    private ProductType productType;
}
