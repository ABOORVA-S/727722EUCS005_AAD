package com.example.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Entity.PriorityInquiry;
import com.example.springboot.Repository.PriorityInquiryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PriorityInquiryService {

    @Autowired
    private PriorityInquiryRepository priorityInquiryRepository;

    public List<PriorityInquiry> getAllInquiries() {
        return priorityInquiryRepository.findAll();
    }

    public Optional<PriorityInquiry> getInquiryById(Long id) {
        return priorityInquiryRepository.findById(id);
    }

    public PriorityInquiry saveInquiry(PriorityInquiry inquiry) {
        return priorityInquiryRepository.save(inquiry);
    }

    public void deleteInquiry(Long id) {
        priorityInquiryRepository.deleteById(id);
    }
}
