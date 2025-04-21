package com.example.demo.exception;

public class AstronautNotFoundException extends IllegalStateException {
    public AstronautNotFoundException(Long id) {
        super("Astronaut with ID " + id + " not found.");
    }
}