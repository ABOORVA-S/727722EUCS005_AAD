package com.example.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springboot.Entity.PriorityInquiry;
import com.example.springboot.Service.PriorityInquiryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inquiries")
public class PrioritySettingController {

    @Autowired
    private PriorityInquiryService priorityInquiryService;

    @GetMapping
    public List<PriorityInquiry> getAllInquiries() {
        return priorityInquiryService.getAllInquiries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriorityInquiry> getInquiryById(@PathVariable Long id) {
        Optional<PriorityInquiry> inquiry = priorityInquiryService.getInquiryById(id);
        return inquiry.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PriorityInquiry createInquiry(@RequestBody PriorityInquiry inquiry) {
        return priorityInquiryService.saveInquiry(inquiry);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriorityInquiry> updateInquiry(@PathVariable Long id, @RequestBody PriorityInquiry inquiry) {
        if (!priorityInquiryService.getInquiryById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        inquiry.setId(id);
        PriorityInquiry updatedInquiry = priorityInquiryService.saveInquiry(inquiry);
        return ResponseEntity.ok(updatedInquiry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInquiry(@PathVariable Long id) {
        if (!priorityInquiryService.getInquiryById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        priorityInquiryService.deleteInquiry(id);
        return ResponseEntity.noContent().build();
    }
}
