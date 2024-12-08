package com.lms.library_management_system.exception;

import lombok.Getter;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

/**
 * Custom exception to handle cases where a Book ID is not found.
 */
@Getter
public class BookIdNotFoundException extends RuntimeException {

    /**
     * Constructor for BookIdNotFoundException.
     *
     * @param message Custom error message describing the exception.
     */
    public BookIdNotFoundException(String message) {
        super(message); // Pass the message to the RuntimeException constructor
    }
}
