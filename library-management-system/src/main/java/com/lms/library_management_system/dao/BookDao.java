package com.lms.library_management_system.dao;

import com.lms.library_management_system.entity.Book;
import com.lms.library_management_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

/**
 * DAO (Data Access Object) class for managing Book-related database operations.
 */
@Repository
public class BookDao {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Saves a new Book entity to the database.
     *
     * @param book the Book entity to save.
     * @return the saved Book entity.
     */
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Updates an existing Book entity in the database.
     *
     * @param book the Book entity containing updated details.
     * @return the updated Book entity if successful, otherwise null.
     */
    public Book updateBook(Book book) {
        if (bookRepository.existsById(book.getBookId())) {
            return bookRepository.save(book);
        }
        return null;
    }

    /**
     * Retrieves a Book entity by its ID.
     *
     * @param bookId the ID of the Book to retrieve.
     * @return the Book entity if found, otherwise null.
     */
    public Book getBookById(int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    /**
     * Deletes a Book entity by its ID.
     *
     * @param bookId the ID of the Book to delete.
     * @return true if the Book entity was deleted successfully, otherwise false.
     */
    public boolean deleteBookById(int bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            return true;
        }
        return false;
    }
}
