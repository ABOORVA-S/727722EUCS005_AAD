package com.example.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.Entity.AdmissionForm;

@Repository
public interface AdmissionFormRepository extends JpaRepository<AdmissionForm, Long> {
}
