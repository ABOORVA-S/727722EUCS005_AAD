package com.example.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
