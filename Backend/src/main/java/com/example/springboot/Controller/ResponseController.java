package com.example.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springboot.Entity.Response;
import com.example.springboot.Service.ResponseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @GetMapping
    public List<Response> getAllResponses() {
        return responseService.getAllResponses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getResponseById(@PathVariable Long id) {
        Optional<Response> response = responseService.getResponseById(id);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Response> createResponse(@RequestBody Response response) {
        Response savedResponse = responseService.saveResponse(response);
        return ResponseEntity.ok(savedResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateResponse(@PathVariable Long id, @RequestBody Response response) {
        if (!responseService.getResponseById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        response.setId(id);
        Response updatedResponse = responseService.saveResponse(response);
        return ResponseEntity.ok(updatedResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponse(@PathVariable Long id) {
        if (!responseService.getResponseById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        responseService.deleteResponse(id);
        return ResponseEntity.noContent().build();
    }
}
