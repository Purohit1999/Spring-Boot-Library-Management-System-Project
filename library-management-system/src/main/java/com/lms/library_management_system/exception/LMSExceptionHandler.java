package com.lms.library_management_system.exception;

import com.lms.library_management_system.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

/**
 * Global Exception Handler for the Library Management System.
 * This class intercepts exceptions thrown by controllers and provides structured responses.
 */
@ControllerAdvice
public class LMSExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles AddressIdNotFoundException.
     *
     * @param e The AddressIdNotFoundException instance.
     * @return ResponseEntity containing a structured response with the NOT_FOUND status.
     */
    @ExceptionHandler(AddressIdNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleAddressIdNotFoundException(AddressIdNotFoundException e) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage("Address ID not found");
        responseStructure.setData(e.getMessage());
        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles BookIdNotFoundException.
     *
     * @param e The BookIdNotFoundException instance.
     * @return ResponseEntity containing a structured response with the NOT_FOUND status.
     */
    @ExceptionHandler(BookIdNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleBookIdNotFoundException(BookIdNotFoundException e) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage("Book ID not found");
        responseStructure.setData(e.getMessage());
        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles UserIdNotFoundException.
     *
     * @param e The UserIdNotFoundException instance.
     * @return ResponseEntity containing a structured response with the NOT_FOUND status.
     */
    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleUserIdNotFoundException(UserIdNotFoundException e) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage("User ID not found");
        responseStructure.setData(e.getMessage());
        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
    }
}
