package com.example.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.springboot.Entity.User;
import com.example.springboot.Service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the origin as per your frontend's URL
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
