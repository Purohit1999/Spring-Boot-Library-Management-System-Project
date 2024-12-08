package com.lms.library_management_system.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */
@Getter
@Setter
public class BookDto {

    private int bookId;
    private String title;
    private String author;
    private LocalDateTime borrowedTime;
    private LocalDateTime returnTime;
    private boolean borrowed;
}