package com.anshul.LoginAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Customers")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="first_name",nullable=false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email",nullable=false,unique=true)
    private String email;

    @Column(name="password",nullable = false)
    private String password;

}