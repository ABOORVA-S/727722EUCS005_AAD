package com.example.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.Entity.PriorityInquiry;

@Repository
public interface PriorityInquiryRepository extends JpaRepository<PriorityInquiry, Long> {
}
