package com.example.demo.controller;

import com.example.demo.dto.request.AstronautRequest;
import com.example.demo.dto.response.AstronautResponse;
import com.example.demo.service.AstronautService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/astronauts")
public class AstronautController {

    private final AstronautService astronautService;


    @PostMapping
    public ResponseEntity<AstronautResponse> createAstronaut(@Valid @RequestBody AstronautRequest request) {
        return ResponseEntity.ok(astronautService.createAstronaut(request));
    }

    @GetMapping
    public ResponseEntity<List<AstronautResponse>> getAllSortedByExperience(
            @RequestParam(defaultValue = "asc") String order) {
        return ResponseEntity.ok(astronautService.getAllSortedByExperience(order));
    }
}
