package com.example.myBarSystemAPI.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_type")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type", unique = true, nullable = false)
    private String type;

}
