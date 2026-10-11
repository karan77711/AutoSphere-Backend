package com.vehicle.vehiclerental.repository;

import com.vehicle.vehiclerental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
