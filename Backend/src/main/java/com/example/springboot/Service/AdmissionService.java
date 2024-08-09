package com.example.springboot.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.Entity.AdmissionForm;
import com.example.springboot.Repository.AdmissionFormRepository;
import com.example.springboot.dto.AdmissionFormDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class AdmissionService {

    private final AdmissionFormRepository admissionFormRepository;
    private final Path rootLocation = Paths.get("file-uploads");

    public AdmissionService(AdmissionFormRepository admissionFormRepository) {
        this.admissionFormRepository = admissionFormRepository;
    }

    public void saveAdmissionForm(AdmissionFormDTO admissionFormDTO) {
        AdmissionForm admissionForm = new AdmissionForm();
        admissionForm.setName(admissionFormDTO.getName());
        admissionForm.setEmail(admissionFormDTO.getEmail());
        admissionForm.setPhone(admissionFormDTO.getPhone());
        admissionForm.setAddress(admissionFormDTO.getAddress());
        admissionForm.setCity(admissionFormDTO.getCity());
        admissionForm.setState(admissionFormDTO.getState());
        admissionForm.setZip(admissionFormDTO.getZip());
        admissionForm.setDob(admissionFormDTO.getDob());

        // Handle file upload
        MultipartFile file = admissionFormDTO.getFile();
        if (file != null && !file.isEmpty()) {
            try {
                Files.createDirectories(rootLocation);
                Path destinationFile = rootLocation.resolve(
                        Paths.get(file.getOriginalFilename()))
                        .normalize().toAbsolutePath();
                file.transferTo(destinationFile);
                // You can save the file path to the database if needed
            } catch (IOException e) {
                throw new RuntimeException("Failed to store file", e);
            }
        }

        admissionFormRepository.save(admissionForm);
    }
}
