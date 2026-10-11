package com.vehicle.vehiclerental.dto;

import java.time.LocalDate;

public class BookingDTO {
    private Long id;
    private Long customerId;
    private Long rentalId;
    private LocalDate bookingDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;

    public BookingDTO() {}

    public BookingDTO(Long id, Long customerId, Long rentalId,
                      LocalDate bookingDate, LocalDate startDate,
                      LocalDate endDate, double totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.rentalId = rentalId;
        this.bookingDate = bookingDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public Long getRentalId() { return rentalId; }
    public void setRentalId(Long rentalId) { this.rentalId = rentalId; }

    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}
