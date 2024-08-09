// package com.example.springboot.Service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.example.springboot.Entity.User;

// import java.util.Optional;

// @Service
// public class AuthService {
//     @Autowired
//     private UserService userService;

//     @Autowired
//     private BCryptPasswordEncoder passwordEncoder;

//     public boolean authenticate(String email, String password) {
//         Optional<User> userOpt = userService.findByEmail(email);
//         if (userOpt.isPresent()) {
//             User user = userOpt.get();
//             return passwordEncoder.matches(password, user.getPassword());
//         }
//         return false;
//     }
// }
