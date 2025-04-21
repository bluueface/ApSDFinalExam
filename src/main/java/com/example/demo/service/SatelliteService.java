package com.example.demo.service;

import com.example.demo.dto.request.SatelliteRequest;
import com.example.demo.dto.response.SatelliteResponse;

public interface SatelliteService {
    SatelliteResponse updateSatellite(Long id, SatelliteRequest request);
}
