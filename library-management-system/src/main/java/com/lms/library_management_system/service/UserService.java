package com.lms.library_management_system.service;

import com.lms.library_management_system.dao.UserDao;
import com.lms.library_management_system.entity.User;
import com.lms.library_management_system.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
        User updatedUser = userDao.updateUser(user);
        ResponseStructure<User> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("User updated successfully");
        responseStructure.setData(updatedUser);

        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deleteUser(int userId) {
        boolean isDeleted = userDao.deleteUser(userId);
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        if (isDeleted) {
            responseStructure.setStatusCode(HttpStatus.OK.value());
            responseStructure.setMessage("User deleted successfully");
            responseStructure.setData("Deleted User ID: " + userId);
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {
            responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
            responseStructure.setMessage("User not found");
            responseStructure.setData("User ID: " + userId + " not found");
            return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ResponseStructure<List<User>>> fetchAllUsers() {
        List<User> users = userDao.fetchAllUsers();
        ResponseStructure<List<User>> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Fetched all users successfully");
        responseStructure.setData(users);

        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }
}
