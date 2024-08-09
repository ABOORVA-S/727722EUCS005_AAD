package com.example.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.Entity.Inquiry;
import com.example.springboot.Service.InquiryService;

import java.io.IOException;

@RestController
@RequestMapping("/api/inquiries")
@CrossOrigin(origins = "*")
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @PostMapping("/submit")
    public String submitInquiry(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message,
            @RequestParam(value = "attachment", required = false) MultipartFile attachment) throws IOException {
        
        Inquiry inquiry = new Inquiry();
        inquiry.setName(name);
        inquiry.setEmail(email);
        inquiry.setSubject(subject);
        inquiry.setMessage(message);

        if (attachment != null && !attachment.isEmpty()) {
            inquiry.setAttachment(attachment.getBytes());
        }

        inquiryService.saveInquiry(inquiry);

        return "Inquiry submitted successfully";
    }
}
