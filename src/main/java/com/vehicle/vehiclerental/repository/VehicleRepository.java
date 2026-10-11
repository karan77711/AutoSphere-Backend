package com.vehicle.vehiclerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.vehiclerental.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}