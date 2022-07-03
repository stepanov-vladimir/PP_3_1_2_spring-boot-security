package com.stepanov.springbootcrud.controller;

import com.stepanov.springbootcrud.model.Role;
import com.stepanov.springbootcrud.model.User;
import com.stepanov.springbootcrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String currentUserName(Principal principal, Model model) {
        User loggedUser = userService.getUserByEmail(principal.getName());
        model.addAttribute("loggedUser", loggedUser);
        return "admin/user-page";
    }
}
