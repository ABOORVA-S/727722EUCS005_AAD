package com.example.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.Entity.Admin;
import com.example.springboot.Service.AdminService;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the origin as per your frontend's URL
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/signup")
    public Admin registerAdmin(@RequestBody Admin admin) {
        return adminService.registerAdmin(admin);
    }
}
