package com.stepanov.springbootcrud.dao;

import com.stepanov.springbootcrud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
