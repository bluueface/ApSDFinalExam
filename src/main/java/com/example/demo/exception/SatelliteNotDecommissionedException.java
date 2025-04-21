package com.example.demo.exception;

public class SatelliteNotDecommissionedException extends RuntimeException {
    public SatelliteNotDecommissionedException() {
        super("Cannot update a decommissioned satellite!");
    }
}
