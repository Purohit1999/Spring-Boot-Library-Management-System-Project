package com.lms.library_management_system.exception;

import lombok.Getter;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

@Getter
public class AddressIdNotFoundException extends RuntimeException {

    /**
     * Constructor for AddressIdNotFoundException.
     *
     * @param message Custom error message describing the exception.
     */
    public AddressIdNotFoundException(String message) {
        super(message); // Pass the message to the RuntimeException constructor
    }
}
