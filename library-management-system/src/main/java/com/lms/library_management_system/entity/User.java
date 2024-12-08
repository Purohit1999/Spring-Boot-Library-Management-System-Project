package com.lms.library_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */
@Entity
@Getter
@Setter
@Table(name = "user1") // Corrected syntax for specifying the table name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private int id;

    private int userid;           // Unique user ID
    private String name;          // User's name
    private long phonenumber;     // User's phone number
    private String email;         // User's email address

    @OneToOne
    private Address address;      // Associated Address entity
}
