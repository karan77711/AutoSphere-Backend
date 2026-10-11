package com.vehicle.vehiclerental.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DefaultController {

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> root() {
        Map<String, Object> response = new HashMap<>();
        response.put("system", "AutoSphere - Vehicle Rental Management System");
        response.put("status", "ACTIVE");
        response.put("version", "1.0.0");
        response.put("description", "Enterprise Spring Boot REST API for Vehicle Rentals, Fleet Tracking and Bookings");
        return ResponseEntity.ok(response);
    }
}
