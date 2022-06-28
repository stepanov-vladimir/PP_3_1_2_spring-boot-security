package com.stepanov.springbootcrud.service;

import com.stepanov.springbootcrud.model.Role;
import com.stepanov.springbootcrud.model.User;

import java.util.List;

public interface UserService  {

    List<User> findAll();

    User findById(int id);

    void save(User user);

    void deleteById(int id);

    List<Role> getRoles();
}
