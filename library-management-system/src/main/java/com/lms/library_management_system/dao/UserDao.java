package com.lms.library_management_system.dao;

import com.lms.library_management_system.entity.User;
import com.lms.library_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

/**
 * Data Access Object (DAO) for managing User entities.
 */
@Repository
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    /**
     * Save a new User to the database.
     *
     * @param user the User entity to be saved
     * @return the saved User entity
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Update an existing User by its ID.
     *
     * @param userId the ID of the User to update
     * @param user   the User entity with updated details
     * @return the updated User entity if successful, otherwise null
     */
    public User updateUser(int userId, User user) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            User existingUser = optional.get();
            user.setId(existingUser.getId()); // Ensure the existing ID is retained
            return userRepository.save(user); // Save and return the updated User
        }
        return null;
    }

    /**
     * Find a User by its ID.
     *
     * @param userId the ID of the User to retrieve
     * @return an Optional containing the User entity if found, otherwise empty
     */
    public Optional<User> findById(int userId) {
        return userRepository.findById(userId);
    }

    /**
     * Delete a User by its ID.
     *
     * @param userId the ID of the User to delete
     * @return the deleted User entity if deletion was successful, otherwise null
     */
    public User deleteUser(int userId) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            User userToDelete = optional.get();
            userRepository.delete(userToDelete);
            return userToDelete;
        }
        return null;
    }

    /**
     * Fetch all Users from the database.
     *
     * @return a list of all User entities
     */
    public List<User> fetchUsers() {
        return userRepository.findAll();
    }
}
