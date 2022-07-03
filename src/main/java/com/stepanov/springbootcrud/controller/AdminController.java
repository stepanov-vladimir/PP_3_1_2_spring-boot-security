package com.stepanov.springbootcrud.controller;

import com.stepanov.springbootcrud.model.Role;
import com.stepanov.springbootcrud.model.User;
import com.stepanov.springbootcrud.service.RoleService;
import com.stepanov.springbootcrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String listAllUsers(Model model, Principal principal) {
        List<User> allUsers = userService.getAllUsers();
        User userLogin = userService.getUserByEmail(principal.getName());
        List<Role> allRoles = roleService.findAllRoles();
        User newUser = new User();

        model.addAttribute("allUsers", allUsers);
        model.addAttribute("userLogin", userLogin);
        model.addAttribute("allRoles", allRoles);
        model.addAttribute("newUser", newUser);

        return "admin/admin-page";
    }

    @PostMapping("/new")
    public String saveUser(@ModelAttribute("newUser") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    //TODO разобраться с "startsWith()"
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("editUser") User user, Principal principal) {
        if (!userService.getUserByEmail(principal.getName()).getPassword().startsWith("$")) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}