package com.lms.library_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

/**
 * Address entity class representing the Address table in the database.
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private int addressId; // Unique ID for each address

    @NotNull(message = "House number cannot be null")
    private Integer houseNumber; // House number of the address

    @NotBlank(message = "Area cannot be blank")
    @Size(max = 100, message = "Area must be less than 100 characters")
    private String area; // Area of the address

    @NotBlank(message = "City cannot be blank")
    @Size(max = 50, message = "City must be less than 50 characters")
    private String city; // City of the address

    @NotBlank(message = "State cannot be blank")
    @Size(max = 50, message = "State must be less than 50 characters")
    private String state; // State of the address

    @NotBlank(message = "Country cannot be blank")
    @Size(max = 50, message = "Country must be less than 50 characters")
    private String country; // Country of the address

    @NotNull(message = "Pincode cannot be null")
    private Long pincode; // Pincode of the address

    // Getters and Setters (Generated Manually)
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }
}
