package com.vehicle.vehiclerental.repository;

import com.vehicle.vehiclerental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    // later you can add custom queries like findByCustomerId or findByVehicleId
}
