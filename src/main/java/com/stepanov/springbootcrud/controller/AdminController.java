package com.stepanov.springbootcrud.controller;

import com.stepanov.springbootcrud.model.Role;
import com.stepanov.springbootcrud.model.User;
import com.stepanov.springbootcrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping()
    public String listAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/list-users";
    }

    @GetMapping("/new")
    public String showNewUserForm(@ModelAttribute("user") User user) {
        return "admin/new-user";
    }

    @PostMapping
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/update")
    public String updateUser(Model model, @PathVariable("id") int id) {
        User user = userService.findById(id);
        List<Role> roles = userService.getRoles();

        model.addAttribute("user", user);
        model.addAttribute("roles", roles);

        return "admin/update-user";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.save(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }
}