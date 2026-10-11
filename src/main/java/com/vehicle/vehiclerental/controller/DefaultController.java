package com.vehicle.vehiclerental.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Vehicle Rental Management API!";
    }
}
