package com.example.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Entity.Response;
import com.example.springboot.Repository.ResponseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    public List<Response> getAllResponses() {
        return responseRepository.findAll();
    }

    public Optional<Response> getResponseById(Long id) {
        return responseRepository.findById(id);
    }

    public Response saveResponse(Response response) {
        return responseRepository.save(response);
    }

    public void deleteResponse(Long id) {
        responseRepository.deleteById(id);
    }
}
