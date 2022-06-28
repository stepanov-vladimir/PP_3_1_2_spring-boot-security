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

    @GetMapping()
    public String listAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/list-users";
    }

    @GetMapping("/{id}")
    public String showUserPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "users/user-page";
    }

    @GetMapping("/new")
    public String showNewUserForm(@ModelAttribute("user") User user) {
        return "users/new-user";
    }

    @PostMapping
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/update")
    public String updateUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findById(id));
        return "users/update-user";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.save(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}
