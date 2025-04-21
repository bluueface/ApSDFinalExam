package com.example.demo.service.impl;

import com.example.demo.dto.request.SatelliteRequest;
import com.example.demo.dto.response.SatelliteResponse;
import com.example.demo.exception.SatelliteNotDecommissionedException;
import com.example.demo.exception.SatelliteNotFoundException;
import com.example.demo.model.Satellite;
import com.example.demo.repository.SatelliteRepository;
import com.example.demo.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SatelliteServiceImpl implements SatelliteService {
    private final SatelliteRepository satelliteRepository;

    @Override
    public SatelliteResponse updateSatellite(Long id, SatelliteRequest request) {
        Satellite satellite = satelliteRepository.findById(id)
                .orElseThrow(() -> new SatelliteNotFoundException(id));

        if (satellite.isDecommissioned()) {
            throw new SatelliteNotDecommissionedException();
        }

        satellite.setName(request.getName());
        satellite.setLaunchDate(request.getLaunchDate());
        satellite.setOrbitType(request.getOrbitType());
        satellite.setDecommissioned(request.isDecommissioned());

        satelliteRepository.save(satellite);

        SatelliteResponse response = new SatelliteResponse();
        response.setId(satellite.getId());
        response.setName(satellite.getName());
        response.setLaunchDate(satellite.getLaunchDate());
        response.setOrbitType(satellite.getOrbitType());
        response.setDecommissioned(satellite.isDecommissioned());

        return response;
    }
}
