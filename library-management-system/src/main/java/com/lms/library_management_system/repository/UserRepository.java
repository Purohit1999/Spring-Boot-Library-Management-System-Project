package com.lms.library_management_system.repository;

import com.lms.library_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
