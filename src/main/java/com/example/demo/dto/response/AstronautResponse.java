package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AstronautResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private int experienceYears;
    private List<SatelliteResponse> satellites;
}
