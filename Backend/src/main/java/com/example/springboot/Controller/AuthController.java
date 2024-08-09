// package com.example.springboot.Controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.context.request.async.AsyncWebRequest;

// import com.example.springboot.Service.AdminService;

// @RestController
// @RequestMapping("/api/auth")
// @CrossOrigin(origins = "http://localhost:3000")  // Adjust as needed
// public class AuthController {
    
//     @Autowired
//     private AdminService authService;

//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody AsyncWebRequest authRequest) {
//         boolean isAuthenticated = authService.authenticate(authRequest.getEmail(), authRequest.getPassword());
//         if (isAuthenticated) {
//             return ResponseEntity.ok().body("Login successful");
//         } else {
//             return ResponseEntity.status(401).body("Invalid credentials");
//         }
//     }
// }
