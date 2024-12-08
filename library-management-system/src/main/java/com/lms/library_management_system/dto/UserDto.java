package com.lms.library_management_system.dto;

import lombok.Getter;
import lombok.Setter;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */
@Getter
@Setter
public class UserDto {

    private int userId;
    private String name;
    private long phoneNumber;
    private String email;
}
