package com.join4.auth.Controllers;

import com.join4.auth.Models.UserModel;
import com.join4.auth.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserModel register(@RequestBody UserModel user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public UserModel login(@RequestParam String email, @RequestParam String password) {
        return userService.loginUser(email, password);
    }
}
