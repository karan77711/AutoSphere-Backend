package com.vehicle.vehiclerental.mapper;

import com.vehicle.vehiclerental.dto.RentalDTO;
import com.vehicle.vehiclerental.entity.Rental;

public class RentalMapper {

    public static RentalDTO toDTO(Rental rental) {
        if (rental == null) return null;
        RentalDTO dto = new RentalDTO();
        dto.setId(rental.getId());
        dto.setUserId(rental.getUserId());
        dto.setCarName(rental.getCarName());
        dto.setPricePerDay(rental.getPricePerDay());
        dto.setStartDate(rental.getStartDate());
        dto.setEndDate(rental.getEndDate());
        return dto;
    }

    public static Rental toEntity(RentalDTO dto) {
        if (dto == null) return null;
        Rental rental = new Rental();
        rental.setId(dto.getId());
        rental.setUserId(dto.getUserId());
        rental.setCarName(dto.getCarName());
        rental.setPricePerDay(dto.getPricePerDay());
        rental.setStartDate(dto.getStartDate());
        rental.setEndDate(dto.getEndDate());
        return rental;
    }
}
