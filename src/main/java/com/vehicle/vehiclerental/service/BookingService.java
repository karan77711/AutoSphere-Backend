package com.vehicle.vehiclerental.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vehicle.vehiclerental.dto.BookingDTO;
import com.vehicle.vehiclerental.entity.Booking;
import com.vehicle.vehiclerental.mapper.BookingMapper;
import com.vehicle.vehiclerental.repository.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return BookingMapper.toDTO(booking);
    }

    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(BookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookingDTO saveBooking(Booking booking) {
        Booking saved = bookingRepository.save(booking);
        return BookingMapper.toDTO(saved);
    }
}
