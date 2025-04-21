package com.example.demo.controller;


import com.example.demo.dto.request.SatelliteRequest;
import com.example.demo.dto.response.SatelliteResponse;
import com.example.demo.service.SatelliteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/satellites")
@RequiredArgsConstructor
public class SatelliteController {

    private final SatelliteService satelliteService;


    @PutMapping("/{id}")
    public ResponseEntity<SatelliteResponse> updateSatellite(
            @PathVariable Long id,
            @Valid @RequestBody SatelliteRequest request) {
        return ResponseEntity.ok(satelliteService.updateSatellite(id, request));
    }
}
