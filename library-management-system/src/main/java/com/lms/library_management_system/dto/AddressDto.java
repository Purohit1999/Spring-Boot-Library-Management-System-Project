package com.lms.library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

import lombok.Getter;
import lombok.Setter;

// POJO class (plain old Java object)

/**
 * AddressDto is a Data Transfer Object for carrying address data between processes.
 * Lombok is used to reduce boilerplate code by generating getters and setters automatically.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Integer addressId; // Make sure this matches Address entity
    private Integer houseNumber;
    private String area;
    private String city;
    private String state;
    private String country;
    private Long pincode;
}

