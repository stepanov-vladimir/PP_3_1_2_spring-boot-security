package com.stepanov.springbootcrud.controller;

import com.stepanov.springbootcrud.dao.UserRepository;
import com.stepanov.springbootcrud.model.User;
import com.stepanov.springbootcrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public String showUserPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "admin/user-page";
    }
}
