package com.example.demo.service.impl;

import com.example.demo.dto.request.AstronautRequest;
import com.example.demo.dto.response.AstronautResponse;
import com.example.demo.dto.response.SatelliteResponse;
import com.example.demo.exception.SatelliteNotFoundException;
import com.example.demo.model.Astronaut;
import com.example.demo.model.Satellite;
import com.example.demo.repository.AstronautRepository;
import com.example.demo.repository.SatelliteRepository;
import com.example.demo.service.AstronautService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AstronautServiceImpl implements AstronautService {
    private final AstronautRepository astronautRepository;
    private final SatelliteRepository satelliteRepository;

    @Override
    public AstronautResponse createAstronaut(AstronautRequest request) {
        Astronaut astronaut = new Astronaut();
        astronaut.setFirstName(request.getFirstName());
        astronaut.setLastName(request.getLastName());
        astronaut.setExperienceYears(request.getExperienceYears());

        Set<Satellite> satellites = new HashSet<>();
        for (Long id : request.getSatelliteIds()) {
            Satellite sat = satelliteRepository.findById(id)
                    .orElseThrow(() -> new SatelliteNotFoundException(id));
            satellites.add(sat);
        }

        astronaut.setSatellites(satellites);
        astronautRepository.save(astronaut);

        AstronautResponse response = new AstronautResponse();
        response.setId(astronaut.getId());
        response.setFirstName(astronaut.getFirstName());
        response.setLastName(astronaut.getLastName());
        response.setExperienceYears(astronaut.getExperienceYears());
        response.setSatellites(
                astronaut.getSatellites().stream().map(s -> {
                    SatelliteResponse sr = new SatelliteResponse();
                    sr.setId(s.getId());
                    sr.setName(s.getName());
                    sr.setLaunchDate(s.getLaunchDate());
                    sr.setOrbitType(s.getOrbitType());
                    sr.setDecommissioned(s.isDecommissioned());
                    return sr;
                }).collect(Collectors.toList())
        );
        return response;
    }

    @Override
    public List<AstronautResponse> getAllSortedByExperience(String order) {
        List<Astronaut> astronauts = astronautRepository.findAll();
        Comparator<Astronaut> comparator = Comparator.comparingInt(Astronaut::getExperienceYears);
        if ("desc".equalsIgnoreCase(order)) comparator = comparator.reversed();

        return astronauts.stream()
                .sorted(comparator)
                .map(a -> {
                    AstronautResponse res = new AstronautResponse();
                    res.setId(a.getId());
                    res.setFirstName(a.getFirstName());
                    res.setLastName(a.getLastName());
                    res.setExperienceYears(a.getExperienceYears());
                    res.setSatellites(a.getSatellites().stream().map(s -> {
                        SatelliteResponse sr = new SatelliteResponse();
                        sr.setId(s.getId());
                        sr.setName(s.getName());
                        sr.setLaunchDate(s.getLaunchDate());
                        sr.setOrbitType(s.getOrbitType());
                        sr.setDecommissioned(s.isDecommissioned());
                        return sr;
                    }).collect(Collectors.toList()));
                    return res;
                }).collect(Collectors.toList());
    }
}
