package com.lms.library_management_system.service;

import com.lms.library_management_system.dao.BookDao;
import com.lms.library_management_system.dao.UserDao;
import com.lms.library_management_system.dto.BookDto;
import com.lms.library_management_system.entity.Book;
import com.lms.library_management_system.entity.User;
import com.lms.library_management_system.util.ResponseStructure;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

/**
 * Service layer for managing Book entities.
 */
@Service
public class BookService {

    private final UserDao userDao;
    private final BookDao bookDao;
    private final ModelMapper mapper;

    @Autowired
    public BookService(UserDao userDao, BookDao bookDao, ModelMapper mapper) {
        this.userDao = userDao;
        this.bookDao = bookDao;
        this.mapper = mapper;
    }

    /**
     * Save a new Book entity to the database.
     *
     * @param bookDto Data Transfer Object for the Book entity.
     * @return ResponseEntity containing ResponseStructure with the saved Book entity.
     */
    public ResponseEntity<ResponseStructure<Book>> saveBook(BookDto bookDto) {
        // Map the BookDto to a Book entity
        Book book = mapper.map(bookDto, Book.class);

        // Save the Book entity
        Book savedBook = bookDao.saveBook(book);

        // Create the response structure
        ResponseStructure<Book> responseStructure = new ResponseStructure<>();
        responseStructure.setData(savedBook);
        responseStructure.setMessage("Book Saved Successfully");
        responseStructure.setStatusCode(HttpStatus.CREATED.value());

        return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
    }

    /**
     * Retrieve a Book entity by its ID.
     *
     * @param bookId the ID of the Book to retrieve.
     * @return ResponseEntity containing ResponseStructure with the Book entity.
     */
    public ResponseEntity<ResponseStructure<Book>> getById(int bookId) {
        Optional<Book> optionalBook = Optional.ofNullable(bookDao.getBookById(bookId));

        ResponseStructure<Book> responseStructure = new ResponseStructure<>();
        if (optionalBook.isPresent()) {
            responseStructure.setData(optionalBook.get());
            responseStructure.setMessage("Book Found");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
            responseStructure.setMessage("Book Not Found");
            responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update an existing Book entity.
     *
     * @param bookId  the ID of the Book to update.
     * @param bookDto Data Transfer Object containing updated Book details.
     * @return ResponseEntity containing ResponseStructure with the updated Book entity.
     */
    public ResponseEntity<ResponseStructure<Book>> updateBook(int bookId, BookDto bookDto) {
        Optional<Book> optionalBook = Optional.ofNullable(bookDao.getBookById(bookId));

        ResponseStructure<Book> responseStructure = new ResponseStructure<>();
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();

            // Map updated fields from DTO to entity
            mapper.map(bookDto, existingBook);
            existingBook.setBookId(bookId);

            Book updatedBook = bookDao.saveBook(existingBook);
            responseStructure.setData(updatedBook);
            responseStructure.setMessage("Book Updated Successfully");
            responseStructure.setStatusCode(HttpStatus.OK.value());

            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
            responseStructure.setMessage("Book Not Found");
            responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Borrow a book by associating it with a user.
     *
     * @param bookId the ID of the book to borrow.
     * @param userId the ID of the user borrowing the book.
     * @return ResponseEntity containing ResponseStructure with the borrowed Book entity.
     */
    public ResponseEntity<ResponseStructure<Book>> borrowBook(int bookId, int userId) {
        Optional<Book> optionalBook = Optional.ofNullable(bookDao.getBookById(bookId));
        Optional<User> optionalUser = userDao.findById(userId);

        ResponseStructure<Book> responseStructure = new ResponseStructure<>();
        if (optionalBook.isPresent() && optionalUser.isPresent()) {
            Book book = optionalBook.get();
            User user = optionalUser.get();

            if (!book.isBorrowed()) {
                book.setUser(user);
                book.setBorrowedTime(LocalDateTime.now());
                book.setBorrowed(true);

                Book savedBook = bookDao.saveBook(book);
                responseStructure.setData(savedBook);
                responseStructure.setMessage("Book Borrowed Successfully");
                responseStructure.setStatusCode(HttpStatus.OK.value());

                return new ResponseEntity<>(responseStructure, HttpStatus.OK);
            } else {
                responseStructure.setMessage("Book is already borrowed");
                responseStructure.setStatusCode(HttpStatus.CONFLICT.value());
                return new ResponseEntity<>(responseStructure, HttpStatus.CONFLICT);
            }
        } else {
            responseStructure.setMessage("Book or User not found");
            responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }
    }
}
