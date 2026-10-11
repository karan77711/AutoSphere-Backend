package com.vehicle.vehiclerental.repository;

import com.vehicle.vehiclerental.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
