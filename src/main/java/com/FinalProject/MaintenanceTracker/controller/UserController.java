package com.FinalProject.MaintenanceTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.FinalProject.MaintenanceTracker.mapper.UserMapper;
import com.FinalProject.MaintenanceTracker.model.User;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    private final UserMapper userMapper;

    public UserController(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute User user,
            HttpSession session){

        User loggedIn = userMapper.login(user);

        if(loggedIn == null){
            return "login";
        }

        session.setAttribute("userId", loggedIn.getUserId());

        return "redirect:/vehicles";
    }

    @GetMapping("/register")
    public String register(Model model){

        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){

        userMapper.insert(user);

        return "redirect:/";
    }

}