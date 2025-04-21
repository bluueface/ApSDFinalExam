package com.example.demo.service;

import com.example.demo.dto.request.AstronautRequest;
import com.example.demo.dto.response.AstronautResponse;

import java.util.List;

public interface AstronautService {
    AstronautResponse createAstronaut(AstronautRequest request);

    List<AstronautResponse> getAllSortedByExperience(String order);
}