package com.example.JavaBio.Controller;

import com.example.JavaBio.Entity.Request;
import com.example.JavaBio.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {
    @Autowired
    private RequestRepository requestRepository;

    @PostMapping
    public Request createRequest(@RequestBody Request request) {
        return requestRepository.save(request);
    }

    @GetMapping
    public ResponseEntity<List<Request>> getRequestsByStatus(
            @RequestParam String status
    ) {
        return ResponseEntity.ok(requestRepository.findByStatus(status));
    }


}

