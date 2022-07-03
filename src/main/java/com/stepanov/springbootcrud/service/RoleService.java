package com.stepanov.springbootcrud.service;

import com.stepanov.springbootcrud.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRoles();
    Role findRoleByName(String name);
}