package com.lms.library_management_system.repository;

import com.lms.library_management_system.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

/**
 * Repository interface for the Address entity.
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {
    // Additional query methods can be added here if needed
}
