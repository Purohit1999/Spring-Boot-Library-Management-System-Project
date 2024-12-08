package com.lms.library_management_system.repository;

import com.lms.library_management_system.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

public interface BookRepository extends JpaRepository<Book, Integer> {

    /**
     * Find books by title containing a specific keyword (case-insensitive).
     *
     * @param keyword the keyword to search for in the title
     * @return a list of books with titles containing the keyword
     */
    List<Book> findByTitleContainingIgnoreCase(String keyword);

    /**
     * Find books by a specific author.
     *
     * @param author the author name to search for
     * @return a list of books written by the specified author
     */
    List<Book> findByAuthor(String author);

    /**
     * Find books published before a specific year using a custom query.
     *
     * @param year the year to filter books published before
     * @return a list of books published before the specified year
     */
    @Query("SELECT b FROM Book b WHERE b.year < :year")
    List<Book> findBooksPublishedBefore(@Param("year") int year);
}
