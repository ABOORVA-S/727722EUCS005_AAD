package com.example.springboot.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.Service.AdmissionService;
import com.example.springboot.dto.AdmissionFormDTO;

@RestController
@RequestMapping("/api/admission")
@CrossOrigin(origins = "*")
public class AdmissionController {

    private final AdmissionService admissionService;

    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitAdmissionForm(
            @RequestPart("formData") AdmissionFormDTO admissionFormDTO,
            @RequestPart("file") MultipartFile file) {

        admissionFormDTO.setFile(file);
        admissionService.saveAdmissionForm(admissionFormDTO);
        return ResponseEntity.ok("Form Submitted Successfully");
    }
}
