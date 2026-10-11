package com.vehicle.vehiclerental.dto;

import java.time.LocalDate;

public class RentalDTO {
    private Long id;
    private Long userId;
    private String carName;
    private String pricePerDay;
    private LocalDate startDate;
    private LocalDate endDate;

    public RentalDTO() {}

    public RentalDTO(Long id, Long userId, String carName,
                     String pricePerDay, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.userId = userId;
        this.carName = carName;
        this.pricePerDay = pricePerDay;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getCarName() { return carName; }
    public void setCarName(String carName) { this.carName = carName; }

    public String getPricePerDay() { return pricePerDay; }
    public void setPricePerDay(String pricePerDay) { this.pricePerDay = pricePerDay; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}
