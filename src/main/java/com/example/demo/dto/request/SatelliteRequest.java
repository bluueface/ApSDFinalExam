package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SatelliteRequest {
    @NotBlank
    private String name;

    @Past
    private LocalDate launchDate;

    @Pattern(regexp = "LEO|MEO|GEO")
    private String orbitType;

    private boolean decommissioned;
}
