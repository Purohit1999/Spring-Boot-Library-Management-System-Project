package com.lms.library_management_system.controller;

import com.lms.library_management_system.dto.BookDto;
import com.lms.library_management_system.entity.Book;
import com.lms.library_management_system.service.BookService;
import com.lms.library_management_system.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

/**
 * Controller class to manage Book-related APIs.
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody BookDto bookDto) {
        return bookService.saveBook(bookDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Book>> getById(@PathVariable int id) {
        return bookService.getById(id);
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<Book>> updateBook(@RequestParam int id, @RequestBody BookDto bookDto) {
        return bookService.updateBook(id, bookDto);
    }

    @PutMapping("/borrow/{bookId}/{userId}")
    public ResponseEntity<ResponseStructure<Book>> borrowBook(@PathVariable int bookId, @PathVariable int userId) {
        return bookService.borrowBook(bookId, userId);
    }
}
