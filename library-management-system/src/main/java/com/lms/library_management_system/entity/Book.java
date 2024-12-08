package com.lms.library_management_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

/**
 * Entity class representing a Book in the library management system.
 */
@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated primary key
    private int bookId; // Unique identifier for the Book

    private String title; // Title of the Book

    private String author; // Author of the Book

    private boolean borrowed = false; // Indicates if the Book is borrowed (default: false)

    private LocalDateTime borrowedTime; // Timestamp when the Book was borrowed

    private LocalDateTime returnTime; // Timestamp when the Book is expected to be returned

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = true) // Specifies the foreign key column
    private User user; // The user who borrowed the Book

    // Optional: Custom setter for bookId to avoid issues with frameworks
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    // Optional: Custom getter for bookId (not strictly necessary as Lombok generates it)
    public int getBookId() {
        return bookId;
    }
}
