package com.stepanov.springbootcrud.service;

import com.stepanov.springbootcrud.dao.RoleRepository;
import com.stepanov.springbootcrud.dao.UserRepository;
import com.stepanov.springbootcrud.model.Role;
import com.stepanov.springbootcrud.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public List<User> findAll() {

        List<User> result = userRepository.findAll();

        return result;
    }

    @Override
    public User findById(int id) {

        Optional<User> result = userRepository.findById(id);

        User user;

        if (result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException();
        }
        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
