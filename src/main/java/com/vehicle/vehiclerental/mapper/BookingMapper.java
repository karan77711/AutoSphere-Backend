package com.vehicle.vehiclerental.mapper;

import com.vehicle.vehiclerental.dto.BookingDTO;
import com.vehicle.vehiclerental.entity.Booking;

public class BookingMapper {

    public static BookingDTO toDTO(Booking booking) {
        if (booking == null) return null;

        Long customerId = (booking.getCustomer() != null)
                ? booking.getCustomer().getId()
                : null;

        Long rentalId = (booking.getRental() != null)
                ? booking.getRental().getId()
                : null;

        return new BookingDTO(
                booking.getId(),
                customerId,
                rentalId,
                booking.getBookingDate(),
                booking.getStartDate(),
                booking.getEndDate(),
                booking.getTotalPrice()
        );
    }

    public static Booking toEntity(BookingDTO dto) {
        if (dto == null) return null;

        Booking booking = new Booking();
        booking.setId(dto.getId());
        booking.setBookingDate(dto.getBookingDate());
        booking.setStartDate(dto.getStartDate());
        booking.setEndDate(dto.getEndDate());
        booking.setTotalPrice(dto.getTotalPrice());
        // Customer and Rental should be fetched from repository before setting
        return booking;
    }
}
