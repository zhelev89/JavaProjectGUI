package com.example.myBarSystemAPI.models;

import com.example.myBarSystemAPI.dataTransferObjects.userTypes.UserTypeResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @NotNull
    @Column(name = "pin", nullable = false, unique = true)
    private String pinCode;

    @ManyToOne
    private UserType userType;
}
