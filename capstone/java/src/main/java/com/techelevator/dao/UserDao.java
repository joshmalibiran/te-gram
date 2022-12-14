package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role, String email, String picture);

    List<User> getUsersByUsername(String username);

    boolean updateUserById(int userId, String newUsername, String password, String email, String picture);
}
