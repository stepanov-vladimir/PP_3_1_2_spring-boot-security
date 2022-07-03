package com.stepanov.springbootcrud.service;

import com.stepanov.springbootcrud.model.Role;
import com.stepanov.springbootcrud.model.User;

import java.util.List;

public interface UserService  {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(Long id);

    void deleteUser(Long id);

    void updateUser(User user);

    User getUserByEmail(String email);
}
