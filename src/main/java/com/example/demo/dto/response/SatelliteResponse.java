package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SatelliteResponse {
    private Long id;
    private String name;
    private LocalDate launchDate;
    private String orbitType;
    private boolean decommissioned;
}
