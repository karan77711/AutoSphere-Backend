package com.vehicle.vehiclerental.mapper;

import com.vehicle.vehiclerental.dto.VehicleDTO;
import com.vehicle.vehiclerental.entity.Vehicle;

public class VehicleMapper {

    // Convert Entity → DTO
    public static VehicleDTO toDTO(Vehicle vehicle) {
        if (vehicle == null) return null;
        return new VehicleDTO(
                vehicle.getId(),
                vehicle.getModel(),
                vehicle.getBrand(),
                vehicle.getType(),
                vehicle.getPricePerDay(),
                vehicle.isAvailable()
        );
    }

    // Convert DTO → Entity
    public static Vehicle toEntity(VehicleDTO dto) {
        if (dto == null) return null;
        Vehicle vehicle = new Vehicle();
        vehicle.setId(dto.getId());
        vehicle.setModel(dto.getModel());
        vehicle.setBrand(dto.getBrand());
        vehicle.setType(dto.getType());
        vehicle.setPricePerDay(dto.getPricePerDay());
        vehicle.setAvailable(dto.isAvailable());
        return vehicle;
    }
}
