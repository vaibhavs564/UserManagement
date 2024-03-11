package com.practice.UserManagement.controller;

import com.practice.UserManagement.dao.User;
import com.practice.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("alluserlist", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newuser";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
