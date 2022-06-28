package com.stepanov.springbootcrud.controller;

import com.stepanov.springbootcrud.dao.UserRepository;
import com.stepanov.springbootcrud.model.User;
import com.stepanov.springbootcrud.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final MyUserDetailsService userService;

    @GetMapping
    public String currentUserName(Principal principal, Model model) {
       User user = userService.findByEmail(principal.getName());
        model.addAttribute("user", user);
       return "admin/user-page";
    }



}
