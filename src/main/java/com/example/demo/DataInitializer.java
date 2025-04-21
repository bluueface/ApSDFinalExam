package com.example.demo;

import com.example.demo.model.Astronaut;
import com.example.demo.model.Satellite;
import com.example.demo.repository.AstronautRepository;
import com.example.demo.repository.SatelliteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final AstronautRepository astronautRepository;
    private final SatelliteRepository satelliteRepository;


    @Override
    public void run(String... args) {
        // Satellites
        Satellite hubble = new Satellite();
        hubble.setName("Hubble");
        hubble.setLaunchDate(LocalDate.of(1990, 4, 24));
        hubble.setOrbitType("LEO");
        hubble.setDecommissioned(false);

        Satellite starlink = new Satellite();
        starlink.setName("Starlink-17");
        starlink.setLaunchDate(LocalDate.of(2023, 8, 14));
        starlink.setOrbitType("MEO");
        starlink.setDecommissioned(false);

        Satellite sentinel = new Satellite();
        sentinel.setName("Sentinel-6");
        sentinel.setLaunchDate(LocalDate.of(2020, 11, 21));
        sentinel.setOrbitType("LEO");
        sentinel.setDecommissioned(true);

        satelliteRepository.save(hubble);
        satelliteRepository.save(starlink);
        satelliteRepository.save(sentinel);

        // Astronauts
        Astronaut neil = new Astronaut();
        neil.setFirstName("Neil");
        neil.setLastName("Armstrong");
        neil.setExperienceYears(12);
        neil.setSatellites(Set.of(hubble, starlink));

        Astronaut sally = new Astronaut();
        sally.setFirstName("Sally");
        sally.setLastName("Ride");
        sally.setExperienceYears(8);
        sally.setSatellites(Set.of(starlink));

        Astronaut chris = new Astronaut();
        chris.setFirstName("Chris");
        chris.setLastName("Hadfield");
        chris.setExperienceYears(15);
        chris.setSatellites(Set.of(hubble, sentinel));

        astronautRepository.save(neil);
        astronautRepository.save(sally);
        astronautRepository.save(chris);
    }
}
