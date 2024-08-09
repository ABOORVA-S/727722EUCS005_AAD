package com.example.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.Entity.Response;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}
