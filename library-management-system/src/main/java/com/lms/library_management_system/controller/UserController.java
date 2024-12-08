package com.lms.library_management_system.controller;

import com.lms.library_management_system.entity.User;
import com.lms.library_management_system.service.UserService;
import com.lms.library_management_system.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<User>> update(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ResponseStructure<String>> delete(@PathVariable int userId) {
        return service.deleteUser(userId);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseStructure<List<User>>> fetchAll() {
        return service.fetchAllUsers();
    }
}
