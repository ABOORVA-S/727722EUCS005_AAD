package com.example.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot.Entity.Admin;
import com.example.springboot.Repository.AdminRepository;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin registerAdmin(Admin admin) {
        Optional<Admin> existingAdmin = adminRepository.findByEmail(admin.getEmail());
        if (existingAdmin.isPresent()) {
            throw new RuntimeException("Admin with email " + admin.getEmail() + " already exists.");
        }
        return adminRepository.save(admin);
    }
}
