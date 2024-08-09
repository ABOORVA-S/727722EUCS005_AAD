package com.example.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Entity.Inquiry;
import com.example.springboot.Repository.InquiryRepository;

@Service
public class InquiryService {

    @Autowired
    private InquiryRepository inquiryRepository;

    public Inquiry saveInquiry(Inquiry inquiry) {
        return inquiryRepository.save(inquiry);
    }
}
